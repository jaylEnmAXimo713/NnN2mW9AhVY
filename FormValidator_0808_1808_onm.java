// 代码生成时间: 2025-08-08 18:08:50
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * A custom validator for JSF forms.
 * Validates that the input is not empty and is within a specified range.
 */
@FacesValidator("formValidator")
public class FormValidator implements Validator {

    private static final String EMPTY_ERROR_MESSAGE = "Input cannot be empty.";
    private static final String RANGE_ERROR_MESSAGE = "Input must be between {0} and {1}.";

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // Check if the input is null or empty
        if (value == null || value.toString().trim().isEmpty()) {
            FacesMessage message = new FacesMessage(EMPTY_ERROR_MESSAGE);
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

        // Cast the object to a number to check range
        try {
            double number = Double.parseDouble(value.toString());
            // Define the range to check against
# 添加错误处理
            double min = 1;
            double max = 100;

            // Check if the number is within the range
            if (number < min || number > max) {
                String rangeMessage = String.format(RANGE_ERROR_MESSAGE, min, max);
                FacesMessage message = new FacesMessage(rangeMessage);
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        } catch (NumberFormatException e) {
            // Throw an exception if the input is not a valid number
            FacesMessage message = new FacesMessage("Input must be a valid number.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
# TODO: 优化性能
}
