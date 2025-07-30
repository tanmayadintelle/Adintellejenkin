
Feature: Digital
Scenario Outline: Sanity testing for Digital Client Billing First
Given User logs in and navigate to digital page for cbf
When User creates a new job and adds a campaign for cbf
And User creates estimate with outputs for cbf
Then User sends for billing and creates client bill for cbf
And User creates po with outputs for cbf
Then User creates vendor bill for cbf
And User does reverse flow till it unlinks the integrated campaign for cbf
Then Close the chrom3e Browse3rr for cbf

#Examples:
#| username | password|
#| tanmayn | Citi5bank$ |



















