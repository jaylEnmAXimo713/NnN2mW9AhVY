// 代码生成时间: 2025-08-14 06:07:31
package com.yourcompany.urlvalidator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.net.URL;

/**
 * Validator class to check if the provided URL is valid.
 */
@FacesValidator("urlValidator")
public class UrlValidator implements Validator {
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null || !((String) value).trim().isEmpty()) {
            return;
        }
        
        try {
            // Attempt to create a URL object, if it fails, the URL is invalid.
            new URL((String) value);
        } catch (Exception e) {
            // Log the exception and throw a ValidatorException with a user-friendly message.
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid URL", "The provided URL is not valid."));
        }
    }
}
