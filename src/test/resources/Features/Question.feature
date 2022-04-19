Feature: Question Create

  Background:
    Given user navigate landing page
    Given user logs in as "editor@example.com" "Test123456!"
  Scenario: Create questions
    When  user goes to "Questions" page and clicks to add questions
    And user selects subject and selects "ABSOLUTE VALUE "
    And user enters question "Circle the value of the digit 2 in the answer to 5200 ÷ 10"
    And user enters choice "2" "20" "200" "2000"
    And user selects "language" "EN"
    And user selects "questionType" "ONE_ANSWER"
    And user selects add question level "10" "A"
    And user enters answer "B"
    Then user  click to "Save"

    Scenario: Questions Approved
      When  user goes to "Questions" page and clicks to "All Questions"
      And  editor approved sends a question "CREATED" and "Send To Approve"

