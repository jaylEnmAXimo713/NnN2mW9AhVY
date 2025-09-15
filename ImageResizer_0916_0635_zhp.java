// 代码生成时间: 2025-09-16 06:35:33
import javax.imageio.ImageIO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
# FIXME: 处理边界情况
import java.nio.file.Path;
# 扩展功能模块
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.faces.context.FacesContext;
# 扩展功能模块
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
# 增强安全性
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.event.ActionEvent;

/**
 * ManagedBean for resizing images.
 */
@ManagedBean
# 扩展功能模块
@ViewScoped
public class ImageResizer {

    private List<String> imageFilePaths;
    private DataModel<File> selectedFiles;
    private int newWidth = 100;
# 增强安全性
    private int newHeight = 100;
    private String outputDirectory = "resized_images";

    /**
     * Default constructor.
     */
    public ImageResizer() {
        imageFilePaths = new ArrayList<>();
    }

    /**
     * Getter for imageFilePaths.
     * @return the list of image file paths.
     */
    public List<String> getImageFilePaths() {
        return imageFilePaths;
    }

    /**
     * Setter for imageFilePaths.
     * @param imageFilePaths the list of image file paths to set.
     */
    public void setImageFilePaths(List<String> imageFilePaths) {
        this.imageFilePaths = imageFilePaths;
    }

    /**
# 扩展功能模块
     * Getter for selectedFiles.
     * @return the DataModel holding the selected files.
     */
    public DataModel<File> getSelectedFiles() {
        if (selectedFiles == null) {
            selectedFiles = new ListDataModel<>();
        }
        return selectedFiles;
    }

    /**
     * Setter for selectedFiles.
     * @param selectedFiles the DataModel to set.
# 扩展功能模块
     */
    public void setSelectedFiles(DataModel<File> selectedFiles) {
        this.selectedFiles = selectedFiles;
    }

    /**
     * Getter for newWidth.
# TODO: 优化性能
     * @return the new width for resizing.
     */
    public int getNewWidth() {
# 增强安全性
        return newWidth;
    }

    /**
     * Setter for newWidth.
     * @param newWidth the new width to set.
     */
    public void setNewWidth(int newWidth) {
        this.newWidth = newWidth;
    }

    /**
     * Getter for newHeight.
     * @return the new height for resizing.
     */
    public int getNewHeight() {
        return newHeight;
    }

    /**
     * Setter for newHeight.
# 添加错误处理
     * @param newHeight the new height to set.
# TODO: 优化性能
     */
    public void setNewHeight(int newHeight) {
        this.newHeight = newHeight;
    }

    /**
# 增强安全性
     * Getter for outputDirectory.
     * @return the directory where resized images will be stored.
# 优化算法效率
     */
    public String getOutputDirectory() {
        return outputDirectory;
    }

    /**
     * Setter for outputDirectory.
     * @param outputDirectory the directory to set.
# FIXME: 处理边界情况
     */
    public void setOutputDirectory(String outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    /**
     * Method to resize images.
     * @param event the action event triggering the resize.
     */
    public void resizeImages(ActionEvent event) {
# 增强安全性
        Path outputDirPath = Paths.get(outputDirectory);
        try {
            Files.createDirectories(outputDirPath);
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to create output directory."));
            return;
        }

        for (String filePath : imageFilePaths) {
            try {
                File imageFile = new File(filePath);
                BufferedImage originalImage = ImageIO.read(imageFile);
                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
                resizedImage.getGraphics().drawImage(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);

                Path outputPath = outputDirPath.resolve(imageFile.getName());
                ImageIO.write(resizedImage, "png", outputPath.toFile());
            } catch (IOException e) {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to resize image: " + filePath));
            }
        }
# 优化算法效率
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Images resized successfully."));
# NOTE: 重要实现细节
    }

    /**
     * Method to retrieve image files from the client.
     * @param component the UI component triggering the file selection.
     * @param context the FacesContext.
     * @return a list of file paths.
     */
    public List<String> handleFileUpload(UIComponent component, FacesContext context) {
        UIInput input = (UIInput) component;
        Object value = input.getValue();
        if (value != null) {
            List<File> files = (List<File>) value;
# FIXME: 处理边界情况
            return files.stream().map(File::getPath).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
