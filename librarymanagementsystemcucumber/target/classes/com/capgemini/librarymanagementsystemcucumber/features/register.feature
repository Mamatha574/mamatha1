Feature: User Registration

Scenario:  User Registration with given details

Given User is on Login page
When Student enters firstName ,lastName,email,password,mobile,role,status
|krish|potlapalli|krish@gmail.com|Krish@123|8096041817|admin|registered successfully|
Then User should be logged in
Then close browser page
