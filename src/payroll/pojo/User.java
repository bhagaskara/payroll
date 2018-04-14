package payroll.pojo;

/**
 *
 * @author Bhagaskara
 */
public class User {
    private String username;
    private int jabatan;

    public User(String username, int jabatan) {
        this.username = username;
        this.jabatan = jabatan;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getJabatan() {
        return jabatan;
    }

    public void setJabatan(int jabatan) {
        this.jabatan = jabatan;
    }
    
}
