$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("adminoperations.feature");
formatter.feature({
  "line": 1,
  "name": "Librarian can add,delete,issue books and able to view books",
  "description": "",
  "id": "librarian-can-add,delete,issue-books-and-able-to-view-books",
  "keyword": "Feature"
});
formatter.before({
  "duration": 47177772400,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Librarian is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Librarian enters username and password",
  "rows": [
    {
      "cells": [
        "s@gmail.com",
        "m123"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Librarian should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_Login_page()"
});
formatter.result({
  "duration": 7851698800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 3535671500,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_should_be_logged_in()"
});
formatter.result({
  "duration": 272682100,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Librarian should be able to add books",
  "description": "",
  "id": "librarian-can-add,delete,issue-books-and-able-to-view-books;librarian-should-be-able-to-add-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Librarian is on adding book page",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "librarian enters book details",
  "rows": [
    {
      "cells": [
        "History",
        "Lorens",
        "Md publications",
        "social",
        "Added Successfully"
      ],
      "line": 14
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "librarian logout page",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "close browser page",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_adding_book_page()"
});
formatter.result({
  "duration": 1699871400,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_enters_book_details(DataTable)"
});
formatter.result({
  "duration": 3791423300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_logout_page()"
});
formatter.result({
  "duration": 2399807300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.close_browser_page()"
});
formatter.result({
  "duration": 4107784900,
  "status": "passed"
});
formatter.before({
  "duration": 12019116900,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Librarian is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Librarian enters username and password",
  "rows": [
    {
      "cells": [
        "s@gmail.com",
        "m123"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Librarian should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_Login_page()"
});
formatter.result({
  "duration": 5644612800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 2882585800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_should_be_logged_in()"
});
formatter.result({
  "duration": 43424400,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "Librarian should be able to remove books",
  "description": "",
  "id": "librarian-can-add,delete,issue-books-and-able-to-view-books;librarian-should-be-able-to-remove-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "Librarian is on removing book page",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "librarian  clicks on remove book",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Book deleted successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "librarian logout page",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "close browser page",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_removing_book_page()"
});
formatter.result({
  "duration": 1551447800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_clicks_on_remove_book()"
});
formatter.result({
  "duration": 49300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.book_deleted_successfully()"
});
formatter.result({
  "duration": 344846800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_logout_page()"
});
formatter.result({
  "duration": 2340925800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.close_browser_page()"
});
formatter.result({
  "duration": 3900318300,
  "status": "passed"
});
formatter.before({
  "duration": 11529909000,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Librarian is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Librarian enters username and password",
  "rows": [
    {
      "cells": [
        "s@gmail.com",
        "m123"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Librarian should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_Login_page()"
});
formatter.result({
  "duration": 5833693100,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 2840471000,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_should_be_logged_in()"
});
formatter.result({
  "duration": 70255900,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Librarian should be able to issue books",
  "description": "",
  "id": "librarian-can-add,delete,issue-books-and-able-to-view-books;librarian-should-be-able-to-issue-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "Librarian is on issuing book page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "librarian move hover on issuse",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Book issued successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "librarian logout page",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "close browser page",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_issuing_book_page()"
});
formatter.result({
  "duration": 1301022400,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_move_hover_on_issuse()"
});
formatter.result({
  "duration": 474895500,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.book_issued_successfully()"
});
formatter.result({
  "duration": 825736000,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_logout_page()"
});
formatter.result({
  "duration": 2348347400,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.close_browser_page()"
});
formatter.result({
  "duration": 7171813200,
  "status": "passed"
});
formatter.before({
  "duration": 14031091400,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Librarian is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Librarian enters username and password",
  "rows": [
    {
      "cells": [
        "s@gmail.com",
        "m123"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Librarian should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_Login_page()"
});
formatter.result({
  "duration": 5859495600,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 2545330500,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_should_be_logged_in()"
});
formatter.result({
  "duration": 67693400,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Librarian should be to view books",
  "description": "",
  "id": "librarian-can-add,delete,issue-books-and-able-to-view-books;librarian-should-be-to-view-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 33,
  "name": "Librarian is on view book page",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "Librarian clicks on show books",
  "keyword": "When "
});
formatter.step({
  "line": 35,
  "name": "Librarian viewed booked sucessfully",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "librarian logout page",
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "close browser page",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.librarian_is_on_view_book_page()"
});
formatter.result({
  "duration": 1505059300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_clicks_on_show_books()"
});
formatter.result({
  "duration": 40300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_viewed_booked_sucessfully()"
});
formatter.result({
  "duration": 372609200,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.librarian_logout_page()"
});
formatter.result({
  "duration": 2284376200,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.close_browser_page()"
});
formatter.result({
  "duration": 9734811100,
  "status": "passed"
});
formatter.uri("register.feature");
formatter.feature({
  "line": 1,
  "name": "User Registration",
  "description": "",
  "id": "user-registration",
  "keyword": "Feature"
});
formatter.before({
  "duration": 17429055400,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "User Registration with given details",
  "description": "",
  "id": "user-registration;user-registration-with-given-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Student enters firstName ,lastName,email,password,mobile,role,status",
  "rows": [
    {
      "cells": [
        "krish",
        "potlapalli",
        "krish@gmail.com",
        "Krish@123",
        "8096041817",
        "admin",
        "registered successfully"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.user_is_on_Login_page()"
});
formatter.result({
  "duration": 574728300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_enters_firstName_lastName_email_password_mobile_role_status(DataTable)"
});
formatter.result({
  "duration": 5989566800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.user_should_be_logged_in()"
});
formatter.result({
  "duration": 565423800,
  "status": "passed"
});
formatter.uri("studentoperations.feature");
formatter.feature({
  "line": 1,
  "name": "Student can request,return and able to view books",
  "description": "",
  "id": "student-can-request,return-and-able-to-view-books",
  "keyword": "Feature"
});
formatter.before({
  "duration": 12722291300,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Student is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Student enters username and password",
  "rows": [
    {
      "cells": [
        "m@gmail.com",
        "mam123"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Student should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.student_is_on_Login_page()"
});
formatter.result({
  "duration": 5511200400,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 2236104500,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_should_be_logged_in()"
});
formatter.result({
  "duration": 163719100,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Student should be able to request books",
  "description": "",
  "id": "student-can-request,return-and-able-to-view-books;student-should-be-able-to-request-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "Student is on request book page",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "Student clicks on request button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Book Requested Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "student logout page",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "close browser page",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.student_is_on_request_book_page()"
});
formatter.result({
  "duration": 900725600,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_clicks_on_request_button()"
});
formatter.result({
  "duration": 425938500,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.book_Requested_Successfully()"
});
formatter.result({
  "duration": 278603200,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_logout_page()"
});
formatter.result({
  "duration": 8465283900,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.close_browser_page()"
});
formatter.result({
  "duration": 2363688600,
  "error_message": "org.openqa.selenium.NoSuchSessionException: invalid session id\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027DESKTOP-7HF4U48\u0027, ip: \u0027192.168.0.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_152\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.97, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\Mamatha\\AppData\\Lo...}, goog:chromeOptions: {debuggerAddress: localhost:50596}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 9dfdd066155fb2ed621839950f552e37\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:602)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:435)\r\n\tat com.capgemini.librarymanagementsystemcucumber.stepdefinitions.LibrarySteps.close_browser_page(LibrarySteps.java:231)\r\n\tat ✽.Then close browser page(studentoperations.feature:15)\r\n",
  "status": "failed"
});
formatter.before({
  "duration": 12969569800,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Student is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Student enters username and password",
  "rows": [
    {
      "cells": [
        "m@gmail.com",
        "mam123"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Student should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.student_is_on_Login_page()"
});
formatter.result({
  "duration": 5440478200,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 9385846300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_should_be_logged_in()"
});
formatter.result({
  "duration": 323011000,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Student should be able to return books",
  "description": "",
  "id": "student-can-request,return-and-able-to-view-books;student-should-be-able-to-return-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "Student is on returning book page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Student clicks on return button",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book Returned Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "student logout page",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "close browser page",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.student_is_on_returning_book_page()"
});
formatter.result({
  "duration": 1236622600,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_clicks_on_return_button()"
});
formatter.result({
  "duration": 53800,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.book_Returned_Successfully()"
});
formatter.result({
  "duration": 601916100,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_logout_page()"
});
formatter.result({
  "duration": 8709333600,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.close_browser_page()"
});
formatter.result({
  "duration": 2025728500,
  "error_message": "org.openqa.selenium.NoSuchSessionException: invalid session id\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027DESKTOP-7HF4U48\u0027, ip: \u0027192.168.0.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_152\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.97, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\Mamatha\\AppData\\Lo...}, goog:chromeOptions: {debuggerAddress: localhost:50649}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 9e361cfc47106d38cf8e1ba33835959c\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:602)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:435)\r\n\tat com.capgemini.librarymanagementsystemcucumber.stepdefinitions.LibrarySteps.close_browser_page(LibrarySteps.java:231)\r\n\tat ✽.Then close browser page(studentoperations.feature:22)\r\n",
  "status": "failed"
});
formatter.before({
  "duration": 14608342500,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Student is on Login page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Student enters username and password",
  "rows": [
    {
      "cells": [
        "m@gmail.com",
        "mam123"
      ],
      "line": 7
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Student should be logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.student_is_on_Login_page()"
});
formatter.result({
  "duration": 5405409100,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_enters_username_and_password(DataTable)"
});
formatter.result({
  "duration": 3040888400,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_should_be_logged_in()"
});
formatter.result({
  "duration": 97578700,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Student should be to view books",
  "description": "",
  "id": "student-can-request,return-and-able-to-view-books;student-should-be-to-view-books",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "Student is on view book page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Student clicks on show books",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "Student viewed booked sucessfully",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "student logout page",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "close browser page",
  "keyword": "Then "
});
formatter.match({
  "location": "LibrarySteps.student_is_on_view_book_page()"
});
formatter.result({
  "duration": 1081560300,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_clicks_on_show_books()"
});
formatter.result({
  "duration": 66200,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_viewed_booked_sucessfully()"
});
formatter.result({
  "duration": 528790900,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.student_logout_page()"
});
formatter.result({
  "duration": 5885999400,
  "status": "passed"
});
formatter.match({
  "location": "LibrarySteps.close_browser_page()"
});
formatter.result({
  "duration": 2023463600,
  "error_message": "org.openqa.selenium.NoSuchSessionException: invalid session id\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027DESKTOP-7HF4U48\u0027, ip: \u0027192.168.0.5\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_152\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.97, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\Mamatha\\AppData\\Lo...}, goog:chromeOptions: {debuggerAddress: localhost:50705}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 2dc79fb2e64b7c02ba5f1e4ec808912e\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:602)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:435)\r\n\tat com.capgemini.librarymanagementsystemcucumber.stepdefinitions.LibrarySteps.close_browser_page(LibrarySteps.java:231)\r\n\tat ✽.Then close browser page(studentoperations.feature:30)\r\n",
  "status": "failed"
});
});