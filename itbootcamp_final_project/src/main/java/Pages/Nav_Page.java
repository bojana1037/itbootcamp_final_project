package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nav_Page {

    private WebDriver driver;

    public Nav_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("btnLogin"));
    }

    public WebElement getLanguagesButton() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnglishLanguageButton() {
        return driver.findElement(By.id("list-item-73"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.className("btnLogout"));

    }

    public WebElement getSignUpButton() {
        return driver.findElement(By.xpath("//div[@class = 'v-toolbar__items']/a[4]"));


    }

    public WebElement getAdminButton (){
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton() {
        return this.driver.findElement(By.className("btnAdminCities"));
    }
    public WebElement getSpanishLanguageButton() {
        return driver.findElement(
                By.className("btnES"));

    }
    public WebElement getChineseLanguageButton() {
        return driver.findElement(
                By.className("btnCN"));

    }
    public WebElement getFrenchLanguageButton() {
        return driver.findElement(
                By.className("btnFR"));

    }
    public WebElement getHeader(){
        return driver.findElement(By.tagName("h1"));
    }
}

