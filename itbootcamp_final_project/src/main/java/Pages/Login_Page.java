package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

    private WebDriver driver;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.xpath("//*[@type = 'submit']"));
}
}
