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

    public void waitForPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'v-snack__content')]")));

    }


    public void waitForMessageSuccessfullySaveCity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getTextMessageFromPopUp() {
        return driver.findElement(By.xpath("//*[@class = 'v-snack__content')]/ul/li"));
    }

    public WebElement getMessageTextSuccessfullySaveCity() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return driver.findElement(By.className("success"));
    }


    public void waitForVerifyAccountPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("dlgVerifyAccount")));
    }

    public WebElement getTextMessageFromVerifyPopUp() {
        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]"));
    }


    public WebElement getCloseButtonFromVerifyAccountPopUp() {

        return driver.findElement(By.className("btnClose"));
    }
}

