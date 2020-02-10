Feature: Atlas Login Feature

Scenario: Login with valid credentials

	Given user is on Atlas login screen.
	When user verifies page title
	When user enters username and password
	Then verify user is on homepage 