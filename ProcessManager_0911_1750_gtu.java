// 代码生成时间: 2025-09-11 17:50:52
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "processManager")
@ViewScoped
public class ProcessManager {

    private List<String> processList = new ArrayList<>();
    private String newProcessName;

    /*
     * Default constructor.
     */
    public ProcessManager() {
        // Load existing processes if any.
    }

    /*
     * Adds a new process to the list.
     *
     * @param processName The name of the new process.
     */
    public void addProcess() {
        try {
            if (newProcessName != null && !newProcessName.isEmpty()) {
                processList.add(newProcessName);
                newProcessName = null;
            } else {
                throw new IllegalArgumentException("Process name cannot be empty.");
            }
        } catch (IllegalArgumentException e) {
            // Handle the error, e.g., display a message to the user.
        }
    }

    /*
     * Removes a process from the list.
     *
     * @param processName The name of the process to be removed.
     */
    public void removeProcess(String processName) {
        processList.remove(processName);
    }

    /*
     * Starts a process.
     *
     * @param processName The name of the process to start.
     */
    public void startProcess(String processName) {
        // Implement the logic to start a process.
    }

    /*
     * Stops a process.
     *
     * @param processName The name of the process to stop.
     */
    public void stopProcess(String processName) {
        // Implement the logic to stop a process.
    }

    /*
     * Returns the list of processes.
     *
     * @return A list of process names.
     */
    public List<String> getProcessList() {
        return processList;
    }

    /*
     * Sets the new process name.
     *
     * @param newProcessName The name of the new process.
     */
    public void setNewProcessName(String newProcessName) {
        this.newProcessName = newProcessName;
    }

    /*
     * Returns the new process name.
     *
     * @return The name of the new process.
     */
    public String getNewProcessName() {
        return newProcessName;
    }
}
