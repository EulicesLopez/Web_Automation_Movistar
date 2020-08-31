package com.tsoft.bot.frontend.test;

import com.tsoft.bot.frontend.baseClass.sikuli.BaseClassSikuli;
import org.testng.annotations.Test;

import static com.tsoft.bot.frontend.pageobject.Movistar.DireccionPageObject.*;

public class DeliveryMovistarTest  extends BaseClassSikuli {


    @Test
    public void deviveryTest() throws Throwable {
        doubleClick(INPUT_REFERENCIA, 5);
        type(INPUT_REFERENCIA, "dddddd");
        clickSikuli(BTN_CONST_UBICACION, 2);
    }




}
