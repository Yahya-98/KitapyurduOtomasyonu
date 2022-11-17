package com.kitapyurdu.tests;

import com.kitapyurdu.driver.DriverSetup;
import com.kitapyurdu.pages.BasketPage;
import com.kitapyurdu.pages.LoginPage;
import com.kitapyurdu.pages.ProductPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KitapyurduScenarios  {
    static BasketPage basketPage;
    static LoginPage loginPage;
    static ProductPage productPage;
    static DriverSetup driverSetup;

    public  KitapyurduScenarios(){

    }
    @BeforeClass
    public static void pages(){
        driverSetup = new DriverSetup();
        productPage = new ProductPage();
        loginPage = new LoginPage();
        basketPage = new BasketPage();

    }
    @AfterClass
    public static void close(){
        driverSetup.teardown();
    }

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
