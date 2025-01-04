package pomClasses;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.Utility;

import java.time.Duration;
import java.util.List;

import static steps.Base.driver;

public class BookAppointment {
    public BookAppointment(AndroidDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(2)),this);
    }
    public static Logger logger= LoggerFactory.getLogger(LoginPage.class);
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Consultation\"]") private WebElement consultationButtonOnDashboard;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"header_goback\"]") private WebElement headerGoBackButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Look for a doctor\"]") private WebElement lookForADoctorScreenTitle;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Appointments\"]") private WebElement appointmentsIcon;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"serchDoc_searchbar_id\"]") private WebElement searchBarForDoctorOnLookForADoctorScreen;
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"clear\"]") private WebElement clearButtonForSearchedString;
    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup//android.widget.TextView") private List<WebElement> recentSearchesValues;
    @AndroidFindBy(xpath = "(//android.widget.ScrollView[@resource-id=\"home_spec_list_id\"])[1]//android.widget.TextView") private List<WebElement> topSpecialitiesNamesOnLookForADoctorScreen;
    @AndroidFindBy(xpath = "(//android.widget.ScrollView[@resource-id=\"home_spec_list_id\"])[2]//android.widget.TextView") private List<WebElement> commonSymptomsNamesOnLookForADoctorScreen;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"See more\"])[1]") private WebElement seeMoreButtonForTopSpecialities;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"See more\"])[2]") private WebElement seeMoreButtonForCommonSymptoms;




    public void verifyConsultationButtonIsDisplayed()
    {
        Utility.explicitlyWait(consultationButtonOnDashboard,driver,10);
        if(consultationButtonOnDashboard.isDisplayed())
        {
            logger.info("Consultation button on dashboard is displayed.");
        }
        else
        {
            logger.error("Consultation button on dashboard not displayed");
        }
    }
    public void clickOnConsultationButton()
    {
        Utility.explicitlyWait(consultationButtonOnDashboard,driver,10);
        consultationButtonOnDashboard.click();
        logger.info("Clicked on Consultation button");
    }
    public void verifyUserPresentOnLookForADoctorScreen()
    {
        Utility.explicitlyWait(lookForADoctorScreenTitle,driver,10);
        if(lookForADoctorScreenTitle.isDisplayed())
        {
            logger.info("User able to see Look for a doctor screen");
        }
        else
        {
            logger.error("User not able to see Look for a doctor screen");
        }
    }
    public void clickOnHeaderBackBUtton()
    {
        Utility.explicitlyWait(headerGoBackButton,driver,10);
        headerGoBackButton.click();
        logger.info("Clicked on back arrow button");
    }


}
