package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cities_Page {
    private WebDriver driver;

    public Cities_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver.findElement(By.className("btnNewItem"));
    }

    public WebElement getNewItemName() {
        return driver.findElement(By.id("name"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.id("search"));
    }

    public void waitForCreateOrEditDialogueToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("dlgNewEditItem")));
    }

    public void waitForDeletePopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                        By.className("body-1")));
    }

    public WebElement getSaveCityButton() {
        return driver.findElement(By.className("btnSave"));
    }


    public void waitForNumberOfRows(int rowNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfElementsToBe(
                       By.xpath("//tbody/tr"), rowNumber));
    }

    public WebElement getEditButton(int rowNumber) {
        return driver.findElement(
                By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='edit']"));
    }

    public WebElement getCellFromTheTable(int rowNumber, int columnNumber) {
        return driver
                .findElement(By.xpath(
                        "//tbody/tr[" + rowNumber + "]/td[" + columnNumber + "]"));
    }

    public WebElement getDeleteButtonFromRow(int rowNumber) {
        return this.driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//div/button[2]"));
    }

    public WebElement getDeleteButtonFromDialogue() {
        return this.driver.findElement(By.xpath("//div[contains(@class,'v-card__actions')]/button[2]"));
    }

}
