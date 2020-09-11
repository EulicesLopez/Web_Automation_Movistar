package com.tsoft.bot.frontend.pageobject.Movistar;

import com.tsoft.bot.frontend.baseClass.sikuli.BaseClassSikuli;
import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    //public static String TXT_REFERENCIA =  ".tdp-row:nth-child(5)";
    //public static String TXT_REFERENCIA = "div._body > form > div:nth-child(5)";

    public static String TXT_REFERENCIA = "//tdp-st-input-text[@formcontrolname='reference']";
    public static String BTN_CONSULTAR_UBICACION = "//button[@class='button_step']";
    public static String MENSAJE = "//span[contains(text(),'La dirección ingresada NO TIENE COBERTURA delivery')]";


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


            click(driver, "xpath", TXT_REFERENCIA);
            sendKeyValue(driver, "xpath", TXT_REFERENCIA, referenciaData);
            click(driver, "xpath", BTN_CONSULTAR_UBICACION);

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

            sleep(3000);
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
