// 代码生成时间: 2025-08-29 04:16:01
import javax.faces.context.ExceptionHandler;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.faces.event.ExceptionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ErrorLogCollector class, responsible for collecting and logging errors
public class ErrorLogCollector implements ExceptionListener {

    // Handles the exception event
    @Override
    public void processException(ExceptionQueuedEvent event) {
        try {
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
            Throwable throwable = context.getException();
            // Log the exception details
            logException(throwable);
        } catch (IOException e) {
            // Handle any IO exceptions that occur during logging
            e.printStackTrace();
        }
    }

    // Logs the exception to a file with a timestamp
    private void logException(Throwable exception) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logFileName = "error_log_" + timestamp + ".txt";
        try (FileWriter fileWriter = new FileWriter(logFileName, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println("Exception logged at: " + timestamp);
            printWriter.println("Exception Message: " + exception.getMessage());
            printWriter.println("Stack Trace: ");
            exception.printStackTrace(printWriter);
            printWriter.println("======================================");
        }
    }

    // Registers the ErrorLogCollector as an exception handler
    public static void registerExceptionHandler() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context != null) {
            ExceptionHandler exceptionHandler = context.getApplication().getExceptionHandler();
            exceptionHandler.addExceptionListener(new ErrorLogCollector());
        }
    }
}
