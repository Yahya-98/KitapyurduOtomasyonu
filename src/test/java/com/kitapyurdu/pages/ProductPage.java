package com.kitapyurdu.pages;

import com.kitapyurdu.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;


public class ProductPage {

    Methods methods;
    String productId;
    String product3Id;
    String removeProduct;
    By inputSearch = By.id("search-input");
    By btnSearch = By.cssSelector(".common-sprite.button-search");

    By titleSearchResult = By.cssSelector(".search-heading-title");

    By product7 = By.xpath("(//div[@class='name']/a)[7]");

    By productList = By.xpath("//a[@class='add-to-favorites']");
    By btnMenuTopListelerim = By.xpath("//a[text()='Listelerim']");
    By btnMenuTopFavorilerim = By.xpath("//a[text()='Favorilerim']");
    By textFavListSize = By.cssSelector(".results");
    By btnLogoicon = By.cssSelector(".logo-icon");
    By btnPuankatalogu = By.cssSelector(".lvl1catalog>a");
    By btnPuankatalogundakiTurkKlasikleri = By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']");
    By btnvaluesort =By.cssSelector(".sort");
    By btnvalueYuksekoylama = By.xpath("//option[@value='https://www.kitapyurdu.com/index.php?route=product/best_sellers&sort=rating&order=DESC&list_id=730&filter_points_catalog=true&filter_points_catalog=true']");
    By btnTumKitaplar = By.xpath("//span[text()='Tüm Kitaplar']");
    By btnTumkitaplarHobi = By.xpath("//a[text()='Hobi']");
    By listAllProduct = By.cssSelector(".product-cr");
    By btnAddtoBasket = By.cssSelector("#button-cart");
    By iconCart = By.id("sprite-cart-icon");
    By btnGotoCart = By.id("js-cart");

    public ProductPage() {
        methods = new Methods();
    }

    public void productSearch(String product) {
        methods.sendKey(inputSearch, product);
        methods.click(btnSearch);
        Assert.assertEquals("Arama islemi basarisiz", product + " için arama sonuçları", methods.getText(titleSearchResult));
    }

    public void scrollAndAddFav() {
        methods.scrollScreen(product7);
        int i = 0;
        do {
            methods.waitBySecond(1);
            // eger ürün zaten favorilere eklenmisse yeni ürün secmesi icin döngü adimi tekrarlanir
            if (methods.randomElement(productList).getAttribute("style").equals("display: none;")) {
                continue;
            } else if (i == 3) {
                //3 ürünün id si icin onclick attribute value si saklanir
                product3Id = methods.randomElement(productList).getAttribute("onclick");
                productId = product3Id;
                By btnFavorite = By.xpath("(//a[@onclick='" + productId + "']/i)[2]");
                methods.scrollScreen(btnFavorite);
                methods.click(btnFavorite);
                i++;
                continue;
            } else {

                // rastegele favorilere eklenmemis ürün favorilere eklenir
                productId = methods.randomElement(productList).getAttribute("onclick");
                By btnFavorite = By.xpath("(//a[@onclick='" + productId + "']/i)[2]");
                methods.scrollScreen(btnFavorite);
                methods.click(btnFavorite);
                i++;
            }
        } while (i < 4);

        methods.hoverCursor(btnMenuTopListelerim);
        methods.click(btnMenuTopFavorilerim);
        Assert.assertEquals("Favorilere eklenen veri 4 e esit degil","Gösterilen: 1 ile 4 arası, toplam: 4 (1 Sayfa)",methods.findElement(textFavListSize).getText());

    }

    public void goToMainPage(){

        methods.click(btnLogoicon);

    }

    public void goToPuankatalogu(){
        methods.click(btnPuankatalogu);
        methods.click(btnPuankatalogundakiTurkKlasikleri);
        methods.click(btnvaluesort);
        methods.click(btnvalueYuksekoylama);
    }

    public void goToTumkitaplar(){
        methods.click(btnTumKitaplar);
        methods.click(btnTumkitaplarHobi);
        methods.randomElement(listAllProduct).click();
        methods.click(btnAddtoBasket);
    }

    public void goToFav(){

        methods.hoverCursor(btnMenuTopListelerim);
        methods.click(btnMenuTopFavorilerim);
        removeProduct = methods.removeProductxpath(product3Id);
        By btnRemoveFav = By.xpath("//div[@class='hover-menu']/a[@onclick='" + removeProduct + "']");
        methods.click(btnRemoveFav);

    }

    public void goToCard(){
        methods.waitBySecond(1);
        methods.click(iconCart);
        methods.waitBySecond(5);
        methods.click(btnGotoCart);
    }

}
