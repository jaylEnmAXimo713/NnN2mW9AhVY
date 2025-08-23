// 代码生成时间: 2025-08-23 16:32:10
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.io.Serializable;

/**
 * Managed bean for mathematical calculations using JSF.
 */
@ManagedBean(name = "mathCalculationBean")
@SessionScoped
@FacesValidator("mathValidator")
public class MathCalculationTool implements Serializable, Validator {

    private double number1;
    private double number2;
    private double result;
    private String operation;
    private FacesMessage facesMessage;

    /**
     * Default constructor.
     */
    public MathCalculationTool() {
    }

    // Getters and Setters
    public double getNumber1() {
        return number1;
    }
    public void setNumber1(double number1) {
        this.number1 = number1;
    }
    public double getNumber2() {
        return number2;
    }
    public void setNumber2(double number2) {
        this.number2 = number2;
    }
    public double getResult() {
        return result;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Perform the mathematical operation based on the selected operation.
     * @return String to redirect to the result page.
     */
    public String calculate() {
        try {
            switch (operation) {
                case "add":
                    result = number1 + number2;
                    break;
                case "subtract":
                    result = number1 - number2;
                    break;
                case "multiply":
                    result = number1 * number2;
                    break;
                case "divide":
                    if (number2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = number1 / number2;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation selected.");
            }
        } catch (Exception e) {
            facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            return null;
        }
        return "result?faces-redirect=true";
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try {
            // Additional validation logic can be added here
        } catch (Exception e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", e.getMessage()));
        }
    }
}
