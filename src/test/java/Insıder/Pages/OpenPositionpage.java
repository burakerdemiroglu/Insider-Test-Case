package Insıder.Pages;

import Insıder.utils.Driver;
import Insıder.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenPositionpage extends Helper {
    public OpenPositionpage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#select2-filter-by-location-container")
    public WebElement filterLocationBtn;
    @FindBy(xpath = "//li[contains(@id, 'Istanbul, Turkey')]")
    public WebElement filterLocationIstanbul;
    @FindBy(css = "#select2-filter-by-department-container")
    public WebElement filterByDepartman;
    @FindBy(xpath = "//span[@title=\"Quality Assurance\"]")
    public WebElement filterQultyAssurance;
    @FindBy(id = "jobs-list")
    public WebElement jobsListContainer;
    @FindBy(id = "deneme")
    public WebElement totalPositionText;

    public void clickJobsByLocation() {
        clickElement(filterLocationBtn);
        clickElement(filterLocationIstanbul);
    }

    public void clickByDepartman() {
        clickElement(filterByDepartman);
        clickElement(filterQultyAssurance);
    }

    public void checkJobList() {
        Assert.assertTrue(jobsListContainer.isDisplayed());
    }

    public void verifyListingPositions(String positionTitle, String positionAbbreviation, String department, String location) throws InterruptedException {
        Thread.sleep(2000);
        int totalPositions = Integer.parseInt(totalPositionText.getText());

        for (int i = 1; i <= totalPositions; i++) {
            assertElementTextContains(findByXpath(("(//p[contains(@class, 'position-title')])[" + i + "]")), positionTitle, positionAbbreviation);
            assertElementText(findByXpath(("(//span[contains(@class, 'position-department')])[" + i + "]")), department);
            assertElementText(findByXpath(("(//div[contains(@class, 'position-location')])[" + i + "]")), location);
            assertElementIsEnabled(findByXpath(("(//a[text()= 'Apply Now'])[" + i + "]")));
        }
    }

    public void verifyApplyNowButtonNavigation() {
        int totalPositions = Integer.parseInt(totalPositionText.getText());

        for (int i = 1; i <= totalPositions; i++) {
            click(findByXpath(("(//a[text()= 'Apply Now'])[" + i + "]")));
            switchLastTabb();
            assertElementIsEnabled(findByXpath("//img[contains (@alt, 'Insider. logo')]"));
            assertUrlContains("https://jobs.lever.co/useinsider");
            closeTab();
            switchToMainTab();
        }
    }

}
