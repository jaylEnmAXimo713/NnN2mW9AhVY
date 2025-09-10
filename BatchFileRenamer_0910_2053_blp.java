// 代码生成时间: 2025-09-10 20:53:54
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ManagedBean for batch file renaming operations.
 */
@ManagedBean
@ViewScoped
public class BatchFileRenamer {

    private List<File> selectedFiles;
    private String newFileName;
    private String newFileExtension;
    private boolean overwrite;

    // Constructor
    public BatchFileRenamer() {
        selectedFiles = new ArrayList<>();
    }

    // Getters and Setters
    public List<File> getSelectedFiles() {
        return selectedFiles;
    }

    public void setSelectedFiles(List<File> selectedFiles) {
        this.selectedFiles = selectedFiles;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getNewFileExtension() {
        return newFileExtension;
    }

    public void setNewFileExtension(String newFileExtension) {
        this.newFileExtension = newFileExtension;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    /**
     * Renames the selected files.
     *
     * @return Navigation outcome.
     */
    public String renameFiles() {
        try {
            for (File file : selectedFiles) {
                // Check if the file exists
                if (!file.exists()) {
                    continue; // Skip non-existent files
                }

                // Construct the new file name
                String newFileNameWithExtension = newFileName + getNewFileExtension();
                File newFile = new File(file.getParent(), newFileNameWithExtension);

                // Check if the new file already exists
                if (newFile.exists() && !overwrite) {
                    continue; // Skip files that already have the new name
                }

                // Rename the file
                if (file.renameTo(newFile)) {
                    System.out.println("Renamed: " + file.getName() + " to " + newFile.getName());
                } else {
                    System.out.println("Failed to rename: " + file.getName());
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during file renaming
            System.err.println("Error during file renaming: " + e.getMessage());
            return "error";
        }

        return "success";
    }
}
