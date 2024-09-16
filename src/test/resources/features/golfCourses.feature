Feature: GolfCoursesPage
  Background: Navigate to HomePage
    Given Navigate to HomePage
#    Then Verify navigate to Homepage successful
    When Click on Test button
    And Click on GolfCourse
    Then Verify navigate to GolfCoursePage successful
  Scenario Outline: Check search Golf courses by name (Test case Faile)
    When Input GolfCourses name "<name>"
    And Click on search button
#    Then Verify result list contain name "<name>"
    Then Verify result list contain name "drftgyhujikt"
    When Screenshot "Search by name <name>"
    Examples:
      | name |
      | Ti   |

  Scenario Outline: Check search Golf courses by name
    When Input GolfCourses name "<name>"
    And Click on search button
    Then Verify result list contain name "<name>"
    When Screenshot "Search by name <name>"
    Examples:
      | name    |
      | Tiger   |
      | Tiger A |

  Scenario Outline: Check search Golf courses by country
    When Select country "<country>" at selected button
    And Click on Filter button
    Then Verify result list contain country "<country>"
    When Screenshot "Search by country <country>"
    Examples:
      | country |
      | Canada  |
      | Iceland |