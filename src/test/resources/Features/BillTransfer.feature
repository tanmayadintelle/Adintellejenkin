
Feature: Bill Transfer

Scenario Outline: Sanity testing for Bill Transfer
Given User completes Bill Transfer flow
#When User enter valid "<username>" an "<password>"
And Downloads reports
#Then User should be navigated to home page
Then Closes the chrome Browser

#Examples:
  #| status   |
  #| Success  |
  #| Failure  |
  #| Not found  |

















