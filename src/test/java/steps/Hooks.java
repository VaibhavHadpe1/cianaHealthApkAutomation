package steps;

import basePackage.AppiumServerClass;
import basePackage.EmulatorLauncher;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import pomClasses.LoginPage;
import utility.Utility;

import java.io.IOException;


public class Hooks extends Base{
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    @BeforeAll
    public static void setUp() throws InterruptedException, IOException {
        EmulatorLauncher.startEmulator();
        AppiumServerClass.startAppium();
        Utility.setDriver();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.opencianahealth();
        loginPage.enterValidMobileNumber();
        loginPage.enterValidPassword();
        loginPage.clickOnSignInButton();
        loginPage.selectPrimaryUser();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        // Set up ExtentSparkReporter and create a report file
        if (extentReports == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-report/extent-report.html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }

        // Create a new test for each scenario
        extentTest = extentReports.createTest(scenario.getName());

    }
    @After
    public void afterScenario(Scenario scenario)
    {
        if (scenario.isFailed()) {
            extentTest.fail(scenario.getName() + " failed: " + scenario.getStatus());
        } else {
            extentTest.pass(scenario.getName() + " passed.");
        }
        // Write the results to the report
        extentReports.flush();
    }
    @AfterAll
    public static void tearDown() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.viewAccountDetailsScreen();
        loginPage.logout();
        loginPage.clickOnHome();
        Thread.sleep(2000);

        // This will stop the Appium server after each scenario
        if (driver != null) {
            System.out.println("CleanedUp Appium session");
            driver.quit(); // This will stop the Appium server and close the app
            AppiumServerClass.stopAppium();
        }
        else {
            System.out.println("Server is not stopped");
        }

    }
}

