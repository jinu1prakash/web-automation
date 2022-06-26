@myntratestcases
  Feature: Test basic functionalities
    Scenario Outline: Hover and Click to order
    Given I open the <webpage>
      When I hover and click the Casual Shirt link in Mens
      Examples:
        | webpage |
      |          https://www.myntra.com/|