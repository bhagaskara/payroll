package payroll;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Bhagaskara
 */
public class FrmHome extends javax.swing.JFrame {
    
    private int c = 0;
    
    public FrmHome() {
        initComponents();
        settingFrame();
        setupPenggajian();
        setupAbsensi();
        setupKaryawan();
        setupJabatan();
        setupPengaturan();
        setupKeluar();
        setupJam();
        setupTanggal();
    }
    
    
    private void settingFrame(){
        try {
            setLocationRelativeTo(null);
            setTitle("PT. Foechs Group");
            Image icon = ImageIO.read(getClass().getResource("/res/logo.jpg"));
            btnAbsen.setVerticalTextPosition(SwingConstants.BOTTOM);
            btnAbsen.setHorizontalTextPosition(SwingConstants.CENTER);
            setIconImage(icon);
        } catch (IOException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void setupPenggajian()
    {
        btnPenggajian.addActionListener((event)->
        {
            //this.setEnabled(false);
            FrmPenggajian gaji = new FrmPenggajian();
            
            gaji.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            gaji.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                //if (JOptionPane.showConfirmDialog(gaji, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION,
                //    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    //System.exit(0);
                    gaji.dispose();
                //    }
                }
            });
            
            gaji.setVisible(true);
        });
    }
    
    private void setupKaryawan()
    {
        btnKaryawan.addActionListener((event)->
        {
            FrmKaryawan karyawan = new FrmKaryawan();
            
            karyawan.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            karyawan.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                //if (JOptionPane.showConfirmDialog(karyawan, "Are you sure to close this window?", "Really Closing?", JOptionPane.YES_NO_OPTION,
                    //JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    //System.exit(0);
                    karyawan.dispose();
                    //}
                }
            });
            
            karyawan.setVisible(true);
        });
    }
    
    private void setupJabatan()
    {
        btnJabatan.addActionListener((event)->{
            FrmJabatan jabatan = new FrmJabatan();
            
            jabatan.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            jabatan.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                
                    jabatan.dispose();
                }
            });
            jabatan.setVisible(true);
        });
    }
    
    private void setupAbsensi()
    {
        btnAbsen.addActionListener((event)->{
            FrmAbsensi absensi = new FrmAbsensi();
            
            absensi.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            absensi.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                
                    absensi.dispose();
                }
            });
            absensi.setVisible(true);
        });
    }
    
    private void setupPengaturan()
    {
        btnPengaturan.addActionListener((event)->{
            FrmSetting setting = new FrmSetting();
            setting.setVisible(true);
        });
    }
    
    private void setupKeluar()
    {
        btnKeluar.addActionListener((event)->
            {
                if (JOptionPane.showConfirmDialog(this, "Anda akan logout dari program?", "Pemberitahuan", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                                    this.dispose();
                                    FrmValidate validate = new FrmValidate();
                                    validate.setVisible(true);
                            }
            });
    }
    
    private void setupJam()
    {
        Timer timer = new Timer(500, (event)->{
            Calendar cal = Calendar.getInstance();
            String jam = cal.get(Calendar.HOUR_OF_DAY) + "";
            String menit = cal.get(Calendar.MINUTE) + "";
            String detik = cal.get(Calendar.SECOND) + "";
            
            if(detik.length() == 1)
            {
                detik = 0 + detik;
            }
            
            if(menit.length() == 1)
            {
                menit = 0 + menit;
            }
            
            if(jam.length() == 1)
            {
                jam = 0 + jam;
            }
            
            String separator = "";
            if (c % 2 == 1) {
                separator = " ";
            } else {
                separator = ":";
            }
            c++;
            txtJam.setText(jam + separator + menit + separator + detik);
            
            
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }
    
    
    private void setupTanggal()
    {
        Timer timer = new Timer(500, (event)->{
            Calendar cal = Calendar.getInstance();
            String hari = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
            String bulan = "";
            String tahun = String.valueOf(cal.get(Calendar.YEAR));
            
            switch(cal.get(Calendar.MONTH)){
                case 0:
                    bulan = "Januari";
                    break;
                case 1:
                    bulan = "Februari";
                    break;
                case 2:
                    bulan = "Maret";
                    break;
                case 3:
                    bulan = "April";
                    break;
                case 4:
                    bulan = "Mei";
                    break;
                case 5:
                    bulan = "Juni";
                    break;
                case 6:
                    bulan = "Juli";
                    break;
                case 7:
                    bulan = "Agustus";
                    break;
                case 8:
                    bulan = "September";
                    break;
                case 9:
                    bulan = "Oktober";
                    break;
                case 10:
                    bulan = "November";
                    break;
                case 11:
                    bulan = "Desember";
                    break;
                default:
                    break;
            }
            
            txtTanggal.setText(hari + " " + bulan + " " + tahun);
        });
        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnAbsen = new javax.swing.JButton();
        btnJabatan = new javax.swing.JButton();
        btnKaryawan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JLabel();
        txtJam = new javax.swing.JLabel();
        btnPengaturan = new javax.swing.JButton();
        btnPenggajian = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(52, 73, 94));

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnAbsen.setBackground(new java.awt.Color(22, 160, 133));
        btnAbsen.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAbsen.setForeground(java.awt.Color.white);
        btnAbsen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/attendance.png"))); // NOI18N
        btnAbsen.setText("Manajemen Absensi");
        btnAbsen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAbsen.setBorderPainted(false);
        btnAbsen.setFocusPainted(false);
        btnAbsen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAbsen.setMargin(new java.awt.Insets(50, 0, 100, 0));
        btnAbsen.setOpaque(true);
        btnAbsen.setRequestFocusEnabled(false);
        btnAbsen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnJabatan.setBackground(new java.awt.Color(142, 68, 173));
        btnJabatan.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnJabatan.setForeground(java.awt.Color.white);
        btnJabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/jabatan.png"))); // NOI18N
        btnJabatan.setText("Manajemen Jabatan");
        btnJabatan.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnJabatan.setBorderPainted(false);
        btnJabatan.setFocusPainted(false);
        btnJabatan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnJabatan.setOpaque(true);
        btnJabatan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnKaryawan.setBackground(new java.awt.Color(39, 174, 96));
        btnKaryawan.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnKaryawan.setForeground(java.awt.Color.white);
        btnKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/man.png"))); // NOI18N
        btnKaryawan.setText("Manajemen Karyawan");
        btnKaryawan.setBorderPainted(false);
        btnKaryawan.setFocusPainted(false);
        btnKaryawan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKaryawan.setOpaque(true);
        btnKaryawan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Menu");

        txtTanggal.setForeground(new java.awt.Color(254, 254, 254));
        txtTanggal.setText("12 Mei 2018");

        txtJam.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        txtJam.setForeground(new java.awt.Color(254, 254, 254));
        txtJam.setText("13:07");

        btnPengaturan.setBackground(new java.awt.Color(230, 126, 34));
        btnPengaturan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/setting.png"))); // NOI18N
        btnPengaturan.setBorder(null);
        btnPengaturan.setBorderPainted(false);
        btnPengaturan.setFocusPainted(false);
        btnPengaturan.setOpaque(true);

        btnPenggajian.setBackground(new java.awt.Color(231, 76, 60));
        btnPenggajian.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnPenggajian.setForeground(new java.awt.Color(254, 254, 254));
        btnPenggajian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/slip.png"))); // NOI18N
        btnPenggajian.setText("Penggajian");
        btnPenggajian.setBorder(null);
        btnPenggajian.setBorderPainted(false);
        btnPenggajian.setFocusPainted(false);
        btnPenggajian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPenggajian.setOpaque(true);
        btnPenggajian.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenggajianActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(41, 128, 185));
        btnKeluar.setForeground(new java.awt.Color(254, 254, 254));
        btnKeluar.setText("Logout");
        btnKeluar.setBorder(null);
        btnKeluar.setBorderPainted(false);
        btnKeluar.setFocusPainted(false);
        btnKeluar.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPengaturan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnAbsen, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPenggajian, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtJam)
                                    .addComponent(txtTanggal)
                                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(44, 44, 44))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtJam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTanggal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAbsen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnJabatan, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(btnPengaturan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnPenggajian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenggajianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPenggajianActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbsen;
    private javax.swing.JButton btnJabatan;
    private javax.swing.JButton btnKaryawan;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPengaturan;
    private javax.swing.JButton btnPenggajian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtJam;
    private javax.swing.JLabel txtTanggal;
    // End of variables declaration//GEN-END:variables

}
