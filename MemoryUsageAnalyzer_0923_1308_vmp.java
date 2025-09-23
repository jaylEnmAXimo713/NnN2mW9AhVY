// 代码生成时间: 2025-09-23 13:08:11
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Managed bean to analyze memory usage.
 */
@ManagedBean
@ViewScoped
public class MemoryUsageAnalyzer {

    private MemoryMXBean memoryMXBean;
    private MemoryUsage heapMemoryUsage;
    private MemoryUsage nonHeapMemoryUsage;

    /**
     * Initializes the MemoryUsageAnalyzer bean.
     */
    public MemoryUsageAnalyzer() {
        this.memoryMXBean = ManagementFactory.getMemoryMXBean();
        this.heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        this.nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
    }

    /**
     * Returns the heap memory usage.
     *
     * @return the heap memory usage
     */
    public MemoryUsage getHeapMemoryUsage() {
        return heapMemoryUsage;
    }

    /**
     * Returns the non-heap memory usage.
     *
     * @return the non-heap memory usage
     */
    public MemoryUsage getNonHeapMemoryUsage() {
        return nonHeapMemoryUsage;
    }

    /**
     * Forces a GC and updates memory usage information.
     */
    public void forceGC() {
        System.gc();
        this.heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        this.nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
    }
}
