// 代码生成时间: 2025-09-13 14:53:29
package com.example.accesscontrol;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.example.model.User;
import com.example.service.UserService;

@ManagedBean
@SessionScoped
public class AccessControlManagedBean {

    // UserService instance for user management actions
    private UserService userService;

    public AccessControlManagedBean() {
        this.userService = new UserService();
    }

    /**
     * Checks if the current user has the required permission.
     *
     * @param permission The required permission to check for.
     * @return boolean True if the user has the permission, false otherwise.
     */
    public boolean hasPermission(String permission) {
        try {
            User currentUser = userService.getCurrentUser();
            return currentUser != null && currentUser.hasPermission(permission);
        } catch (Exception e) {
            // Log the exception and handle it appropriately
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error checking permissions", e.getMessage()));
            return false;
        }
    }

    /**
     * Redirects to the login page if the current user is not authenticated or doesn't have the required permissions.
     *
     * @param permission The required permission to check for.
     */
    public void redirectToLoginIfUnauthorized(String permission) {
        if (!hasPermission(permission)) {
            // If the user is not authenticated or doesn't have the required permissions, redirect to the login page
            FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "login");
        }
    }

    // Getters and setters
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
