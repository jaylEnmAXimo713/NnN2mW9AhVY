// 代码生成时间: 2025-08-13 23:09:15
package com.example.urlvalidator;

import javax.faces.application.FacesMessage;
# 改进用户体验
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
# 改进用户体验
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.net.URL;

/**
 * Managed Bean for URL validation.
 */
@ManagedBean
@ViewScoped
@FacesValidator("urlValidator")
public class UrlValidatorBean implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // Check if the value is null or empty
        if (value == null || value.toString().trim().isEmpty()) {
            return; // Allow empty values
        }

        // Attempt to create a new URL instance with the provided value
        try {
            new URL(value.toString());
        } catch (Exception e) {
            // If the URL is invalid, throw a ValidatorException with a user-friendly error message
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid URL", "Please enter a valid URL.");
            throw new ValidatorException(message);
        }
    }
}
