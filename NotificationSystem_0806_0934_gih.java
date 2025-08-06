// 代码生成时间: 2025-08-06 09:34:52
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Managed bean for message notification system.
 */
@ManagedBean
@SessionScoped
public class NotificationSystem {
    
    /**
     * List to store messages.
     */
    private List<String> messages = new ArrayList<>();
    
    /**
     * Adds a message to the list.
     * 
     * @param message The message to be added.
     */
    public void addMessage(String message) {
        if (message != null && !message.trim().isEmpty()) {
            messages.add(message);
        } else {
            // Handle the error or log it
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }
    }
    
    /**
     * Clears all messages from the list.
     */
    public void clearMessages() {
        messages.clear();
    }
    
    /**
     * Returns the list of messages.
     * 
     * @return List of messages.
     */
    public List<String> getMessages() {
        return messages;
    }
}
