package com.tsoft.bot.frontend.pageobject.Movistar;

import com.tsoft.bot.frontend.baseClass.sikuli.BaseClassSikuli;
import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Screen;

import java.util.HashMap;
import java.util.List;

import static com.tsoft.bot.frontend.baseClass.web.CommonComponents.cargarBrowser;

public class DireccionPageObject extends BaseClass {
    public WebDriver driver;
    Screen screen;
    static GenerateWord generateWord = new GenerateWord();
    private final String EXCEL_FILE = "excel/DATA_DELIVERY_MOVISTAR.xlsx";
    private final String EXCEL_SHEET = "Direccion";
    private final String COLUMN_DEPARTAMENTO = "Departamento";
    private final String COLUMN_PROVINCIA = "Provincia";
    private final String COLUMN_DISTRITO = "Distrito";
    private final String COLUMN_DIRECCION = "Direccion";
    private final String COLUMN_REFERENCIA = "Referencia";

    //Selenium

    public static String SELECT_DEPARTAMENTO = "div.cont-steps > tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(1)";
    public static String SELECT_PROVINCIA = "div.cont-steps > tdp-st-card:nth-child(1) > div > div._body > form > div:nth-child(2)";
    public static String SELECT_DISTRITO = "div._body > form > div:nth-child(3)";
    public static String TXT_DIRECCION = "div._body > form > div:nth-child(4)";
    public static String TXT_REFERENCIA = "//tdp-st-input-text[@class='ng-pristine ng-invalid flex_100 hydrated ng-touched']";
    public static String BTN_CONSULTAR_UBICACION = "//button[@class='button_step']";
    public static String MENSAJE = "//span[contains(text(),'La dirección ingresada NO TIENE COBERTURA delivery')]";


    //sikuli
    public static final String BASE_PAHT = System.getProperty("user.dir") + "/src/main/resources/images/Movistar/";
    public static final String INPUT_DIRECCION = BASE_PAHT + "direccion2.PNG";
    public static final String INPUT_REFERENCIA = BASE_PAHT + "referencia.PNG";
    public static final String BTN_CONST_UBICACION = BASE_PAHT + "btn_consultarUbicacion.PNG";

    public DireccionPageObject() {

        this.driver = Hook.getDriver();
    }

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }

    public void ingresoDatosDireccion(String casoDePrueba) throws Throwable {

        try {
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String departamentoData = getData().get(valores).get(COLUMN_DEPARTAMENTO);
            String provinciaData = getData().get(valores).get(COLUMN_PROVINCIA);
            String distritoData = getData().get(valores).get(COLUMN_DISTRITO);
            String direccionData = getData().get(valores).get(COLUMN_DIRECCION);
            String referenciaData = getData().get(valores).get(COLUMN_REFERENCIA);


            BaseClassSikuli.doubleClick(INPUT_REFERENCIA, 5);
            BaseClassSikuli.type(INPUT_REFERENCIA, referenciaData);
            BaseClassSikuli.doubleClick(BTN_CONST_UBICACION, 3);


            ExtentReportUtil.INSTANCE.stepPass(driver, "Se llena los datos de direccion");
            generateWord.sendText("Se llena los datos de direccion");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }


    public void cargarWeb() throws Throwable {
        try {

            cargarBrowser(driver, "https://aks-berserkers-ingress-cert.eastus2.cloudapp.azure.com/customer/v1/DNI/22174");
            ExtentReportUtil.INSTANCE.stepPass(driver, "se cargo el AKS");
            generateWord.sendText("se cargo el AKS");
            generateWord.addImageToWord(driver);

            sleep(5000);
            cargarBrowser(driver, "http://wa-berserkers-webdelivery-cert.azurewebsites.net/delivery");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó a la pagina web");
            generateWord.sendText("Se ingresó a la pagina web");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


}
