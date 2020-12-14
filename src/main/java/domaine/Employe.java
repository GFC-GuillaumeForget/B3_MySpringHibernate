package domaine;

public class Employe {
    private int id;
    private String login;
    private String password;
    private String prenom;
    private String nom;
    private String email;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public Employe() {
        super();
    }

    public Employe(String login, String password, String prenom, String nom, String email, String role) {
        this.login = login;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.role = role;
    }
}
