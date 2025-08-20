// 代码生成时间: 2025-08-20 23:05:27
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// 使用JSF框架的ManagedBean注解来标记这个类作为一个JSF管理的bean
@ManagedBean
@SessionScoped
public class InteractiveChartGenerator implements Serializable {
    // 为了确保bean的跨session的一致性，该类实现Serializable接口

    // 用于存储图表数据的列表
    private List<ChartData> chartDataList;

    // 构造函数
    public InteractiveChartGenerator() {
        chartDataList = new ArrayList<>();
        // 初始化一些图表数据
        initChartData();
    }

    // 初始化图表数据的方法
    private void initChartData() {
        // 这里可以添加一些默认的图表数据
        chartDataList.add(new ChartData("Series 1", 5, 10, 15, 20, 25));
        chartDataList.add(new ChartData("Series 2", 20, 25, 30, 35, 40));
    }

    // 添加新的图表数据
    public void addChartData(String seriesName, int dataPoint1, int dataPoint2, int dataPoint3, int dataPoint4, int dataPoint5) {
        chartDataList.add(new ChartData(seriesName, dataPoint1, dataPoint2, dataPoint3, dataPoint4, dataPoint5));
    }

    // 获取图表数据列表
    public List<ChartData> getChartDataList() {
        return chartDataList;
    }

    // 设置图表数据列表
    public void setChartDataList(List<ChartData> chartDataList) {
        this.chartDataList = chartDataList;
    }

    // 图表数据类
    public static class ChartData implements Serializable {
        private String seriesName;
        private int[] dataPoints;

        // 构造函数
        public ChartData(String seriesName, int dataPoint1, int dataPoint2, int dataPoint3, int dataPoint4, int dataPoint5) {
            this.seriesName = seriesName;
            dataPoints = new int[]{dataPoint1, dataPoint2, dataPoint3, dataPoint4, dataPoint5};
        }

        // Getter和Setter方法
        public String getSeriesName() {
            return seriesName;
        }
        public void setSeriesName(String seriesName) {
            this.seriesName = seriesName;
        }
        public int[] getDataPoints() {
            return dataPoints;
        }
        public void setDataPoints(int[] dataPoints) {
            this.dataPoints = dataPoints;
        }
    }
}
