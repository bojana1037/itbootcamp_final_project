package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Auth_Routes_Tests extends Basic_Test{
    @Test(priority = 10)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
        driver.navigate().to(basedUrl + "/home");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "[ERROR] URL does not contain '/login' ");
    }

    @Test(priority = 20)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.navigate().to(basedUrl + "/profile");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "[ERROR] URL does not contain '/login' ");
    }

    @Test(priority = 30)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.navigate().to(basedUrl + "/admin/cities");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "[Error] URL does not contain '/login' ");
    }

    @Test(priority = 40)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.navigate().to(basedUrl + "/admin/users");

        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/login"),
                "[Error] URL does not contain '/login' ");
    }

}
