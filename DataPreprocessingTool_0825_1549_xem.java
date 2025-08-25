// 代码生成时间: 2025-08-25 15:49:30
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * DataPreprocessingTool - A JSF Managed Bean for data cleaning and preprocessing.
 *
 * This class provides methods to clean and preprocess data, ensuring that the data is
 * ready for further analysis or processing.
 */
@ManagedBean
@ViewScoped
public class DataPreprocessingTool {

    // Placeholder for the data list
    private List<String> data;

    /**
     * Constructor for DataPreprocessingTool.
     */
    public DataPreprocessingTool() {
        this.data = new ArrayList<>();
    }

    /**
     * Adds a new data item to the list.
     *
     * @param item The new data item to add.
     */
    public void addData(String item) {
        if (item != null && !item.trim().isEmpty()) {
            this.data.add(item.trim());
        } else {
            throw new IllegalArgumentException("Data item cannot be null or empty.");
        }
    }

    /**
     * Removes leading and trailing whitespaces from all data items.
     */
    public void trimData() {
        this.data = this.data.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    /**
     * Removes any duplicate data items.
     */
    public void removeDuplicates() {
        this.data = this.data.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Converts all data items to uppercase.
     */
    public void toUpperCase() {
        this.data = this.data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Gets the list of preprocessed data.
     *
     * @return The list of preprocessed data.
     */
    public List<String> getPreprocessedData() {
        return data;
    }

    /**
     * Sets the list of data.
     *
     * @param data The list of data to set.
     */
    public void setData(List<String> data) {
        this.data = data;
    }

    /**
     * Gets the list of data.
     *
     * @return The list of data.
     */
    public List<String> getData() {
        return data;
    }
}
