package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomClasses.BookAppointment;
import utility.Utility;

public class BookAppointmentSteps {
    AndroidDriver driver;
    BookAppointment bookAppointment;
    public BookAppointmentSteps(){
        driver= Utility.getDriver();
        bookAppointment=new BookAppointment(driver);
    }
    @Then("the Consultation button should be displayed on the dashboard footer")
    public void the_consultation_button_should_be_displayed_on_the_dashboard_footer() {
        bookAppointment.verifyConsultationButtonIsDisplayed();
    }

    @When("the consultation button is displayed in the dashboard footer")
    public void the_Consultation_Button_Is_Displayed_In_The_Dashboard_Footer() {
        bookAppointment.verifyConsultationButtonIsDisplayed();
    }

    @And("the user clicks on the consultation button")
    public void the_user_clicks_on_the_consultation_button() {
        bookAppointment.clickOnConsultationButton();
    }


    @Then("the user should be navigated to the Look for a doctor screen")
    public void the_User_Should_Be_Navigated_To_The_Look_For_A_Doctor_Screen() {
        bookAppointment.verifyUserPresentOnLookForADoctorScreen();
        bookAppointment.clickOnHeaderBackBUtton();
    }
}
