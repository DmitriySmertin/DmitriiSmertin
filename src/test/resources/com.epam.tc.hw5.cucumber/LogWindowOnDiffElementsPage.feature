Feature: Log Window on Different Elements Page

  Scenario: Add entries to the Log Window when element states change on the DiffElement page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    When I open Different Elements Page
    And I select "Water" checkbox
    And I select "Wind" checkbox
    And I select "Selen" radiobutton
    And I select "Yellow" in dropdown
    Then All changes in the state of elements are reflected in the log window

