Feature: Automation for reports from myjobs page on pro link
Scenario Outline: Check if Reports on pro is working fine
Given User logs in and navigate to reports page
When User downloads status reports
And User downloads sales register
Then User downloads purchase register
And Close the chrom3e Browse3r

#Examples:
#| username | password|
#| tanmayn | Citi5bank$ |



















