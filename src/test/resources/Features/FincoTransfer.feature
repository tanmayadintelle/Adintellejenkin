
Feature: Finco Transfer

Scenario Outline: Sanity testing for Finco Transfer
Given User completes Finco Transfer flow
#When User enter valid "<username>" an "<password>"
And Downloads reports for Finco Transfer
#Then User should be navigated to home page
Then Closes the chrome Browser completely

#Examples:
  #| status   |
  #| Success  |
  #| Failure  |
  #| Not found  |

















