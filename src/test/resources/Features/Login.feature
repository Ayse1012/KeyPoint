@login
Feature:Success and unsuccessful user logins

  Background:
    Given user navigate landing page
  @correctLogin
  Scenario Outline: valid login
    When enter valid credentials "<username>" "<password>" and click login
    Then verify message "<message>"
    Examples:
      | username                | password    | message   |
      | superadmin@example.com  | Test123456! | Dashboard |
      | moderator@example.com   | Test123456! | Dashboard |
      | schooladmin@example.com | Test123456! | Dashboard |

  Scenario Outline: invalid login
    When enter valid credentials "<username>" "<password>" and click login
    Then verify errorMessage "<message>"
    Examples:
      | username               | password    | message                          |
      | superadmi@example.com  | Test123456! | Username or password not correct |
      | moderator@example.com  | Test123456  | Username or password not correct |
      |                        | Test123456! | This field is required.          |
      | superadmin@example.com |             | Please enter your password       |
      | superadminexample.com  | Test123456! | Please enter a valid email       |
      | superadmin@example     | Test123456! | Please enter a valid email       |
      | salesman@example.com   | Test123456! | Username or password not correct |

