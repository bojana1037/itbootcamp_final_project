package Tests;

import Pages.Nav_Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Test extends Basic_Test {

    @Test(priority = 10)
    public void visitsTheLoginPage() {
        nav_page.getLanguagesButton().click();
        nav_page.getEnglishLanguageButton().click();
        nav_page.getLoginButton().click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] URL does not contains '/login' route");

    }

    @Test(priority = 20)
    public void checksInputTypes() {
        nav_page.getLoginButton().click();

        Assert.assertEquals(login_page.getEmailInput()
                        .getAttribute("type"),
                "email",
                "Email attribute is not 'email'");

        Assert.assertEquals(login_page.getPasswordInput()
                        .getAttribute("type"),
                "password",
                "Password attribute is not 'password'");
    }

    @Test(priority = 30)
    public void displayErrorsWhenUserDoesNotExist() {
        nav_page.getLoginButton().click();
        login_page.getEmailInput().sendKeys("non-existing-user@gmal.com");
        login_page.getPasswordInput().sendKeys("password123");
        login_page.getLoginButton().click();

        message_pop_up_page.waitForPopUpToBeVisible();

        Assert.assertEquals(message_pop_up_page
                        .getTextMessageFromPopUp().getText(),
                "User does not exists",
                "[ERROR] Pop up message does not contain 'User does not exists' text");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "[ERROR] Page URL does not contain '/login' route");
    }

    @Test(priority = 40)

    public void displaysErrorsWhenPasswordIsWrong() {

        nav_page.getLoginButton().click();

        login_page.getEmailInput().sendKeys("admin@admin.com");

        login_page.getPasswordInput().sendKeys("password123");

        login_page.getLoginButton().click();

        message_pop_up_page.waitForPopUpToBeVisible();

        Assert.assertEquals(
                message_pop_up_page.getTextMessageFromPopUp().getText(),
                "Wrong password",
                "[ERROR] Message does not contains text-Wrong password");

        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page URL does not contains /login route");


    }

    @Test(priority = 50)

    public void login() throws InterruptedException {

        nav_page.getLoginButton().click();

        login_page.getEmailInput().sendKeys("admin@admin.com");

        login_page.getPasswordInput().sendKeys("12345");

        login_page.getLoginButton().click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        Assert.assertTrue(
                wait.until(ExpectedConditions.urlContains("/home")),
                "[ERROR] Page URL does not contains /home");

    }

    @Test(priority = 60)
    public void logout() {

        Assert.assertTrue(nav_page.
                        getLogoutButton().isDisplayed(),
                "[ERROR] Logout button in not visible on menu");

        nav_page.getLogoutButton().click();
    }

}

