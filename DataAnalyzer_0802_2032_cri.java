// 代码生成时间: 2025-08-02 20:32:22
// DataAnalyzer.java
// 使用 JSF 框架创建的数据分析器类
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.ArrayList;

/**
 * 统计数据分析器类，用于处理和分析数据。
 */
@ManagedBean
@ViewScoped
public class DataAnalyzer {

    // 数据集合，用于存储分析的数据
    private List<Double> data = new ArrayList<>();

    // 构造函数
    public DataAnalyzer() {
        super();
    }

    /**
     * 添加数据到数据集合中。
     * 
     * @param value 需要添加的数据值。
     */
    public void addData(double value) {
        data.add(value);
    }

    /**
     * 计算并返回数据的平均值。
     * 
     * @return 数据的平均值。
     */
    public double calculateAverage() {
        if (data.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "No data to calculate average.", null));
            return 0;
        } else {
            double sum = 0;
            for (double value : data) {
                sum += value;
            }
            return sum / data.size();
        }
    }

    /**
     * 计算并返回数据的最大值。
     * 
     * @return 数据的最大值。
     */
    public double calculateMax() {
        if (data.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "No data to find max.", null));
            return 0;
        } else {
            return data.stream().max(Double::compare).orElse(0);
        }
    }

    /**
     * 计算并返回数据的最小值。
     * 
     * @return 数据的最小值。
     */
    public double calculateMin() {
        if (data.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "No data to find min.", null));
            return 0;
        } else {
            return data.stream().min(Double::compare).orElse(0);
        }
    }

    // Getter 和 Setter 方法
    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public double getAverage() {
        return calculateAverage();
    }

    public double getMax() {
        return calculateMax();
    }

    public double getMin() {
        return calculateMin();
    }
}