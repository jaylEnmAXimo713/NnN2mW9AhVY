// 代码生成时间: 2025-08-05 07:49:33
package com.urlvalidator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.net.URL;
import java.net.MalformedURLException;

@ManagedBean
@RequestScoped
public class UrlValidatorBean {

    private String urlToValidate;
    private String validationResult;

    // Getter and setter for urlToValidate
    public String getUrlToValidate() {
        return urlToValidate;
    }

    public void setUrlToValidate(String urlToValidate) {
        this.urlToValidate = urlToValidate;
    }

    // Getter and setter for validationResult
    public String getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(String validationResult) {
        this.validationResult = validationResult;
    }

    /**
     * Validates the provided URL.
     *
     * @return A string indicating the result of the validation.
     */
    public String validateUrl() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Attempt to create a new URL object with the provided URL string.
            new URL(urlToValidate);
            validationResult = "Validation successful: The URL is valid.";
        } catch (MalformedURLException e) {
            // If an exception occurs, it means the URL is not valid.
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Validation failed: Invalid URL", "Please enter a valid URL.");
            context.addMessage(null, message);
            validationResult = "Validation failed: Invalid URL";
        }
        return "validationResult";
    }
}
