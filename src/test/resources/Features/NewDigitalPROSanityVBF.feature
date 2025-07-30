
Feature: Digital
Scenario Outline: Sanity testing for Digital Vendor Billing First
Given User logs in and navigate to digital page for vbf
When User creates a new job and adds a campaign
And User creates estimate with outputs
Then User creates po with outputs
And User creates vendor bill
Then User sends for billing and creates client bill
And User does reverse flow till it unlinks the integrated campaign
Then Close the chrom3e Browse3rr

#Examples:
#| username | password|
#| tanmayn | Citi5bank$ |



















