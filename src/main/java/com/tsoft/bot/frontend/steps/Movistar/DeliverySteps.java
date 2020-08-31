package com.tsoft.bot.frontend.steps.Movistar;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.pageobject.Movistar.DireccionCompletaPageObject;
import com.tsoft.bot.frontend.pageobject.Movistar.DireccionPageObject;
import com.tsoft.bot.frontend.pageobject.Movistar.FormaEntregaPageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeliverySteps extends BaseClass {

    DireccionPageObject direccionPageObject = new DireccionPageObject();
    DireccionCompletaPageObject direccionCompletaPageObject = new DireccionCompletaPageObject();
    FormaEntregaPageObject formaEntregaPageObject = new FormaEntregaPageObject();


    @Given("^Usuario se encuentra en el aplicativo Web Delivery$")
    public void usuarioSeEncuentraEnElAplicativoWebDelivery() throws Throwable {
        direccionPageObject.cargarWeb();
    }


    @When("^Completa datos de la direccion y da clic en el boton Consultar ubicacion \"([^\"]*)\"$")
    public void completaDatosDeLaDireccionYDaClicEnElBotonConsultarUbicacion(String casoPrueba) throws Throwable {
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
    public void usuarioDaClicEnBotonConfirmarDelivery() {
    }

    @And("^Verifica el Servicio Delivery$")
    public void verificaElServicioDelivery() {
    }
}
