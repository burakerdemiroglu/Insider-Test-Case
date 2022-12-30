package Insıder.step_Def;

import Insıder.Pages.Carreerpage;
import Insıder.Pages.Homepage;
import Insıder.Pages.OpenPositionpage;
import Insıder.Pages.QualityAssurancePage;
import Insıder.utils.Driver;
import Insıder.utils.Helper;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CaseStudyTests extends Driver {
    Homepage _homepage;
    Helper _helper;
    Carreerpage _carreerpage;
    QualityAssurancePage _qualityAssurencepage;
    OpenPositionpage _openPositionpage;

    public CaseStudyTests() {
        _homepage = new Homepage();
        _helper = new Helper();
        _carreerpage = new Carreerpage();
        _qualityAssurencepage = new QualityAssurancePage();
        _openPositionpage = new OpenPositionpage();
    }

    @BeforeTest
    public void setup() {
        _helper.navigateToUrl("https://useinsider.com/");
    }

    @Test(priority = 1)
    public void firstStep() throws InterruptedException {
        Thread.sleep(1000);
        _homepage.checkHomePageLogo();
        _homepage.clickCookieBtn();
    }

    @Test(priority = 2)
    public void secondStep() {
        _homepage.clickMoreBtn();
        _homepage.clickCarrierBtn();
        _carreerpage.checkcarreerHomepage();
        _carreerpage.checkSeeAllBtn();
        _carreerpage.checkOurLocations();
        _carreerpage.checkLifeAtInsiderText();
    }

    @Test(priority = 3)
    public void thirdStep() throws InterruptedException {
        _carreerpage.clickSeeAllThemBtn();
        _carreerpage.clickQualityAssurance();
        _qualityAssurencepage.clickSeeAllBtn();
        _openPositionpage.clickJobsByLocation();
        _openPositionpage.clickByDepartman();
        _openPositionpage.checkJobList();
    }

    @Test(priority = 4)
    public void fourthStep() throws InterruptedException {
        _openPositionpage.verifyListingPositions("Quality Assurance", "QA", "Quality Assurance", "Istanbul, Turkey");
    }

    @Test(priority = 5)
    public void fifthStep() {
        _openPositionpage.verifyApplyNowButtonNavigation();
    }

    @AfterTest
    public void teardown() {
        closeDriver();
    }
}
