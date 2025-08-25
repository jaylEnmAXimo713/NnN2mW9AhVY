// 代码生成时间: 2025-08-25 09:08:59
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
# 改进用户体验
 * BatchFileRenamer is a tool that allows users to batch rename files in a directory.
 * It uses the Java File API and JSF for user interaction.
 */
# 优化算法效率
public class BatchFileRenamer {
# NOTE: 重要实现细节

    /**
     * The main method where the program execution begins.
     * @param args Command line arguments.
     */
# 优化算法效率
    public static void main(String[] args) {
# 优化算法效率
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        try {
            // Prompt user for directory path
            System.out.println("Enter the directory path: ");
            String directoryPath = scanner.nextLine();

            // Check if directory exists
# 优化算法效率
            File directory = new File(directoryPath);
# FIXME: 处理边界情况
            if (!directory.exists() || !directory.isDirectory()) {
# NOTE: 重要实现细节
                throw new IllegalArgumentException("The specified path is not a valid directory.");
            }

            // Prompt user for new file name pattern
            System.out.println("Enter the new file name pattern (e.g., newname-%d.txt): ");
            String pattern = scanner.nextLine();

            // Rename files in the directory
            renameFiles(directory, pattern);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Renames files in the specified directory using the given pattern.
     * @param directory The directory containing files to rename.
     * @param pattern The pattern for new file names.
     */
    private static void renameFiles(File directory, String pattern) throws IOException {
        // Get a list of files in the directory
# 扩展功能模块
        File[] files = directory.listFiles();
        if (files == null) {
            throw new IOException("Failed to list files in the directory.");
# NOTE: 重要实现细节
        }

        // Loop through files and rename them
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                // Construct new file name
                String newName = String.format(pattern, i);
                Path oldPath = Paths.get(files[i].getAbsolutePath());
                Path newPath = Paths.get(directory.getAbsolutePath(), newName);

                // Rename file
                Files.move(oldPath, newPath);
                System.out.println("Renamed: " + oldPath + " to " + newPath);
            }
        }
    }
}
