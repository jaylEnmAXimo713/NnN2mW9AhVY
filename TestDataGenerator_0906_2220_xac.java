// 代码生成时间: 2025-09-06 22:20:09
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Managed bean for generating test data.
 */
@ManagedBean
@ViewScoped
public class TestDataGenerator {
    private List<String> testDataList = new ArrayList<>();
    private int numberOfEntries;

    /**
     * Generate test data.
     * @param context FacesContext
     */
    public void generateTestData() {
        FacesContext context = FacesContext.getCurrentInstance();
        testDataList.clear();
        for (int i = 0; i < numberOfEntries; i++) {
            String testData = generateRandomString();
            testDataList.add(testData);
        }
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Test data generated", "Total entries: " + numberOfEntries));
    }

    /**
     * Generate a random string of 10 characters.
     * @return String
     */
    private String generateRandomString() {
        Random rand = new Random();
        return "Entry-" + rand.nextInt(1000); // Simple string for demonstration purposes
    }

    /**
     * Getter for the number of entries.
     * @return int
     */
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    /**
     * Setter for the number of entries.
     * @param numberOfEntries int
     */
    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    /**
     * Getter for the test data list.
     * @return List<String>
     */
    public List<String> getTestDataList() {
        return testDataList;
    }
}
