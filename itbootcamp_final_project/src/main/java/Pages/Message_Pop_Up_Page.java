package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Message_Pop_Up_Page {
    private WebDriver driver;

    public Message_Pop_Up_Page(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForPopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("v-snack__content")));
    }
    public WebElement getMessageTextFromPopUp(){
        return driver.findElement(By.xpath("//*[@class = 'v-snack__content']/ul/li"));
    }
}
