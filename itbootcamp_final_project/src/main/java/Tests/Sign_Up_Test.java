package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sign_Up_Test extends Basic_Test {

    @Test(priority = 10)
    public void visitsTheSignupPage() {
        nav_page.getSignUpButton().click();

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/signup"),
                "[ERROR] URL does not contain '/signup' route");
    }

    @Test(priority = 20)
    public void checksInputTypes() {
        nav_page.getSignUpButton().click();
        Assert.assertTrue(sign_up_page.getEmailInput()
                        .getAttribute("type").equals("email"),
                "[ERROR] Email is not type 'email'");

        Assert.assertTrue(sign_up_page.getPasswordInput()
                        .getAttribute("type").equals("password"),
                "[ERROR] Password is not type 'password'");

        Assert.assertTrue(sign_up_page.getConfirmPasswordInput()
                        .getAttribute("type").equals("password"),
                "[ERROR] Confirm password is not type 'password'");
    }

    @Test(priority = 30)
    public void displayErrorsWhenUsersAlreadyExists() {
        nav_page.getSignUpButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "[ERROR] URL route doesn't contain /signup");
        sign_up_page.getNameInput().sendKeys("Another Use");
        sign_up_page.getEmailInput().sendKeys("admin@admin.com");
        sign_up_page.getPasswordInput().sendKeys("12345");
        sign_up_page.getConfirmPasswordInput().sendKeys("12345");
        sign_up_page.getSignMeUpButton().click();

        message_pop_up_page.waitForPopUpToBeVisible();
        Assert.assertEquals(message_pop_up_page.getTextMessageFromPopUp()
                        .getText(),
                "E-mail already exists",
                "[ERROR] In pop up message does not exist 'E-mail already exists'");
        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/signup"),
                "[ERROR] URL does not contain /signup");

    }

    @Test(priority = 40)
    public void signup() {
        nav_page.getSignUpButton().click();

        sign_up_page.getNameInput().sendKeys("Bojana Stojanovicc");
        sign_up_page.getEmailInput().sendKeys("booojana@gmail.comm");
        sign_up_page.getPasswordInput().sendKeys("12345");
        sign_up_page.getConfirmPasswordInput().sendKeys("12345");
        sign_up_page.getSignMeUpButton().click();


        message_pop_up_page.waitForVerifyAccountPopUp();
        Assert.assertEquals(message_pop_up_page.getTextMessageFromVerifyPopUp().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] The message from pop-up does not 'IMPORTANT: Verify your account'.");

        message_pop_up_page.getCloseButtonFromVerifyAccountPopUp().click();

        nav_page.getLogoutButton().click();
    }
}
