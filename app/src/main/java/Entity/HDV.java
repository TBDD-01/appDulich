package Entity;

public class HDV {
    private int idHDV;
    private String name;
    private String username;
    private String password;
    private String email;
    private String chungchi;

    public HDV() {
    }

    public HDV(int idHDV, String name, String username, String password, String email, String chungchi) {
        this.idHDV = idHDV;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.chungchi = chungchi;
    }
    public HDV(int idHDV,String name, String email){
        this.idHDV = idHDV;
        this.name = name;
        this.email = email;
    }

    public int getIdHDV() {
        return idHDV;
    }

    public void setIdHDV(int idHDV) {
        this.idHDV = idHDV;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChungchi() {
        return chungchi;
    }

    public void setChungchi(String chungchi) {
        this.chungchi = chungchi;
    }


}
