// 代码生成时间: 2025-08-26 20:01:42
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * JsonDataFormatter is a JSF-managed bean that provides functionality to convert JSON data into different formats.
 * It is designed to be easy to understand and maintain, with proper error handling and documentation.
 */
@ManagedBean
@SessionScoped
public class JsonDataFormatter {

    private String jsonData;

    // Setter for jsonData
    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

    // Getter for jsonData
    public String getJsonData() {
        return jsonData;
    }

    /**
     * Converts the provided JSON data into a pretty-printed format.
     * 
     * @return A string representing the pretty-printed JSON data, or an error message if the conversion fails.
     */
    public String formatJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonData);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            return "Error processing JSON: " + e.getMessage();
        }
    }

    /**
     * Converts the provided JSON data into a compact format.
     * 
     * @return A string representing the compact JSON data, or an error message if the conversion fails.
     */
    public String compactJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(jsonData);
            return mapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            return "Error processing JSON: " + e.getMessage();
        }
    }
}
