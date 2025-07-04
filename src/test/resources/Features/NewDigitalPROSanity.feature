Feature: Automation for new digital on pro link
Scenario Outline: Check if digital flow on pro is working fine
Given User logs in and navigate to digital page
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



















