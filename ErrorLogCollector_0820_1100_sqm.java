// 代码生成时间: 2025-08-20 11:00:21
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.el.ValueBinding;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 * ErrorLogCollector is a JSF component that collects and logs errors.
 * It can be used to add error handling to any JSF page.
 */
public class ErrorLogCollector extends UIComponentBase implements SystemEventListener, Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ErrorLogCollector.class.getName());

    /**
     * Creates a new instance of ErrorLogCollector.
     */
    public ErrorLogCollector() {
        super();
    }

    @Override
    public String getFamily() {
        return "ErrorLogCollector";
    }

    /**
     * Processes any errors caught by the JSF lifecycle and logs them.
     *
     * @param event The system event that triggered this listener.
     * @throws AbortProcessingException If the error processing is aborted.
     */
    @Override
    public void processEvent(SystemEvent event) throws AbortProcessingException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            return;
        }

        Exception e = context.getErrors().get(0);
        if (e != null) {
            logger.severe("Error caught during JSF processing: " + e.getMessage());
            context.getErrors().clear(); // Clear the error to prevent further processing
        }
    }
}
