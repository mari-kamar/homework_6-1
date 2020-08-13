Feature: main page

  Scenario: check logo
    Given I am on main page
    Then I see logo is visible

  Scenario: check auth title
    Given I am on main page
    When I click auth button
    And write email and password
    Then auth title is visible

  Scenario: check auth button
    Given I am on main page
    When I click auth button
    And write email and password
    Then auth button is visible

  Scenario: check reg title
    Given I am on main page
    When I click reg button
    Then reg title is visible

  Scenario: check reg button
    Given I am on main page
    When I click reg button
    Then reg button is visible

  Scenario: check users info
    Given I am on main page
    When I click on users link
    And open Users info
    Then check rate

  Scenario: check users info
    Given I am on main page
    When I click on users link
    And open Users info
    Then rate status is visible

  Scenario: check language popup
    Given I am on main page
    When I click change language button
    Then change language popup is visible

  Scenario: check main title popup in english
    Given I am on main page
    When I click change language button
    And click english language
    Then check title in english
    And click save settings button

  Scenario: check search
    Given I am on main page
    When I make a request
    Then I check a request