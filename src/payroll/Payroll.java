/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Bhagaskara
 */
public class Payroll {
    private static final String URL = "jdbc:mysql://localhost/dbklinikintan";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789";
    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
//        String sourceFileName = "E://test.jrxml";
//        System.out.println("Compiling Report Design ...");
//        ArrayList<DataBean> dataBeanList = getDataBeanList();
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataBeanList);
//        HashMap parameters = new HashMap();
//        
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
//            String resultFilePath = JasperCompileManager.compileReportToFile(sourceFileName);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(resultFilePath,parameters,dataSource);
//            JRPdfExporter export = new JRPdfExporter();
//            export.setExporterInput(new SimpleExporterInput(jasperPrint));
//            export.setExporterOutput(new SimpleOutputStreamExporterOutput(new File("E://export_test.pdf")));
//            export.exportReport();
//            
//            JasperViewer.viewReport(jasperPrint);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        
    }
}
