// 代码生成时间: 2025-09-15 03:04:16
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * ManagedBean class for document conversion functionality.
 */
@ManagedBean
@ViewScoped
public class DocumentConverter {

    private File inputFile;
    private File outputFile;
    private String conversionType;

    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    public String getConversionType() {
        return conversionType;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    /**
     * Converts the input document to the specified format.
     *
     * @return String indicating the conversion status.
     */
    public String convertDocument() {
        if (inputFile == null || outputFile == null || conversionType == null) {
            return "Error: Input file, output file, and conversion type must be specified.";
        }

        try {
            // Convert Word to PDF
            if ("wordToPdf".equalsIgnoreCase(conversionType)) {
                Files.copy(Paths.get(inputFile.getAbsolutePath()),
                        Paths.get(outputFile.getAbsolutePath()),
                        StandardCopyOption.REPLACE_EXISTING);
                XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(inputFile.getAbsolutePath())));
                Document pdfDoc = new Document();
                PdfWriter.getInstance(pdfDoc, Files.newOutputStream(Paths.get(outputFile.getAbsolutePath())));
                pdfDoc.open();
                for (XWPFParagraph para : doc.getParagraphs()) {
                    pdfDoc.add(new Paragraph(para.getText()));
                }
                pdfDoc.close();
                return "Conversion successful: Document converted to PDF.";
            }
            // Add more conversion types as needed

        } catch (IOException | DocumentException e) {
            return "Error during conversion: " + e.getMessage();
        }

        return "Error: Unsupported conversion type.";
    }
}
