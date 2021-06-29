Feature: Login to the Website

  Scenario Outline: User Signs Up to the Website
    Given user navigates to the website
    When user click on sign in link
    And user click on Sign in with IMDb button
    And user types in <emailID> and <password>
    Then clicks on the Sign In button
    And user should be able to log in to the website

    Examples: 
      | ID                     | password    |
      | testingsom14@gmail.com | testing1111 |
