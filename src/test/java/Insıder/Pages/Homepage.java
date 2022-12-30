package Insıder.Pages;

import Insıder.utils.Driver;
import Insıder.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Helper {
    public  Homepage (){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "a[class='navbar-brand d-flex flex-row align-items-center'] img")
    public WebElement homePageLogo;
    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    public WebElement cookieBtn;
    @FindBy(xpath = "//span[normalize-space()='More']")
    public WebElement moreBtn;
    @FindBy(xpath = "//h5[normalize-space()='Careers']")
    public WebElement carierBtn;
    public void checkHomePageLogo (){
        Assert.assertTrue(homePageLogo.isDisplayed());
    }
    public void clickCookieBtn (){
        clickElement(cookieBtn);
    }
    public void clickMoreBtn (){
        clickElement(moreBtn);
    }
    public void clickCarrierBtn (){
        clickElement(carierBtn);
    }

}
