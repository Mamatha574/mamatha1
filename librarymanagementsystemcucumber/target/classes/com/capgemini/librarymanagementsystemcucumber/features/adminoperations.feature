Feature: Librarian can add,delete,issue books and able to view books

Background:

Given Librarian is on Login page
When Librarian enters username and password
|kav@gmail.com|k123|
Then Librarian should be logged in


Scenario: Librarian should be able to add books
Given Librarian is on adding book page
When librarian enters book details
|History|Lorens|Md publications|social|Added Successfully|
Then librarian logout page
Then close browser page

Scenario: Librarian should be able to remove books
Given Librarian is on removing book page
When librarian  clicks on remove book  
Then Book deleted successfully
Then librarian logout page
Then close browser page

Scenario: Librarian should be able to issue books 
Given Librarian is on issuing book page
When librarian move hover on issuse
Then Book issued successfully
Then librarian logout page
Then close browser page

Scenario: Librarian should be to view books
Given Librarian is on view book page
When Librarian clicks on show books
Then Librarian viewed booked sucessfully
Then librarian logout page
Then close browser page

