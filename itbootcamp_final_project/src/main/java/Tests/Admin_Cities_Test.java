package Tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Admin_Cities_Test extends Basic_Test {

    @Test(priority = 10)
    public void visitsTheAdminCitiesPageAndListCities() {

        nav_page.getLoginButton().click();
        login_page.getEmailInput().sendKeys("admin@admin.com");
        login_page.getPasswordInput().sendKeys("12345");
        login_page.getLoginButton().click();

        nav_page.getAdminButton().click();
        nav_page.getCitiesButton().click();

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/admin/cities"),
                "[ERROR] URL does not contain '/admin/cities'");
    }

    @Test(priority = 20)
    public void checksInputTypesForCreateOrEditNewCity() {
        nav_page.getAdminButton().click();
        nav_page.getCitiesButton().click();

        cities_page.getNewItemButton().click();
        cities_page.waitForCreateOrEditDialogueToBeVisible();

        Assert.assertEquals(cities_page.getNewItemName()
                        .getAttribute("type"),
                "text",
                "[ERROR] New item name is not type 'text'");
    }

    @Test(priority = 30)
    public void createNewCity() {

        nav_page.getAdminButton().click();
        nav_page.getCitiesButton().click();

        cities_page.getNewItemButton().click();
        cities_page.waitForCreateOrEditDialogueToBeVisible();

        cities_page.getNewItemName().sendKeys("Madrid");
        cities_page.getSaveCityButton().click();

        message_pop_up_page.waitForMessageSuccessfullySaveCity();
        Assert.assertTrue(message_pop_up_page.getMessageTextSuccessfullySaveCity()
                        .getText().contains("Saved successfully"),
                "[ERROR] The message does not contain 'Saved successfully'");
    }

    @Test(priority = 40)
    public void editCity() {


        nav_page.getAdminButton().click();
        nav_page.getCitiesButton().click();

        cities_page.getSearchInput().sendKeys("Madrid");
        cities_page.waitForNumberOfRows(1);
        cities_page.getEditButton(1).click();
        cities_page.getNewItemName().click();


        cities_page.getNewItemName().sendKeys(Keys.CONTROL,"a");
        cities_page.getNewItemName().sendKeys("Barselona");
        cities_page.getSaveCityButton().click();

        message_pop_up_page.waitForMessageSuccessfullySaveCity();
        Assert.assertTrue(message_pop_up_page.getMessageTextSuccessfullySaveCity()
                        .getText().contains("Saved successfully"),
                "[ERROR] The message from pop-up does not contain 'Saved successfully'");
    }



    @Test(priority = 50)
    public void searchCity(){

        nav_page.getAdminButton().click();
        nav_page.getCitiesButton().click();

        cities_page.getSearchInput().sendKeys("Barselona");
        cities_page.waitForNumberOfRows(1);

        Assert.assertEquals(cities_page.getCellFromTheTable(1, 2).getText(),
                "Barselona",
                "[ERROR] City with that name does not exist.");
    }


    @Test(priority = 60)
    public void deleteCity(){

        nav_page.getAdminButton().click();
        nav_page.getCitiesButton().click();

        cities_page.getSearchInput().sendKeys("Barselona");
        cities_page.waitForNumberOfRows(1);

        Assert.assertEquals(cities_page.getCellFromTheTable(1, 2).getText(),
                "Barselona",
                "[ERROR] City with that name does not exist.");

        cities_page.getDeleteButtonFromRow(1).click();
        cities_page.waitForDeletePopUp();
        cities_page.getDeleteButtonFromDialogue().click();

        message_pop_up_page.waitForMessageSuccessfullySaveCity();
        Assert.assertTrue(message_pop_up_page.getMessageTextSuccessfullySaveCity()
                        .getText().contains("Deleted successfully"),
                "[ERROR] The message from pop-up does not contain 'Deleted successfully'");
    }
}

