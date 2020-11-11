package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.pageobject.Movistar.BandejaPageObject;
import com.tsoft.bot.frontend.pageobject.Movistar.DireccionCompletaPageObject;
import com.tsoft.bot.frontend.pageobject.Movistar.DireccionPageObject;
import com.tsoft.bot.frontend.pageobject.Movistar.FormaEntregaPageObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeliverySteps extends BaseClass {

    DireccionPageObject direccionPageObject = new DireccionPageObject();
    DireccionCompletaPageObject direccionCompletaPageObject = new DireccionCompletaPageObject();
    FormaEntregaPageObject formaEntregaPageObject = new FormaEntregaPageObject();
    BandejaPageObject bandejaPageObject = new BandejaPageObject();

    @Given("^Usuario se encuentra en el aplicativo Web Delivery$")
    public void usuarioSeEncuentraEnElAplicativoWebDelivery() throws Throwable {
        direccionPageObject.cargarWeb();
    }


    @When("^Completa datos de la direccion y da clic en el boton Consultar ubicacion \"([^\"]*)\"$")
    public void completaDatosDeLaDireccionYDaClicEnElBotonConsultarUbicacion(String casoPrueba) throws Throwable {
        //bandejaPageObject.clickBotonBandeja();
      direccionPageObject.ingresoDatosDireccion(casoPrueba);


    }

    @And("^Completa datos de la direccion completa y da clic en el boton Confirmar ubicacion \"([^\"]*)\"$")
    public void completaDatosDeLaDireccionCompletaYDaClicEnElBotonConfirmarUbicacion(String casoPrueba) throws Throwable {
        direccionCompletaPageObject.ingresoDatosDireccionCompleta(casoPrueba);
        direccionCompletaPageObject.seleccionarBotonConfirmarUbicacion();
    }

    @And("^Completa datos de entrega \"([^\"]*)\"$")
    public void completaDatosDeEntrega(String casoPrueba) throws Throwable {
        formaEntregaPageObject.ingresoDatosFormaEntrega(casoPrueba);
    }

    @Then("^Usuario da clic en boton Confirmar delivery$")
    public void usuarioDaClicEnBotonConfirmarDelivery() throws Throwable {

    }

    @And("^Verifica el Servicio Delivery$")
    public void verificaElServicioDelivery() {
    }

    /*---------------------CAQRGA DE AUDIO ---------------------*/

    @Given("^Usuario se encuentra en el aplicativo Bandeja Audio$")
    public void usuarioSeEncuentraEnElAplicativoBandejaAudio() throws Throwable {

        direccionPageObject.cargarWeb();
    }

    @When("^Click en Bandeja de Back Office$")
    public void clickEnBandejaDeBackOffice() throws Throwable {
        bandejaPageObject.clickBotonBandeja();
    }

    @And("^Ver detalle de la orden$")
    public void verDetalleDeLaOrden() throws Throwable {
        bandejaPageObject.clickBotonVerDetalleOrden();
    }

    @Then("^Realizar carga de audio$")
    public void realizarCargaDeAudio() throws Throwable {
        bandejaPageObject.clickBotonCargarAudio();
    }

    @And("^Verificar registro de carga de audio$")
    public void verificarRegistroDeCargaDeAudio() throws Throwable {
        bandejaPageObject.clickBotonAprobar();
    }

}
