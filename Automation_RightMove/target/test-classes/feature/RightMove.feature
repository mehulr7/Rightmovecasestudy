Feature: Search Property

	@RightMoves
	Scenario: Search property and click on non feature property
	
	Given Home page of the web application
	When Enter city name under search text field
	And Carry out a For sale search
	And Select various filters in the dropdowns
	And Click on Find properties button
	And Change the sort order on the search results to newest listed
	And Choose the first non-feature property in the list
	Then Selected property should be open
	