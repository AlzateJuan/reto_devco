package co.com.reto.utils;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

public class LectorPdf {

    private static final String MARCA_BASE64 = "base64,";
    private static final Path CARPETA_EVIDENCIAS = Paths.get("build", "evidencias");

    private LectorPdf() {
    }

    public static String leerTexto(String enlacePdf) {
        String contenidoBase64 = enlacePdf.substring(enlacePdf.indexOf(MARCA_BASE64) + MARCA_BASE64.length());
        byte[] bytesPdf = Base64.getDecoder().decode(contenidoBase64);
        try {
            guardarEvidencia(bytesPdf);
            try (PDDocument pdf = Loader.loadPDF(bytesPdf)) {
                return new PDFTextStripper().getText(pdf);
            }
        } catch (IOException error) {
            throw new IllegalStateException("No se pudo leer el PDF generado", error);
        }
    }

    private static void guardarEvidencia(byte[] bytesPdf) throws IOException {
        Files.createDirectories(CARPETA_EVIDENCIAS);
        Files.write(CARPETA_EVIDENCIAS.resolve("certificado_" + System.currentTimeMillis() + ".pdf"), bytesPdf);
    }
}