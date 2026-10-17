package co.com.reto.questions;

import co.com.reto.utils.LectorPdf;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.reto.userinterfaces.CertificadoPage.ENLACE_DESCARGAR_PDF;

public class ContenidoDelPdf implements Question<String> {

    public static ContenidoDelPdf generado() {
        return new ContenidoDelPdf();
    }

    @Override
    public String answeredBy(Actor actor) {
        String enlacePdf = ENLACE_DESCARGAR_PDF.resolveFor(actor).getAttribute("href");
        return LectorPdf.leerTexto(enlacePdf);
    }
}