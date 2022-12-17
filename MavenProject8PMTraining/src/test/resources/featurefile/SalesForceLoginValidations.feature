Feature: Validating the login functionality of an salesforce application

  @SmokeTest @AlphaTeam @SC1
  Scenario: To Validate the login functionality with invalid user
    Given User navigates to Salesforce Application
    When User Enters the username "Aravith" and password "123"
    And User clicks the login button
    Then User validates the error message

   @RegressionTest @SmokeTest @AlphaTeam @SC2
  Scenario: To Validate the login functionality with valid user
    Given User navigates to Salesforce Application
    When User Enters the username "Xyz" and password "abc"
    And User clicks the login button
    Then User should naviagte to the homepage

    @PerformanceTest @AlphaTeam @SC3
  Scenario Outline: Multiple test data
    Given User navigates to Salesforce Application
    When User Enters the username "<user name>" and password "<password>"
    And User clicks the login button
    Then User validates the error message
    Examples:
    |user name|password|
    |Ravi     |2345    |
    |Apple    |fgh     |
    |flower   |rty     |

    Scenario: Sign up
      Given User navigates to Salesforce Application
      When User enter the below details
      |FirstName|Last Name |Age |Mobile|
      |Aravinth |A N       |27  |12345 |
      And User clicks the login button

    @StaticDropdown
    Scenario: To handle the static Dropdown
      Given User navigate to the required url
      When User selects the required value from the dropdown
      Then iterate the dropdownvalues

  @Dynamic
  Scenario: To handle the static Dropdown
    Given User navigate to the required url
    When User selects the required value from the dynamic dropdown

  @AutoSuggestive
  Scenario: Handle the Auto Suggestive
    Given User navigate to the required url
    When User Handles the auto suggestive

   @Frame
  Scenario: Handle frame and Mouse hower Actions
    Given User navigate to the required url
    When switch inside the frame

     @Count
  Scenario: Count Link
    Given User navigate to the required url
    When count the link
