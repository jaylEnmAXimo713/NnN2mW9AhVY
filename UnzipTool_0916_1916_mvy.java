// 代码生成时间: 2025-09-16 19:16:34
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * A utility class for unzipping files.
 */
public class UnzipTool {

    /**
     * Unzips a file from a ZIP archive to a specified directory.
     *
     * @param zipFilePath The path to the ZIP file.
     * @param destDirectory The destination directory to extract the files to.
     * @throws IOException If an I/O error occurs.
     */
    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }

        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();

        // Process each entry
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // If the entry is a file, extract it
                extractFile(zipIn, filePath);
            } else {
                // If the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

    /**
     * Extracts a file from the ZIP input stream to the specified path.
     *
     * @param zipIn The ZIP input stream to read from.
     * @param filePath The path to extract the file to.
     * @throws IOException If an I/O error occurs.
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read = 0;

        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    /**
     * Main method to test the unzip functionality.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try {
            UnzipTool unzipper = new UnzipTool();
            String zipFilePath = "path/to/your/file.zip";
            String destDirectory = "path/to/destination/directory";
            unzipper.unzip(zipFilePath, destDirectory);
            System.out.println("Unzipping completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while unzipping.");
        }
    }
}
