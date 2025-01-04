@run
Feature: Book Appointment

  As a registered user
  I want to be able to log in to cianahealth
  So that I can Book Appointment successfully

  Scenario: To verify that the Consultation button is displayed on the dashboard footer.
    Given the user present on dashboard
    Then the Consultation button should be displayed on the dashboard footer

  Scenario: To verify that clicking the Consultation button navigates the user to the Look for a Doctor screen.
    Given the user present on dashboard
    When the consultation button is displayed in the dashboard footer
    And the user clicks on the consultation button
    Then the user should be navigated to the Look for a doctor screen
