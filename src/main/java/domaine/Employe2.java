package domaine;

public class Employe2 {
    private int ID;
    private String login;
    private String password;
    private String prenom;
    private String nom;
    private String email;
    private String role;

    public Employe2(String login, String password, String prenom, String nom, String email, String role) {
        this.login = login;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.role = role;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
