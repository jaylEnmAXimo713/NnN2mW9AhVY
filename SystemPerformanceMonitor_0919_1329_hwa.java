// 代码生成时间: 2025-09-19 13:29:49
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.Optional;

/**
 * Managed Bean for System Performance Monitoring.
 * This class provides methods to retrieve system performance metrics.
 */
@ManagedBean(name = "systemPerformanceMonitor")
@ViewScoped
public class SystemPerformanceMonitor {

    // MemoryMXBean to access memory statistics
    private MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    // OperatingSystemMXBean to access OS statistics
    private OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
    // RuntimeMXBean to access runtime statistics
    private RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

    /**
     * Gets the total memory used by the JVM.
     *
     * @return Total memory usage in bytes.
     */
    public long getTotalMemoryUsed() {
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        return heapMemoryUsage.getUsed();
    }

    /**
     * Gets the total maximum memory that can be used for memory management.
     *
     * @return Maximum memory usage in bytes.
     */
    public long getTotalMemoryMax() {
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        return heapMemoryUsage.getMax();
    }

    /**
     * Gets the system uptime.
     *
     * @return System uptime in seconds.
     */
    public long getSystemUptime() {
        return runtimeMXBean.getUptime() / 1000;
    }

    /**
     * Gets the system CPU load.
     *
     * @return System CPU load as a double (value between 0 and 1).
     */
    public double getSystemCpuLoad() {
        return operatingSystemMXBean.getSystemCpuLoad();
    }

    /**
     * Gets the available processors.
     *
     * @return Number of available processors.
     */
    public int getAvailableProcessors() {
        return runtimeMXBean.getAvailableProcessors();
    }

    /**
     * Gets the system properties as a list.
     *
     * @return List of system properties.
     */
    public List<String> getSystemProperties() {
        return Optional.ofNullable(runtimeMXBean.systemProperties.values()).orElseGet(List::of);
    }

    /**
     * Gets the system name.
     *
     * @return System name.
     */
    public String getSystemName() {
        return operatingSystemMXBean.getName();
    }

    // Add more methods to monitor different system metrics as needed.

    // Getters and setters for the class properties
    // ...
}
