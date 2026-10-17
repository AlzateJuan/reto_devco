package co.com.reto.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.nio.file.Paths;

public class AbrirLaAplicacion implements Task {

    private static final String URL_APLICACION = Paths
            .get("src/test/resources/app/certificado.html")
            .toAbsolutePath()
            .toUri()
            .toString();

    public static AbrirLaAplicacion deCertificados() {
        return Tasks.instrumented(AbrirLaAplicacion.class);
    }

    @Override
    @Step("{0} abre la aplicacion de certificados")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(URL_APLICACION)
        );
    }
}