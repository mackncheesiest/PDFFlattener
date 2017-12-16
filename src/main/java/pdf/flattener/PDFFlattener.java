package pdf.flattener;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.IOException;

public class PDFFlattener {

    public static void main(String args[]) {
        if (args.length != 2) {
            printUsage();
            System.exit(1);
        }
        try (PdfReader srcReader = new PdfReader(args[0]);
             PdfWriter dstWriter = new PdfWriter(args[1])) {
            flattenPdf(srcReader, dstWriter);
        } catch(IOException e) {
            System.err.println("Failed to process your PDF\nsrc: " + args[0] + ", dst: " + args[1]);
            e.printStackTrace();
        }
    }

    /**
     * Given a source {@link PdfReader} and destination {@link PdfWriter}, flattens the source PDF and saves it into the destination
     * @param source A source {@link PdfReader}
     * @param dest A destination {@link PdfWriter}
     * @throws IOException
     */
    private static void flattenPdf(PdfReader source, PdfWriter dest) throws IOException {
        //Disable exceptions about petty things like "PdfReader is not opened with owner password"
        source.setUnethicalReading(true);
        PdfDocument pdfDocument = new PdfDocument(source, dest);
        PdfAcroForm.getAcroForm(pdfDocument, true).flattenFields();
        pdfDocument.close();
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar PDFFlattener.jar input_path output_path\n" +
                           "PDFFlattener.jar: the compiled jar file\n" +
                           "input_path: the source to read the input PDF file to be flattened\n" +
                           "output_path: the destination to write the output PDF\n");
    }

}
