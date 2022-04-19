Feature: Question Create

  Scenario: Create questions
    Given user navigate landing page
    Given user navigate landing page and logs in as "editor@example.com" "Test123456!"
    When  user goes to "Questions" page and clicks to add questions
    And user selects subject and selects "ABSOLUTE VALUE "
    And user enters question "if 2*a=12 then a=?"
    And user enters choice "3" "4" "6" "7"
    And user enters answer "C"
