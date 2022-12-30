package Insıder.Pages;

import Insıder.utils.Driver;
import Insıder.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Carreerpage extends Helper {
    public Carreerpage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Ready to disrupt?']")
    public WebElement carreerHomepage;
    @FindBy(xpath = "//a[normalize-space()='See all teams']")
    public WebElement seeAllTeamsBtn;
    @FindBy(css = ".category-title-media.ml-0")
    public WebElement ourLocationsTex;
    @FindBy(xpath = "//h2[normalize-space()='Life at Insider']")
    public WebElement lifeAtInsiderText;
    @FindBy(xpath = "//h3[normalize-space()='Quality Assurance']")
    public WebElement QualityAssuranceBtn;
    @FindBy(xpath = "//h3[normalize-space()='Sales']")
    public WebElement salesScrool;

    public void checkcarreerHomepage() {
        Assert.assertTrue(carreerHomepage.isDisplayed());
    }

    public void checkSeeAllBtn() {
        scrollIntoView(seeAllTeamsBtn);
        Assert.assertTrue(seeAllTeamsBtn.isDisplayed());
    }

    public void checkOurLocations() {
        Assert.assertTrue(ourLocationsTex.isDisplayed());
    }

    public void checkLifeAtInsiderText() {
        scrollIntoView(lifeAtInsiderText);
        Assert.assertTrue(lifeAtInsiderText.isDisplayed());
    }

    public void clickSeeAllThemBtn() throws InterruptedException {

        scrollIntoView(salesScrool);
        Thread.sleep(5000);
        clickElement(seeAllTeamsBtn);
    }

    public void clickQualityAssurance() throws InterruptedException {
        scrollIntoView(QualityAssuranceBtn);
        Thread.sleep(5000);
        clickElement(QualityAssuranceBtn);
    }

}
