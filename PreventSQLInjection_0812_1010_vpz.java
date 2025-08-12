// 代码生成时间: 2025-08-12 10:10:25
package com.example.security;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Managed Bean to handle SQL operations and prevent SQL injection attacks.
 */
@ManagedBean(name = "preventSQLInjectionBean")
public class PreventSQLInjection {

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

    /**
     * Method to validate user credentials and prevent SQL injection.
     * @return String indicating the success or failure of the operation.
     */
    public String validateUser() {
        try {
            // Initialize the context for database connection
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDataSource");
            Connection con = ds.getConnection();

            // Construct the prepared statement to prevent SQL injection
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            // Execute the statement
            boolean userExists = false;
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                userExists = true;
                break;
            }

            // Close the resources
            rs.close();
            pstmt.close();
            con.close();

            // Check if user exists and return the result
            if (userExists) {
                return "User validated successfully.";
            } else {
                return "User validation failed.";
            }
        } catch (SQLException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Database error: ", e.getMessage()));
            return "User validation failed due to database error.";
        } catch (NamingException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "JNDI error: ", e.getMessage()));
            return "User validation failed due to JNDI error.";
        }
    }
}
