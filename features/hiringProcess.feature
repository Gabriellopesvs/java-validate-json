Feature: Hiring Process for Companies

  @test
  Scenario: Evaluate candidates for each company
    Given a GET is performed on the endpoint "http://demo3970188.mockable.io/"
    When validates which candidates are over 18 years old to go to the first process
    And which candidates have as true in the area of experience for the second process
    Then and which candidates fall under the rules of the companies

