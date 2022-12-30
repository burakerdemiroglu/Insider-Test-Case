package Insıder.Pages;

import Insıder.utils.Driver;
import Insıder.utils.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QualityAssurancePage extends Helper {
    public QualityAssurancePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (xpath = "//a[normalize-space()='See all QA jobs']")
    public WebElement seeAllBtn;

    public void clickSeeAllBtn(){
        clickElement(seeAllBtn);
    }
}
