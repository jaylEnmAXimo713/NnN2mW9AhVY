// 代码生成时间: 2025-09-05 04:50:15
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProcessManager is a Java class designed to manage system processes.
 * It provides functionality to list and terminate processes.
 */
@ManagedBean(name = "processManager")
@ViewScoped
public class ProcessManager {

    private List<ProcessInfo> processList;

    /**
     * Initializes the process manager and loads the process list.
     */
    public void init() {
        try {
            processList = SystemInfo.getProcessList();
        } catch (IOException e) {
            // Handle exception
            System.err.println("Error loading process list: " + e.getMessage());
            processList = null;
        }
    }

    /**
     * Terminates the process with the specified PID.
     * @param pid The process ID to terminate.
     */
    public void terminateProcess(int pid) {
        try {
            SystemInfo.terminateProcess(pid);
        } catch (IOException e) {
            // Handle exception
            System.err.println("Error terminating process: " + e.getMessage());
        }
    }

    /**
     * Gets the list of processes.
     * @return A list of process information.
     */
    public List<ProcessInfo> getProcessList() {
        return processList;
    }

    /**
     * A class representing process information.
     * It includes the process ID and name.
     */
    public static class ProcessInfo {
        private int pid;
        private String name;

        public ProcessInfo(int pid, String name) {
            this.pid = pid;
            this.name = name;
        }

        public int getPid() {
            return pid;
        }

        public String getName() {
            return name;
        }
    }
}
