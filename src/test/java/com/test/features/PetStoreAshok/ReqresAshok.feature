Feature: Testing REQRES API's

  @REQRESGETAPI
  Scenario: Testing REQRES GET API's
    Given Prepare The Parameters to Hit API
    When I Hit the REQRES GET API
    Then I Print the Status Code and Response
    Then I Validate the Status Code and Response Body

  @PETSTOREPOSTAPI
  Scenario: Testing PETSTORE POST API's
    Given Prepare The Parameters to Hit API
    When I Hit the PETSTORE POST API
    Then I Print the Status Code and Response
    Then I Validate the PETSTORE POST API Status Code and Response Body