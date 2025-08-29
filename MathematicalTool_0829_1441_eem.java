// 代码生成时间: 2025-08-29 14:41:45
package com.example.mathtools;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.math.BigDecimal;

/**
 * Managed Bean for Mathematical Tool operations
 */
@ManagedBean
@RequestScoped
public class MathematicalTool {

    private BigDecimal number1;
    private BigDecimal number2;
    private BigDecimal result;
    private String operation;
    private String errorMessage;

    // Getters and Setters
    public BigDecimal getNumber1() {
        return number1;
    }
    public void setNumber1(BigDecimal number1) {
        this.number1 = number1;
    }
    public BigDecimal getNumber2() {
        return number2;
    }
    public void setNumber2(BigDecimal number2) {
        this.number2 = number2;
    }
    public BigDecimal getResult() {
        return result;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Method to perform mathematical operations based on the selected operation.
     *
     * @return the navigation outcome.
     */
    public String calculate() {
        try {
            switch (operation) {
                case "add":
                    result = number1.add(number2);
                    break;
                case "subtract":
                    result = number1.subtract(number2);
                    break;
                case "multiply":
                    result = number1.multiply(number2);
                    break;
                case "divide":
                    if (number2.compareTo(BigDecimal.ZERO) == 0) {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    result = number1.divide(number2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation selected.");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            errorMessage = e.getMessage();
            return "error";
        }
        return "success";
    }

    // JSF Navigation
    public String navigateBack() {
        return "index?faces-redirect=true";
    }
}
