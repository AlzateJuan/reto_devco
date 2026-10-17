package co.com.reto.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.reto.userinterfaces.CertificadoPage.BOTON_GENERAR;
import static co.com.reto.userinterfaces.CertificadoPage.CAMPO_DOCUMENTO;
import static co.com.reto.userinterfaces.CertificadoPage.CAMPO_NOMBRE;
import static co.com.reto.userinterfaces.CertificadoPage.ENLACE_DESCARGAR_PDF;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GenerarCertificado implements Task {

    private final String nombre;
    private final String documento;

    public GenerarCertificado(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public static GenerarCertificado con(String nombre, String documento) {
        return Tasks.instrumented(GenerarCertificado.class, nombre, documento);
    }

    @Override
    @Step("{0} genera el certificado de #nombre")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CAMPO_NOMBRE),
                Enter.theValue(documento).into(CAMPO_DOCUMENTO),
                Click.on(BOTON_GENERAR),
                WaitUntil.the(ENLACE_DESCARGAR_PDF, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}