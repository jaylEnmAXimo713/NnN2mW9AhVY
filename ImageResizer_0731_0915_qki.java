// 代码生成时间: 2025-07-31 09:15:51
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
# 扩展功能模块
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.util.Iterator;

/**
# 增强安全性
 * 图片尺寸批量调整器
# 优化算法效率
 * 该类用于调整指定文件夹内所有图片的尺寸
 */
public class ImageResizer {

    private static final String SOURCE_FOLDER = "path/to/source/folder"; // 源文件夹路径
    private static final String DESTINATION_FOLDER = "path/to/destination/folder"; // 目标文件夹路径
    private static final int NEW_WIDTH = 800; // 新宽度
    private static final int NEW_HEIGHT = 600; // 新高度

    public static void main(String[] args) {
        File sourceFolder = new File(SOURCE_FOLDER);
        File[] files = sourceFolder.listFiles();
# 改进用户体验

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isImageFile(file)) {
                    try {
                        resizeImage(file, NEW_WIDTH, NEW_HEIGHT);
                    } catch (IOException e) {
# FIXME: 处理边界情况
                        System.err.println("Error resizing image: " + file.getName());
                        e.printStackTrace();
                    }
                }
# 增强安全性
            }
        } else {
            System.err.println("Source folder is empty or not found");
# 添加错误处理
        }
    }

    /**
     * 检查文件是否为图片
     * @param file 要检查的文件
     * @return 如果是图片文件返回true，否则返回false
     */
    private static boolean isImageFile(File file) {
        String fileName = file.getName().toLowerCase();
        return fileName.endsWith(".png") || fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".gif");
    }

    /**
     * 调整图片尺寸
     * @param sourceFile 源图片文件
     * @param newWidth 新宽度
     * @param newHeight 新高度
     * @throws IOException 如果发生I/O错误
     */
    private static void resizeImage(File sourceFile, int newWidth, int newHeight) throws IOException {
        BufferedImage originalImage = ImageIO.read(sourceFile);
# TODO: 优化性能
        if (originalImage == null) {
            System.err.println("Unsupported image format: " + sourceFile.getName());
            return;
        }

        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        resizedImage.getGraphics().drawImage(originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
# NOTE: 重要实现细节

        String fileName = sourceFile.getName();
        int dotIndex = fileName.lastIndexOf(".");
        String newFileName = fileName.substring(0, dotIndex) + "_resized" + fileName.substring(dotIndex);

        File destinationFile = new File(DESTINATION_FOLDER, newFileName);
        ImageIO.write(resizedImage, getExtension(fileName), destinationFile);
    }

    /**
     * 获取图片文件的扩展名
     * @param fileName 图片文件名
     * @return 图片文件的扩展名
     */
    private static String getExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        int i = fileName.lastIndexOf(".");
        if (i > 0 && i < fileName.length() - 1) {
            return fileName.substring(i + 1).toLowerCase();
        }
        return "";
    }
# 优化算法效率
}
