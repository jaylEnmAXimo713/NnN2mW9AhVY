// 代码生成时间: 2025-08-08 05:02:22
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
# NOTE: 重要实现细节

/**
 * ImageResizer is a Java class that resizes images in batch.
 * It uses JSF framework for handling web interactions.
 */
# NOTE: 重要实现细节
@ManagedBean(name = "imageResizer")
@ViewScoped
public class ImageResizer {

    private int width;
    private int height;
# NOTE: 重要实现细节
    private String directoryPath;
# FIXME: 处理边界情况
    private String resultMessage;

    /**
     * Resizes images in the specified directory with the given width and height.
     * @throws IOException If an I/O error occurs.
     */
    public void resizeImages() throws IOException {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            resultMessage = "The specified directory does not exist.";
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
        if (files == null || files.length == 0) {
            resultMessage = "No JPEG images found in the directory.";
            return;
        }

        for (File file : files) {
# 扩展功能模块
            BufferedImage originalImage = ImageIO.read(file);
            BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH), 0, 0, null);
            ImageIO.write(resizedImage, "jpg", new File(directory, "resized_" + file.getName()));
        }

        resultMessage = "Images resized successfully.";
    }
# 优化算法效率

    // Getters and setters
    public int getWidth() {
        return width;
# 优化算法效率
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
# 优化算法效率
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }
# 添加错误处理

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getResultMessage() {
# NOTE: 重要实现细节
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
# 优化算法效率
