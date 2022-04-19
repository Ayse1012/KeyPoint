Feature: SuperAdmin is creates an Users

  Scenario: Super admin creates an users
    Given user navigate landing page
    Given user logs in as "superadmin@example.com" "Test123456!"
    When the user navigates to "Customers" menu and "School Admin" menu
    And the user clicks "Add School Admin" button to create
    And User inputs the moderator information
    And User clicks "Save" button
    Then User verifies the created moderator
