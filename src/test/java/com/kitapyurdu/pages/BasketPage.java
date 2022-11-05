package com.kitapyurdu.pages;

import com.github.javafaker.Faker;
import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BasketPage {

    Methods methods;

    Faker faker;
    public BasketPage(){
        methods = new Methods();
        faker = new Faker();
    }


    By btnBuy = By.cssSelector(".button.red");
    By boxProduct = By.cssSelector(".cart-select");

    By inputName = By.id("address-firstname-companyname");
    By inputLastname = By.id("address-lastname-title");
    By slctCity = By.id("address-zone-id");
    By btnCity = By.xpath("//option[@value='3315']");
    By slctCounty = By.id("address-county-id");
    By btnCounty = By.xpath("//select[@id='address-county-id']/option[@value='1']");
    By slctDistrict = By.xpath("//input[@id='district']");
    By textAdres = By.id("address-address-text");
    By inptPhoneNumber = By.id("address-mobile-telephone");
    By btnDevam = By.cssSelector("#button-checkout-continue>i");
    By btnNewAdres = By.xpath("//a[@href='#tab-shipping-new-adress']");
    By slctCountry = By.id("address-country-id");
    By btnCountry = By.xpath("//option[@value='215']");

    By inputCreditCardOwner = By.id("credit-card-owner");
    By inputCreditCardNumber1 = By.id("credit_card_number_1");
    By inputCreditCardNumber2 = By.id("credit_card_number_2");
    By inputCreditCardNumber3 = By.id("credit_card_number_3");
    By inputCreditCardNumber4 = By.id("credit_card_number_4");
    By slctCreditCardMounth = By.id("credit-card-expire-date-month");
    By btnCreditCArdMounth = By.xpath("//option[@value='01']");
    By slctCreditCardYear = By.id("credit-card-expire-date-year");
    By btnCreditCArdYear = By.xpath("//option[@value='2023']");
    By secrytCode = By.id("credit-card-security-code");
    By errorMessage = By.xpath("//span[@class='error']");

    public void productPcsAdd(){
        methods.click(boxProduct);
    }

    public void productBuy(){
        methods.click(btnBuy);
        methods.click(btnNewAdres);
        methods.click(inputName);
        methods.sendKey(inputName,faker.name().firstName());
        methods.sendKey(inputLastname,faker.name().lastName());
        methods.click(slctCountry);
        methods.click(btnCountry);
        methods.click(slctCity);
        methods.click(btnCity);
        methods.click(slctCounty);
        methods.click(btnCounty);
        methods.click(slctDistrict);
        methods.sendKey(slctDistrict,"AKPINAR MAH");
        methods.click(textAdres);
        methods.sendKey(textAdres,faker.address().fullAddress());
        methods.click(inptPhoneNumber);
        methods.sendKey(inptPhoneNumber, "5111111111");
        methods.click(btnDevam);

    }
    public void payment(){
        methods.waitBySecond(3);
        methods.click(btnDevam);
        methods.sendKey(inputCreditCardOwner,"Yahya");
        methods.sendKey(inputCreditCardNumber1,"1111");
        methods.sendKey(inputCreditCardNumber2,"1111");
        methods.sendKey(inputCreditCardNumber3,"1111");
        methods.sendKey(inputCreditCardNumber4,"1111");
        methods.click(slctCreditCardMounth);
        methods.click(btnCreditCArdMounth);
        methods.click(slctCreditCardYear);
        methods.click(btnCreditCArdYear);
        methods.click(secrytCode);
        methods.sendKey(secrytCode,"111");
        methods.click(btnDevam);
        Assert.assertEquals("Kart numarası geçersiz. Kontrol ediniz!",methods.getText(errorMessage));
    }
}
