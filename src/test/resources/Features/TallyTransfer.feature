
Feature: Tally Transfer

Scenario Outline: Sanity testing for Tally Transfer
Given User completes Tally Transfer flow
#When User enter valid "<username>" an "<password>"
And Downloads reports for Tally Transfer
#Then User should be navigated to home page
Then Closes the chromes Browser completely

#Examples:
  #| status   |
  #| Success  |
  #| Failure  |
  #| Not found  |

















