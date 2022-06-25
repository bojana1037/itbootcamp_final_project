package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Locale_Tests extends Basic_Test{
    @Test(priority = 10)
    public void setLocaleToES() {
        nav_page.getLanguagesButton().click();
        nav_page.getSpanishLanguageButton().click();

        Assert.assertTrue(nav_page.getHeader().getText()
                        .contains("Página de aterrizaje"),
                "[ERROR] Header does not contain text 'Página de aterrizaje' ");
    }

    @Test(priority = 20)
    public void setLocaleToEN() {
        nav_page.getLanguagesButton().click();
        nav_page.getEnglishLanguageButton().click();

        Assert.assertTrue(nav_page.getHeader().getText()
                        .contains("Landing"),
                "[ERROR] Header does not contain text 'Landing' ");
    }


    @Test(priority = 30)
    public void setLocaleToCN() {
        nav_page.getLanguagesButton().click();
        nav_page.getChineseLanguageButton().click();

        Assert.assertTrue(nav_page.getHeader().getText()
                        .contains("首页"),
                "[ERROR] Header does not contain text '首页' ");
    }

    @Test(priority = 40)
    public void setLocaleToFR() {
        nav_page.getLanguagesButton().click();
        nav_page.getFrenchLanguageButton().click();

        Assert.assertTrue(nav_page.getHeader().getText()
                        .contains("Page d'atterrissage"),
                "[ERROR] Header does not contain text 'Page d'atterrissage' ");
    }
}
