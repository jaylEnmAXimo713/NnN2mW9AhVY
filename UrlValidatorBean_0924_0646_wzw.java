// 代码生成时间: 2025-09-24 06:46:16
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.net.MalformedURLException;
import java.net.URL;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.validator.Validator;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 * ManagedBean for URL validation, using JSF.
 */
@ManagedBean
@RequestScoped
@FacesValidator("urlValidator")
public class UrlValidatorBean implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;  // If the value is null, do not validate.
        }

        try {
            URL url = new URL((String) value);
            url.toURI();  // This will throw a MalformedURLException if the URL is invalid.
        } catch (MalformedURLException e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid URL", "The URL is not valid."));
        } catch (Exception e) {
            // Handle other exceptions, if necessary.
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error validating URL", "An error occurred while validating the URL."));
        }
    }
}

/**
 * XML configuration for the managed bean and validator.
 *
 * Add this to your faces-config.xml file.
 */
/*
<managed-bean>
    <managed-bean-name>urlValidatorBean</managed-bean-name>
    <managed-bean-class>com.yourpackage.UrlValidatorBean</managed-bean-class>
    <managed-bean-scope>request</managed-bean-scope>
</managed-bean>

<validator>
    <validator-id>urlValidator</validator-id>
    <validator-class>com.yourpackage.UrlValidatorBean</validator-class>
</validator>
*/
