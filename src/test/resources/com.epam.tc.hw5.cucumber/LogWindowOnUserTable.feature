Feature: Log Window on User Table Page

  Scenario: Add log row to the Log Window when element states change on the User Table page
    Given I open JDI GitHub site
    And I login as user "Roman Iovlev"
    And I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    When When I select 'vip' checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section



