package com.tsoft.bot.frontend.pageobject.Movistar;

import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class BandejaPageObject extends BaseClass {
    public WebDriver driver;

    static GenerateWord generateWord = new GenerateWord();
    private final String EXCEL_FILE = "excel/DATA_DELIVERY_MOVISTAR.xlsx";
    private final String EXCEL_SHEET = "Direccion";


    //Selenium
    public static String BTN_BANDEJA = "//body/app-root[1]/app-inicio[1]/div[1]/div[3]/div[1]/div[1]/div[1]/img[1]";
    public static String BTN_VER_DETALLE ="//body/div[1]/div[3]/div[2]/button[1]";
    //public static String BTN_CARGAR_AUDIO ="//body/div[1]/div[4]/div[1]/div[2]/div[1]/tdp-st-button[1]";
    public static String BTN_CARGAR_AUDIO ="/html/body/app-root/app-offer-detail/body/div/div[3]/div[1]/div[2]/div/tdp-st-button";
    public static String BTN_SUBIR_AUDIO ="//*[@id='fileDropRef']";
    public static String BTN_APROBAR ="//button[contains(text(),'Aprobar')]";


    //archivo
    private final String BASE_PAHT = System.getProperty("user.dir") + "/src/main/resources/audio/";
    private final String ARCHIVO_AUDIO = BASE_PAHT + "FE-0000005764.mp3";


    public BandejaPageObject() {
        this.driver = Hook.getDriver();
    }

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }

    public void clickBotonBandeja() throws Throwable {
        try {
            click(driver, "xpath", BTN_BANDEJA);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en e boton Bandeja de audio");
            generateWord.sendText("Se dio clic en e boton Bandeja de audio");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void clickBotonVerDetalleOrden() throws Throwable {
        try {
            sleep2(5);
            click(driver, "xpath", BTN_VER_DETALLE);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en e boton Ver detalle");
            generateWord.sendText("Se dio clic en e boton Ver detalle");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public void clickBotonCargarAudio() throws Throwable {
        try {
            sleep2(5);
            click(driver, "xpath", BTN_CARGAR_AUDIO);

            sendKeyValue(driver, "xpath", BTN_SUBIR_AUDIO, ARCHIVO_AUDIO);
            sleep2(10);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se Subio el arcchivo correctamente");
            generateWord.sendText("Se Subio el arcchivo correctamente");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


    public void clickBotonAprobar() throws Throwable {
        try {
            click(driver, "xpath", BTN_APROBAR);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en e boton Aprobar");
            generateWord.sendText("Se dio clic en e boton Aprobar");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }



}
