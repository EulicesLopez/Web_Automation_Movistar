package com.tsoft.bot.frontend.pageobject.Movistar;

import com.tsoft.bot.frontend.baseClass.sikuli.BaseClassSikuli;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class FormaEntregaPageObject {
    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();
    private final String EXCEL_FILE = "excel/DATA_DELIVERY_MOVISTAR.xlsx";
    private final String EXCEL_SHEET = "FormaEntrega";
    private final String COLUMN_TIPO_ENTREGA = "TipoEntrega";
    private final String COLUMN_TITULAR = "Titular";
    private final String COLUMN_INTRUCCIONES = "Intrucciones";
    private final String COLUMN_HORARIO_ENTREGA = "HorarioEntrega";

    //sikuli
    public static final String BASE_PAHT = System.getProperty("user.dir") + "/src/main/resources/images/Movistar/";
    public static final String SELECT_TIPO_ENTREGA = BASE_PAHT + "tipoEntrega.PNG";




    public FormaEntregaPageObject() {
     this.driver = Hook.getDriver();
    }

    private List<HashMap<String, String>> getData2() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }



    public void ingresoDatosFormaEntrega(String casoDePrueba) throws Throwable {
        try {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String TipoEntrega= getData2().get(valores).get(COLUMN_TIPO_ENTREGA);
        String Titular= getData2().get(valores).get(COLUMN_TITULAR);
        String  Intrucciones= getData2().get(valores).get(COLUMN_INTRUCCIONES);
        String  HorarioEntrega= getData2().get(valores).get(COLUMN_HORARIO_ENTREGA);

           // BaseClassSikuli.clickSikuli(SELECT_TIPO_ENTREGA, 2);


        ExtentReportUtil.INSTANCE.stepPass(driver, "Se llena los datos de Forma de Entrega");
        generateWord.sendText("Se llena los datos de Forma de Entrega");
        generateWord.addImageToWord(driver);
    } catch (Exception e) {
        ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
        generateWord.sendText("Tiempo de espera ha excedido");
        generateWord.addImageToWord(driver);
        throw e;
    }

    }

    public void seleccionarBotonConfirmarDelivery() throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en e boton Confirmar Delivery");
            generateWord.sendText("Se dio clic en e boton Confirmar Delivery");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }



    public void validarconfirmacionDelivery() throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en e boton Confirmar Delivery");
            generateWord.sendText("Se dio clic en e boton Confirmar Delivery");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }





}
