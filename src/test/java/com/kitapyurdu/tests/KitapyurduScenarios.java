package com.kitapyurdu.tests;

import com.kitapyurdu.driver.BaseTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KitapyurduScenarios extends BaseTest {

    @Test
    public void step01LoginTest(){
       loginPage.login();
    }

    @Test
    public void step02ProductSearchAndAddFavoritTest(){
        productPage.productSearch("Oyuncak");
        productPage.scrollAndAddFav();
    }
    @Test
    public void step03MainPage(){
        productPage.goToMainPage();
        productPage.goToPuankatalogu();

    }

    @Test
    public void step04Tumkitaplar(){
        productPage.goToTumkitaplar();
    }
    @Test
    public void step05RemoveFav(){
        productPage.goToFav();
    }
    @Test
    public void step06GotoCart(){
        productPage.goToCard();
    }
    @Test
    public void step07ProductBuy(){
        basketPage.productPcsAdd();
        basketPage.productBuy();
    }
    @Test
    public void step08Pay(){
        basketPage.payment();
    }


}
