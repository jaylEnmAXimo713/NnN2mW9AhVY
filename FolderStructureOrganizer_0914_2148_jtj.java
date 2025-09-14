// 代码生成时间: 2025-09-14 21:48:49
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
# 改进用户体验
import java.nio.file.StandardCopyOption;
# 添加错误处理
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
# NOTE: 重要实现细节

/**
 * FolderStructureOrganizer is a class that organizes the files in a given directory,
 * moving them into subdirectories based on their file extension.
 */
public class FolderStructureOrganizer {

    private static final String EXTENSION_DELIMITER = ".";
# 增强安全性

    public static void main(String[] args) {
# 添加错误处理
        // Define the directory path to organize
        String directoryPath = "/path/to/your/directory";

        try {
# TODO: 优化性能
            organizeFiles(directoryPath);
# 改进用户体验
        } catch (IOException e) {
            System.err.println("Failed to organize files: " + e.getMessage());
        }
    }

    /**
# 添加错误处理
     * Organizes the files in the given directory by moving them into subdirectories
     * based on their file extension.
     *
     * @param directoryPath The path to the directory that needs to be organized.
     * @throws IOException If an I/O error occurs.
     */
    public static void organizeFiles(String directoryPath) throws IOException {
        File directory = new File(directoryPath);

        // Check if the directory exists and is indeed a directory
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("The provided path is not a valid directory.");
        }

        // List all files in the directory
        File[] files = directory.listFiles();
        if (files == null) {
            return; // No files to organize
# 添加错误处理
        }

        // Create subdirectories for each file extension
        Arrays.stream(files)
                .filter(File::isFile)
                .forEach(file -> {
                    try {
# NOTE: 重要实现细节
                        String fileName = file.getName();
                        int dotIndex = fileName.lastIndexOf(EXTENSION_DELIMITER);
                        String extension = dotIndex == -1 ? "others" : fileName.substring(dotIndex + 1);
# FIXME: 处理边界情况
                        File targetDirectory = new File(directory, extension);

                        // Create the target directory if it does not exist
                        if (!targetDirectory.exists()) {
# TODO: 优化性能
                            targetDirectory.mkdirs();
                        }

                        // Move the file to the target directory
                        Files.move(
                                file.toPath(),
                                targetDirectory.toPath().resolve(fileName),
# 添加错误处理
                                StandardCopyOption.REPLACE_EXISTING
                        );
                    } catch (IOException e) {
                        System.err.println("Failed to move file: " + file.getName() + ". Error: " + e.getMessage());
                    }
                });
    }
}
