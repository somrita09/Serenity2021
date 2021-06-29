Feature: Search functionalities for the Website

  Scenario Outline: Verify search by category function
    Given user navigates to the website
    When user verify the search box for watermark text
    Then user should be displayed with watermark text
    When user click on search Without entering anything in search box
    And user click on search button/press enter
    Then user is navigated to find page
    When user select <category> from the category dropdown and enter <optiontext> in the searchbox
    Then suggestion dropdown should be displayed
    When user clicks on search button
    Then user is displayed with search result for <category> and <optiontext>

    Examples: 
      | category    | optiontext |
      | All         | Christmas  |
      | Titles      | Scary      |
      | TV Episodes | FRIENDS    |
      | Celebs      | Robert     |
      | Companies   | Viacom     |
      | Keywords    | SpongeBob  |

  Scenario Outline: Verify Advanced search functionality for Movies, TV & Video Games Category
    Given user navigates to the website
    When user select <category> from the category dropdown
    When user clicks on search button
    Then user is displayed with Advanced search page
    When user select <Search_Category> link
    Then user should be displayed with Advanced Title Search page
    Then verify Advanced Title Search page fields
    When user enters values in Advanced Title Search fields
    And user clicks on search button
    Then user should be displayed with Advanced Title Search search results

    Examples: 
      | category        | Search_Category          | Title   | Title Type | Release Date | User Rating | Number of Votes | Genres | Title Groups | Title Data | Companies | Instant Watch Options | US Certificates | Color Info | Countries | Keyword | Languages | Filming Locations | Popularity | Plot | Cast/Crew | Runtime | Sound Mix | Your Ratings | In Theaters | Adult Titles | Display Options |
      | Advanced Search | Movies, TV & Video Games | Friends | TV Movie   |              |             |                 |        |              |            |           |                       |                 |            |           |         |           |                   |            |      |           |         |           |              |             |              |                 |

  Scenario Outline: Verify Advanced search functionality for People Category
    Given user navigates to the website
    When user select <category> from the category dropdown
    When user clicks on search button
    Then user is displayed with Advanced search page
    When user select <Search_Category> link
    Then user should be displayed with Advanced Name Search page
    Then verify Advanced Name Search page fields
    When user enters values in Advanced Name Search fields
    And user clicks on search button
    Then user should be displayed with Advanced Name Search search results

    Examples: 
      | category        | Search_Entertainment | Name        | Birth Date | Birthday | Name Groups | Star Sign | Birth Place | Death Date | Death Place | Gender | Filmography | Biographies | Name Data | Adult Names | Display Options |
      | Advanced Search | People               | Johnny Depp |            |          |             |           |             |            |             |        |             |             |           |             |                 |

  Scenario Outline: Verify Advanced search functionality for Collaborations Category
    Given user navigates to the website
    When user select <category> from the category dropdown
    When user clicks on search button
    Then user is displayed with Advanced search page
    When user select <Search_Category> link
    Then user should be displayed with Search Collaborations page
    Then verify Search Collaborations page fields
    When user selects <Type> and enters values in Search Collaborations fields
    And user clicks on search button
    Then user should be displayed with Search Collaborations search results

    Examples: 
      | category        | Search_Category | Type                            | Input_1          | Input_2             |
      | Advanced Search | Collaborations  | Two People in the Same Title    | Johnny Depp      | John Goodman (I)    |
      | Advanced Search | Collaborations  | Two Titles with the Same People | Mr. Robot (2015) | The Ice Road (2021) |

  Scenario Outline: Verify Advanced search functionality by Search Within a Topic fields
    Given user navigates to the website
    When user select <category> from the category dropdown
    When user clicks on search button
    Then user is displayed with Advanced search page
    And verify Search Within a Topic page fields
    When user selects <Type> and enters values in Search Within a Topic field and clicks on search button
    Then user should be displayed with Search Within a Topic search results

    Examples: 
      | category        | Search_Category       | Type                       | Input_1 | Input_2 |  |
      | Advanced Search | Search Within a Topic | Movies, TV and Video Games | Trivia  | Horses  |  |
      | Advanced Search | Search Within a Topic | People                     | Quotes  | happy   |  |

  Scenario Outline: Verify Validation message should be shown when special characters are entered in the username field
    Given user navigates to the website
    When user Enter invalid character in search box
    Then warning text should be displayed
      |  |  | No results found |

  Scenario Outline: Verify suggestion dropdown
    Given user navigates to the website
    When user Enter any one character in search box
    Then suggestion dropdown should be displayed
    When user clicks on all search result link
    Then All search result should be displayed

  Scenario Outline: Enter any one character in search box and click on Search button/press Enter key.
    Given user navigates to the website
    When user Enter any one character in search box
    Then suggestion dropdown should be displayed
    When Enter string more than the max char limit of the search field.
    Then Max limit error message should be displayed
