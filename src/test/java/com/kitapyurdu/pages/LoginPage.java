package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;


public class LoginPage {

    Methods methods;

    By btnMenuTopLogin = By.cssSelector(".menu-top-button.login>a");
    By inputEmail = By.id("login-email");
    By inputPassword = By.id("login-password");
    By btnRegisterLogin = By.cssSelector(".ky-login-btn");
    By userMenuTopLogin = By.cssSelector(".menu.top.login");


    public LoginPage(){
        methods= new Methods();
    }

    public void login(){

        methods.click(btnMenuTopLogin);
        methods.sendKey(inputEmail,"test011910@hotmail.com");
        methods.sendKey(inputPassword,"+ke4KrDya,Sse8");
        methods.click(btnRegisterLogin);
        // Login olduktan sonra Merhaba kullanici adi yazmalıdır eger Merhaba yazisi iceriyorsa herhangi bir kullanici
        // ile basarili giris yapilmistir
        Assert.assertTrue("Login islemi basarisiz",methods.getText(userMenuTopLogin).contains("Merhaba"));

    }

}
