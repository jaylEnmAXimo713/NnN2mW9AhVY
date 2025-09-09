// 代码生成时间: 2025-09-09 11:56:32
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage.Severity;

/**
 * FolderOrganizer managed bean for organizing files in a directory.
 */
@ManagedBean
@ViewScoped
public class FolderOrganizer {
    
    @ManagedProperty(value = "#{param.dirPath}")
    private String dirPath;
    
    private List<String> fileCategories;
    
    /**
     * Organize files in the specified directory based on their extensions.
     * 
     * @throws IOException if an I/O error occurs.
     */
    public void organizeFiles() throws IOException {
        File directory = new File(dirPath);
        if (!directory.exists() || !directory.isDirectory()) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(Severity.ERROR, "Invalid directory path", "The provided path is not a valid directory."));
            return;
        }
        
        fileCategories = Files.walk(directory.toPath())
            .filter(Files::isRegularFile)
            .map(Path::getFileName)
            .map(Path::toString)
            .map(this::getFileCategory)
            .distinct()
            .collect(Collectors.toList());
        
        for (String category : fileCategories) {
            File categoryDir = new File(directory, category);
            if (!categoryDir.exists() && !categoryDir.mkdir()) {
                throw new IOException("Unable to create directory: " + category);
            }
            
            Files.walk(directory.toPath())
                .filter(Files::isRegularFile)
                .filter(path -> getFileCategory(path.getFileName().toString()).equals(category))
                .forEach(path -> {
                    try {
                        Files.move(path, categoryDir.toPath().resolve(path.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(Severity.ERROR, "Error moving file", "Error occurred while moving file: " + path.getFileName()));
                    }
                });
        }
    }
    
    /**
     * Determine the category of a file based on its extension.
     * 
     * @param fileName the name of the file.
     * @return the category of the file.
     */
    private String getFileCategory(String fileName) {
        int lastDot = fileName.lastIndexOf('.');
        if (lastDot == -1) {
            return "Others"; // No extension
        }
        return fileName.substring(lastDot + 1);
    }
    
    // Getter and setter for dirPath
    public String getDirPath() {
        return dirPath;
    }
    
    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }
    
    // Getter for fileCategories
    public List<String> getFileCategories() {
        return fileCategories;
    }
}
