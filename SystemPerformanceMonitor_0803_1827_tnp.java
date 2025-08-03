// 代码生成时间: 2025-08-03 18:27:16
package com.example.monitor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;

/**
 * Managed Bean for system performance monitoring using JSF.
 */
@ManagedBean
@RequestScoped
public class SystemPerformanceMonitor {

    private OperatingSystemMXBean operatingSystemMXBean;
    private RuntimeMXBean runtimeMXBean;
    private double cpuLoad;
    private long usedMemory;
    private long totalMemory;
    private long freeMemory;
    private long availableProcessors;

    /**
     * Constructor which initializes the MXBeans.
     */
    public SystemPerformanceMonitor() {
        operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    }

    /**
     * Retrieves the system CPU load.
     * @return CPU load percentage as a double.
     */
    public double getCpuLoad() {
        return cpuLoad;
    }

    /**
     * Retrieves the used memory in bytes.
     * @return Used memory in bytes.
     */
    public long getUsedMemory() {
        return usedMemory;
    }

    /**
     * Retrieves the total memory available in bytes.
     * @return Total memory in bytes.
     */
    public long getTotalMemory() {
        return totalMemory;
    }

    /**
     * Retrieves the free memory in bytes.
     * @return Free memory in bytes.
     */
    public long getFreeMemory() {
        return freeMemory;
    }

    /**
     * Retrieves the number of available processors.
     * @return Number of available processors.
     */
    public long getAvailableProcessors() {
        return availableProcessors;
    }

    /**
     * Updates the performance metrics when called.
     */
    public void updateMetrics() {
        try {
            cpuLoad = operatingSystemMXBean.getSystemCpuLoad();
            totalMemory = runtimeMXBean.getJvmMemoryUsage().getMax();
            usedMemory = runtimeMXBean.getJvmMemoryUsage().getUsed();
            freeMemory = totalMemory - usedMemory;
            availableProcessors = runtimeMXBean.getAvailableProcessors();
        } catch (Exception e) {
            // Handle exceptions related to the performance metrics update
            System.err.println("Error updating performance metrics: " + e.getMessage());
        }
    }

    // Additional methods for performance monitoring can be added here.
}
