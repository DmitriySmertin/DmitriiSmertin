Feature: Log Window on Different Elements Page

  Scenario: Add records in Log Window on DiffElement Page
    Given I open Index Page
    And I perform authorization
    When I open Different Elements Page
    And I select "Water" checkbox
    And I select "Wind" checkbox
    And I select "Selen" radiobutton
    And I select "Yellow" in dropdown
    Then All changes in the state of elements are reflected in the log window