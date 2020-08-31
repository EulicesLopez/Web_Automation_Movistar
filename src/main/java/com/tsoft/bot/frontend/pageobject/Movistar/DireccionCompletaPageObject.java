package com.tsoft.bot.frontend.pageobject.Movistar;

import com.tsoft.bot.frontend.baseClass.sikuli.BaseClassSikuli;
import com.tsoft.bot.frontend.baseClass.web.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;

public class DireccionCompletaPageObject extends BaseClass {
    public WebDriver driver;
    static GenerateWord generateWord = new GenerateWord();
    private final String EXCEL_FILE = "excel/DATA_DELIVERY_MOVISTAR.xlsx";
    private final String EXCEL_SHEET = "DireccionCompleta";
    private final String COLUMN_TIPO_VIA = "TipoVia";
    private final String COLUMN_NOMBRE_VIA = "NombreVia";
    private final String COLUMN_NUM_PUERTA = "Npuerta";
    private final String COLUMN_MANZANA = "Manzana";
    private final String COLUMN_LOTE = "Lote";
    private final String COLUMN_PISO = "Piso";
    private final String COLUMN_INTERIOR = "Interior";
    private final String COLUMN_TIPO_VIVIENDA = "TipoVivienda";
    private final String COLUMN_NOMBRE_VIVIENDA = "NombreVivienda";
    private final String COLUMN_TIPO_COJUNTO_HABITACIONAL = "TipoConjuntoHabitacional";
    private final String COLUMN_NOMBRE_COJUNTO_HABITACIONAL = "NombreConjuntoHabitacional";


    //sikuli
    public static final String BASE_PAHT = System.getProperty("user.dir") + "/src/main/resources/images/Movistar/";
    public static final String INPUT_MANZANA = BASE_PAHT + "manzana.PNG";
    public static final String INPUT_LOTE = BASE_PAHT + "lote.PNG";
    public static final String INPUT_PISO = BASE_PAHT + "piso.PNG";
    public static final String INPUT_INTERIOR = BASE_PAHT + "interior.PNG";
    public static final String BARRA_NAVEGACION = BASE_PAHT + "barra.PNG";
    public static final String BTN_CONF_UBICACION = BASE_PAHT + "btn_confirmarUbicacion.PNG";


    public DireccionCompletaPageObject() {
        this.driver = Hook.getDriver();
    }

    private List<HashMap<String, String>> getData1() throws Throwable {
        return ExcelReader.data(EXCEL_FILE, EXCEL_SHEET);
    }

    public void ingresoDatosDireccionCompleta(String casoDePrueba) throws Throwable {
        int valores = Integer.parseInt(casoDePrueba) - 1;
        String tipoViaData = getData1().get(valores).get(COLUMN_TIPO_VIA);
        String nombreViaData = getData1().get(valores).get(COLUMN_NOMBRE_VIA);
        String nPuertaData = getData1().get(valores).get(COLUMN_NUM_PUERTA);
        String manzanaData = getData1().get(valores).get(COLUMN_MANZANA);
        String loteData = getData1().get(valores).get(COLUMN_LOTE);
        String pisoData = getData1().get(valores).get(COLUMN_PISO);
        String interiorData = getData1().get(valores).get(COLUMN_INTERIOR);
        String tipoViviendaData = getData1().get(valores).get(COLUMN_TIPO_VIVIENDA);
        String nombreViviendaData = getData1().get(valores).get(COLUMN_NOMBRE_VIVIENDA);
        String tipoConjuntoHabitacionalData = getData1().get(valores).get(COLUMN_TIPO_COJUNTO_HABITACIONAL);
        String nombreConjuntoHabitacionalData = getData1().get(valores).get(COLUMN_NOMBRE_COJUNTO_HABITACIONAL);

        try {
            BaseClassSikuli.doubleClick(INPUT_MANZANA, 3);
            BaseClassSikuli.type(INPUT_MANZANA, manzanaData);
            BaseClassSikuli.doubleClick(INPUT_LOTE, 3);
            BaseClassSikuli.type(INPUT_LOTE, loteData);
            BaseClassSikuli.doubleClick(INPUT_PISO, 3);
            BaseClassSikuli.type(INPUT_PISO, pisoData);
            BaseClassSikuli.doubleClick(INPUT_INTERIOR, 3);
            BaseClassSikuli.type(INPUT_INTERIOR, interiorData);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se llena los datos de direccion Completa");
            generateWord.sendText("Se llena los datos de direccion Completa");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public void seleccionarBotonConfirmarUbicacion() throws Throwable {
        try {
            BaseClassSikuli.scrollSikuli(BARRA_NAVEGACION, "DOWN", 30);
            BaseClassSikuli.clickSikuli(BTN_CONF_UBICACION, 2);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se dio clic en e boton Confirmar Ubicacion");
            generateWord.sendText("Se dio clic en e boton Confirmar Ubicacion");
            generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }


}
