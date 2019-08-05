
## Pre-requisites:

- MacOS
- Java 
- Maven 
- TestNG
- Chrome browser *(latest version)*


## Note

Has been used the latest *chromedriver* version and the chromedriver file is added in the resource folder in `/src/test/resources/drivers/chromedriver`.

Maybe, the permission error can be thrown, such as `java.lang.IllegalStateException: The driver is not executable`.

The solution for this, is to type in terminal `chmod +x .../src/test/resources/drivers/chromedriver`, so it is to grant a full permission to the chromedriver in the execution.


###  Running the test suite

The suites can be run by using maven command. The project is organized in the suites below:

- Regression Suite:
 `mvn clean test -DsuiteXmlFile=test-suites/regression-suite.xml`
 
- Unsuccessful Suite: 
`mvn clean test -DsuiteXmlFile=test-suites/unsuccesful-suite.xml`

- All Suites *(Regression Suite + Unsuccessful Suite)*: 
`mvn clean test -DsuiteXmlFile=test-suites/all-suites.xml`


###  Test Cases that cover CRUD operations

- The regression tests covers the most important functionalities of the system.
- The unsuccessful tests contains the alert validation for text field.

1 - CREATE A NEW COMPUTER:

1.1 - SUCCESSFUL SCENARIOS (Regression):

	- Add a new computer by filling out all fields with valid data 
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input a valid introduced date
		AND   input a valid discontinued date
		AND   select a company
		AND   click on Submit button
		THEN  should return back to the search page
		AND  show a success message
		

	- Add a new computer by inputting only a valid computer name 
		GIVEN I am in the register page
		WHEN input a valid computer name
		AND  click on Submit button
		THEN  should return back to search page
		AND  show a success message


	- Add a new computer by inputting a computer name and a valid introduced date
		GIVEN I am in the register page
		WHEN input a valid computer name
		AND input a valid introduced date
		AND click on Submit button
		THEN  should return back to search page
		AND  show a success message


	- Add a new computer by inputting a computer name and a valid discontinued date
		GIVEN I am in the register page
		WHEN input a valid computer name
		AND input a valid discontinued date
		AND click on Submit button
		THEN  should return back to search page
		AND  show a success message


	- Add a new computer by inputting a computer name and selecting a company
		GIVEN I am in the register page
		WHEN input a valid computer name
		AND select a company
		AND click on Submit button
		THEN  should return back to search page
		AND  show a success message


1.2 - UNSUCCESSFUL SCENARIOS:

	- Add a new computer by inputting with an empty computer name 
		GIVEN I am in the register page
		WHEN click on Submit button
		THEN should show an error message in the computer name field


	- Add a new computer by  passing spaces in computer name 
		GIVEN I am in the register page
		WHEN input spaces in computer name
		AND click on Submit button
		THEN should show an error message in the computer name field


	- Add a new computer by passing an invalid date format in introduced date field
		GIVEN I am in the register page
		WHEN  input an invalid date format introduced date
		AND   click on Submit button
		THEN  should show an error message in the introduced date field


	- Add a new computer by passing spaces in introduced date field
		GIVEN I am in the register page
		WHEN  input spaces in introduced date
		AND   click on Submit button
		THEN  should show an error message in the introduced date field


	- Add a new computer by passing letters in introduced date field
		GIVEN I am in the register page
		WHEN  input letters in introduced date
		AND   click on Submit button
		THEN  should show an error message in the introduced date field


	- Add a new computer by passing an invalid date format in discontinued date field
		GIVEN I am in the register page
		WHEN  input an invalid date format discontinued date
		AND   click on Submit button
		THEN  should show an error message in the discontinued date field


	- Add a new computer by passing spaces in discontinued date field
		GIVEN I am in the register page
		WHEN  input spaces in discontinued date
		AND   click on Submit button
		THEN  should show an error message in the discontinued date field


	- Add a new computer by passing letters in discontinued date field
		GIVEN I am in the register page
		WHEN  input letters in discontinued date
		AND   click on Submit button
		THEN  should show an error message in the discontinued date field
		
		
	- Add a new computer by passing empty computer name and invalid introduced date and invalid discontinued date
		GIVEN I am in the register page
		WHEN  input spaces in computer name
		AND  input an invalid value in introduced date
		AND  input an invalid value in discontinued date
		AND  click on Submit button
		THEN should show an error message in computer name field
		AND  should show an error message in introduced date field
		AND  should show an error message in discontinued date field


1.3 - VALIDATE INTRODUCED DATE FORMAT *(Perform manually)*:

	- Add a new computer by filling out a valid introduced date regarding January
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-01-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Jan 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding February
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-02-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Feb 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding March
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-03-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Mar 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding April
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-04-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Apr 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding May
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-05-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 May 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding June
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-06-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Jun 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding July
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-07-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Jul 2000'


	- Add a new computer by filling out a valid introduced date regarding August
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-08-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Aug 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding September
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-09-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Sep 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding October
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-10-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Oct 2000'
		
		
	- Add a new computer by filling out a valid introduced date regarding November
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-11-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Nov 2000'	
		
		
	- Add a new computer by filling out a valid introduced date regarding December
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-12-01' in introduced date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Introduced date column should contain '01 Dec 2000'	
		
		
1.3 - VALIDATE DISCONTINUED DATE FORMAT *(Perform manually)*:

	- Add a new computer by filling out a valid discontinued date regarding January
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-01-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Jan 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding February
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-02-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Feb 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding March
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-03-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Mar 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding April
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-04-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Apr 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding May
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-05-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 May 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding June
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-06-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Jun 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding July
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-07-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Jul 2000'


	- Add a new computer by filling out a valid discontinued date regarding August
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-08-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Aug 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding September
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-09-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Sep 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding October
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-10-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Oct 2000'
		
		
	- Add a new computer by filling out a valid discontinued date regarding November
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-11-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Nov 2000'	
		
		
	- Add a new computer by filling out a valid discontinued date regarding December
		GIVEN I am in the register page
		WHEN  input a valid computer name
		AND   input '2000-12-01' in discontinued date
		AND   click on Submit button
		THEN  should return back to the search page
		AND   Discontinued date column should contain '01 Dec 2000'			
		
			
-----------------------------------------------------------------------------------------

2 - READ COMPUTERS:

2.1 - SUCCESSFUL SCENARIOS (Regression):

	- Select less than 10 items in the table 
		GIVEN I am in the search page
		WHEN I input 'ACE' in search field
		AND  click on filter button
		THEN should bring only one page 
		AND show less than 10 items


	- Select only 1 item in the table 
		GIVEN I am in the search page
		WHEN I input 'nintendo 64' in search field
		AND  click on filter button
		THEN should return only 1 computer


	- Do not find any item in the search
		GIVEN I am in the search page
		WHEN I input '123' in search field
		AND  click on filter button
		THEN should not return any computer
		AND display the message 'Nothing to display'


	- Select more than 10 items (Pagination)
		GIVEN I am in the search page
		WHEN I input 'CE' in search field
		AND  click on filter button
		THEN should bring more than 1 page


	- Pagination (Go to next page)
		GIVEN I am in the search page
		AND  search field is empty
		AND  click on filter button
		WHEN click on 'Next' button
		THEN should navigate to next page


	- Pagination (Return to previous page)
		GIVEN I am in the search page
		AND  search field is empty
		AND  click on filter button
		AND click on 'Next' button
		WHEN click on 'Previous' button
		THEN should return back the previous page


-----------------------------------------------------------------------------------------

3 - UPDATE AN EXISTING COMPUTER:

3.1 - SUCCESSFUL SCENARIOS (Regression):

	- Update all fields with valid date
		GIVEN I am in the edit page
		WHEN  input a valid computer name
		AND   input a valid introduced date
		AND   input a valid discontinued date
		AND   select a company
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message


	- Update only computer name which is required field passing a valid value
		GIVEN I am in the edit page
		WHEN  input a valid computer name
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message


	- Update computer name and introduced date together passing valid values
		GIVEN I am in the edit page
		WHEN  input a valid computer name
		AND   input a valid introduced date
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message


	- Update computer name and discontinued date together passing valid values
		GIVEN I am in the edit page
		WHEN  input a valid computer name
		AND   input a valid discontinued date
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message


	- Update computer name and select a different company
		GIVEN I am in the edit page
		WHEN  select a different company
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message



3.2 - SUCCESSFUL SCENARIOS *(Update single fields)*:

	- Update only introduced date passing a valid format date
		GIVEN I am in the edit page
		WHEN   input a valid introduced date
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message

	- Update only discontinued date passing a valid format date
		GIVEN I am in the edit page
		WHEN  input a valid discontinued date
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message

	- Update only company by selecting another company
		GIVEN I am in the edit page
		WHEN  select a different company
		AND   click on Submit button
		THEN  should return back to search page
		AND  show a success message


3.2 - UNSUCCESSFUL SCENARIOS:

	- Update a computer by passing spaces in computer name 
		GIVEN I am in the edit page
		WHEN input spaces in computer name
		AND click on Submit button
		THEN should show an error message in the computer name field


	- Update a computer by passing an invalid date format in introduced date field
		GIVEN I am in the edit page
		WHEN input an invalid date format in introduced date
		AND click on Submit button
		THEN should show an error message in the introduced date field


	- Update a computer by passing spaces in introduced date field
		GIVEN I am in the edit page
		WHEN input spaces in introduced date
		AND click on Submit button
		THEN should show an error message in the introduced date field


	- Update a computer by passing letters in introduced date field
		GIVEN I am in the edit page
		WHEN input letters in introduced date
		AND click on Submit button
		THEN should show an error message in the introduced date field


	- Update a computer by passing an invalid date format in discontinued date field
		GIVEN I am in the edit page
		WHEN input an invalid date format in discontinued date
		AND click on Submit button
		THEN should show an error message in the discontinued date field


	- Update a computer by passing spaces in discontinued date field
		GIVEN I am in the edit page
		WHEN input spaces in discontinued date
		AND click on Submit button
		THEN should show an error message in the discontinued date field


	- Update a computer by passing letters in discontinued date field
		GIVEN I am in the edit page
		WHEN input letters in discontinued date
		AND click on Submit button
		THEN should show an error message in the discontinued date field


	- Update a computer by passing empty computer name and invalid introduced date and invalid discontinued date
		GIVEN I am in the edit page
		WHEN  input spaces in computer name
		AND  input an invalid value in introduced date
		AND  input an invalid value in discontinued date
		AND  click on Submit button
		THEN should show an error message in computer name field
		AND  should show an error message in introduced date field
		AND  should show an error message in discontinued date field


-----------------------------------------------------------------------------------------


4 - DELETE AN EXISTING COMPUTER:

4.1 - SUCCESSFUL SCENARIOS (Regression):

	- Delete a computer from first page
		GIVEN I have selected a computer
		AND I am in edit page
		WHEN I click on delete button
		THEN return back to search page 
		AND should show the message 'Done! Computer has been deleted'


	- Delete a computer from second page in the search page
		GIVEN I am in the second page in the search page
		AND select a computer
		WHEN I click on delete button in the edit page
		THEN return back to search page 
		AND should show the message 'Done! Computer has been deleted'
		
	
