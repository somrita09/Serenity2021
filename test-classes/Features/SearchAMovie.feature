Feature: Search a movie from Menu in the Website

  Scenario Outline: User Search for GOT Movie
    Given user navigates to the website
    When user click on Menu button
    And user select Top Rated Shows link under TV Shows category
    And user search for a <Movie> in searchbox
    And Click on a <Movie_link> from the suggestion window
    Then <Movie_title> should be correctly displayed
    And Movie <Rating> should be displayed
    And number of <User_Reviews> and <Critic_Reviews> for the Movie should be displayed

    Examples: 
      | Movie           | Movie_link                      | Movie_title                     | Rating | User_Reviews | Critic_Reviews |
      | Game of thrones | Game of Thrones: The Last Watch | Game of Thrones: The Last Watch |    7.2 | 73 user      | 8 critic       |
