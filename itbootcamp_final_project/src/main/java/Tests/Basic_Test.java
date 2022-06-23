package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class Basic_Test {
    protected WebDriver driver;
    protected String basedUrl = "https://vue-demo.daniel-avellaneda.com";
    protected Login_Page login_page;
    protected Nav_Page nav_page;
    protected Sign_Up_Page sign_up_page;
    protected Cities_Page cities_page;
    protected Message_Pop_Up_Page message_pop_up_page;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        login_page = new Login_Page(driver);
        nav_page = new Nav_Page(driver);
        sign_up_page = new Sign_Up_Page(driver);
        cities_page = new Cities_Page(driver);
        message_pop_up_page = new Message_Pop_Up_Page(driver);
    }


    @BeforeMethod
    public void beforeMethod() {
        this.driver.get(basedUrl);
    }


    @AfterMethod
    public void afterMethod() {
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}



