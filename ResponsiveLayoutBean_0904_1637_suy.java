// 代码生成时间: 2025-09-04 16:37:50
package com.example.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * ManagedBean for handling responsive layout
 */
@ManagedBean
@RequestScoped
public class ResponsiveLayoutBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // Getter and setter methods
    public String getWidth() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        String width = request.getParameter("width");
        if (width != null && !width.isEmpty()) {
            return width;
        } else {
            return "defaultWidth"; // Default width if no parameter is provided
        }
    }

    public void setWidth(String width) {
        // No need to implement this method for this example
    }

    /**
     * Method to determine if the layout is responsive based on device type
     * 
     * @return A boolean indicating if the layout is responsive
     */
    public boolean isResponsiveLayout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        String userAgent = request.getHeader("User-Agent");
        // Check for mobile devices using User-Agent
        if (userAgent != null && (userAgent.contains("Mobi") || userAgent.contains("Android"))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Error handling method
     * 
     * @param message The error message to be displayed
     */
    public void handleError(String message) {
        // You can implement error handling logic here, for example, logging the error
        // and setting an error message in the request scope
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}
