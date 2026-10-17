package co.com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CertificadoPage {

    public static final Target CAMPO_NOMBRE = Target.the("campo nombre")
            .located(By.id("nombre"));

    public static final Target CAMPO_DOCUMENTO = Target.the("campo documento")
            .located(By.id("documento"));

    public static final Target BOTON_GENERAR = Target.the("boton generar certificado")
            .located(By.id("generar"));

    public static final Target ENLACE_DESCARGAR_PDF = Target.the("enlace para descargar el PDF")
            .located(By.id("descargar"));

    private CertificadoPage() {
    }
}