// 代码生成时间: 2025-08-23 08:48:07
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;

/**
 * Managed Bean for user authentication
 */
@ManagedBean(name = "authenticationService")
@SessionScoped
public class UserAuthenticationService implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{credentialsBean}")
    private CredentialsBean credentialsBean;

    // Constructor
    public UserAuthenticationService() {
        super();
    }

    /**
     * Authenticate user with given credentials
     * @param username Username of the user
     * @param password Password of the user
     * @return Boolean indicating the authentication status
     */
    public boolean authenticateUser(String username, String password) {
        // Implement your authentication logic here
        // For demonstration, assume the credentials are valid if username is "admin" and password is "password"
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            // Add a global message for the user
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Authentication Error", "Invalid username or password"));
            return false;
        }
    }

    // Getter and setter for credentialsBean
    public CredentialsBean getCredentialsBean() {
        return credentialsBean;
    }

    public void setCredentialsBean(CredentialsBean credentialsBean) {
        this.credentialsBean = credentialsBean;
    }
}

/**
 * Bean to hold user credentials
 */
@ManagedBean(name = "credentialsBean")
@SessionScoped
public class CredentialsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}