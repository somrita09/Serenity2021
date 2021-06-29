Feature: Sign Up to the Website

#Test Data: Gmail ID (testingsom15@gmail.com ) and password (testing1111) for email OTP

  Scenario Outline: User Signs Up to the Website
    Given user navigates to the website
    When user click on sign in link
    And user clicks on the ‘Create a New Account’ button
    And user enters signing up details <Name> ,<ID> and <password>
    Then user should be able to sign in to the website
    
    Examples: 
      | Name | ID                     | password    |
      | Test | testingsom15@gmail.com | testing1111 |
      
