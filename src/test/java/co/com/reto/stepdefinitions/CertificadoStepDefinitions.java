package co.com.reto.stepdefinitions;

import co.com.reto.questions.ContenidoDelPdf;
import co.com.reto.tasks.AbrirLaAplicacion;
import co.com.reto.tasks.GenerarCertificado;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;

public class CertificadoStepDefinitions {

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("que {word} abre la aplicación de certificados")
    public void abreLaAplicacion(String actor) {
        theActorCalled(actor).attemptsTo(
                AbrirLaAplicacion.deCertificados()
        );
    }

    @Cuando("genera el certificado con nombre {string} y documento {string}")
    public void generaElCertificado(String nombre, String documento) {
        theActorInTheSpotlight().attemptsTo(
                GenerarCertificado.con(nombre, documento)
        );
    }

    @Entonces("el PDF generado debe contener el nombre {string} y el documento {string}")
    public void validaElPdf(String nombre, String documento) {
        theActorInTheSpotlight().should(
                seeThat("El contenido del PDF", ContenidoDelPdf.generado(),
                        allOf(
                                containsString("CERTIFICADO BANCARIO"),
                                containsString("Nombre: " + nombre),
                                containsString("Documento: " + documento)
                        ))
        );
    }
}