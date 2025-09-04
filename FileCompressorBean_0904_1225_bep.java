// 代码生成时间: 2025-09-04 12:25:20
package com.example.filecompressor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@ManagedBean
@ViewScoped
public class FileCompressorBean {

    private File compressedFile;
    private File outputDirectory;

    // Getter and Setter for compressedFile
    public File getCompressedFile() {
        return compressedFile;
    }

    public void setCompressedFile(File compressedFile) {
        this.compressedFile = compressedFile;
    }

    // Getter and Setter for outputDirectory
    public File getOutputDirectory() {
        return outputDirectory;
    }

    public void setOutputDirectory(File outputDirectory) {
        this.outputDirectory = outputDirectory;
    }

    /**
     * 解压文件到指定目录
     *
     * @param zipFilePath 压缩文件路径
     * @param destDirectory 目标目录
     * @throws IOException 如果解压过程中发生IO异常
     */
    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        FileInputStream fis = null;
        ZipInputStream zis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(zipFilePath);
            zis = new ZipInputStream(fis);
            ZipEntry zipEntry = zis.getNextEntry();
            int count;
            byte data[] = new byte[1024];

            // 遍历压缩文件条目
            while (zipEntry != null) {

                // 为每个条目创建目标文件
                File destFile = new File(destDirectory + File.separator + zipEntry.getName());

                // 判断是否为目录
                if (zipEntry.isDirectory()) {
                    destFile.mkdirs();
                    zipEntry = zis.getNextEntry();
                    continue;
                } else if (!destFile.getCanonicalPath().startsWith(destDirectory + File.separator)) {
                    throw new IOException("Cannot extract file outside of the target directory.");
                }

                // 如果是文件，则创建文件
                FileOutputStream fos = new FileOutputStream(destFile);

                while ((count = zis.read(data)) != -1) {
                    fos.write(data, 0, count);
                }
                fos.close();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
        } finally {
            if (fos != null) {
                fos.close();
            }
            if (zis != null) {
                zis.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }

    // JSF Action Method to handle file upload and unzip
    public String handleFileUpload() {
        try {
            // Check for null files and directories
            if (compressedFile == null || outputDirectory == null) {
                throw new IllegalArgumentException("Both compressed file and output directory must be provided.");
            }

            // Unzip the file
            unzip(compressedFile.getAbsolutePath(), outputDirectory.getAbsolutePath());

            // Return to the same view
            return "success";
        } catch (IOException e) {
            // Log and handle the exception
            e.printStackTrace();
            return "error";
        }
    }
}
