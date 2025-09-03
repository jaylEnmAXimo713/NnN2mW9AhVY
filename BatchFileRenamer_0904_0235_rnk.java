// 代码生成时间: 2025-09-04 02:35:43
import java.io.File;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.validation.constraints.NotNull;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Managed Bean for Batch File Renamer application
 */
@ManagedBean
@RequestScoped
public class BatchFileRenamer {

    private static final Logger LOGGER = Logger.getLogger(BatchFileRenamer.class.getName());
    private List<File> selectedFiles = new ArrayList<>();
    private String renamePattern;

    public List<File> getSelectedFiles() {
        return selectedFiles;
    }

    public void setSelectedFiles(List<File> selectedFiles) {
        this.selectedFiles = selectedFiles;
    }

    public String getRenamePattern() {
        return renamePattern;
    }

    public void setRenamePattern(String renamePattern) {
        this.renamePattern = renamePattern;
    }

    /**
     * Method to rename the selected files based on the rename pattern
     */
    public void renameFiles() {
        if (selectedFiles.isEmpty()) {
            addMessage(FacesMessage.SEVERITY_WARN, "No files selected", "Please select one or more files to rename.");
            return;
        }

        int count = 1;
        for (File file : selectedFiles) {
            try {
                Path sourcePath = Paths.get(file.getAbsolutePath());
                BasicFileAttributes attrs = Files.readAttributes(sourcePath, BasicFileAttributes.class);
                // Ensure the file is not a directory
                if (!attrs.isDirectory()) {
                    Path targetPath = sourcePath.resolveSibling(file.getName().replace(file.getName(), getFileNameWithPattern(file.getName(), count)));
                    Files.move(sourcePath, targetPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    count++;
                } else {
                    addMessage(FacesMessage.SEVERITY_ERROR, "Invalid file selection", "The selected item is a directory. Only files can be renamed.");
                    return;
                }
            } catch (IOException e) {
                LOGGER.severe("Error renaming file: " + e.getMessage());
                addMessage(FacesMessage.SEVERITY_ERROR, "File rename error", "An error occurred while renaming a file: " + e.getMessage());
            }
        }
        addMessage(FacesMessage.SEVERITY_INFO, "Files renamed", "Selected files have been successfully renamed.");
    }

    /**
     * Helper method to generate the new file name based on the rename pattern
     */
    private String getFileNameWithPattern(String originalFileName, int sequenceNumber) {
        String newFileName = renamePattern.replace("{index}", String.valueOf(sequenceNumber));
        return newFileName;
    }

    /**
     * Helper method to add messages to the FacesContext
     */
    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
