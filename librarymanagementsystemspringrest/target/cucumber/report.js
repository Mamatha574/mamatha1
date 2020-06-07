$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("admin.feature");
formatter.feature({
  "line": 1,
  "name": "Admin Book Services",
  "description": "",
  "id": "admin-book-services",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Admin is able to add the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Admin is adding book",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Admin enters  \u003cbookName\u003e,\u003cauthor\u003e,\u003ccategory\u003e,\u003cpublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book should be added",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book;",
  "rows": [
    {
      "cells": [
        "bookName",
        "author",
        "category",
        "publisher"
      ],
      "line": 14,
      "id": "admin-book-services;admin-is-able-to-add-the-book;;1"
    },
    {
      "cells": [
        "\"science\"",
        "\"karan\"",
        "\"mathematics\"",
        "\"goels\""
      ],
      "line": 15,
      "id": "admin-book-services;admin-is-able-to-add-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"s@gmail.com\", \"m123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 132661300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "s@gmail.com",
      "offset": 13
    },
    {
      "val": "m123",
      "offset": 28
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 3071952500,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 24600,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Admin is able to add the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-add-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Admin is adding book",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Admin enters  \"science\",\"karan\",\"mathematics\",\"goels\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book should be added",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_adding_book()"
});
formatter.result({
  "duration": 52900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "science",
      "offset": 15
    },
    {
      "val": "karan",
      "offset": 25
    },
    {
      "val": "mathematics",
      "offset": 33
    },
    {
      "val": "goels",
      "offset": 47
    }
  ],
  "location": "AdminSteps.admin_enters(String,String,String,String)"
});
formatter.result({
  "duration": 241902900,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_should_be_added()"
});
formatter.result({
  "duration": 65900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 17,
  "name": "Admin is able to update the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Admin is updating book",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Admin enters updated values \u003cbId\u003e, \u003cbookName\u003e,\u003cauthor\u003e,\u003ccategory\u003e,\u003cpublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book will be updated",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "2",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book;2",
  "rows": [
    {
      "cells": [
        "bId",
        "bookName",
        "author",
        "category",
        "publisher"
      ],
      "line": 23,
      "id": "admin-book-services;admin-is-able-to-update-the-book;2;1"
    },
    {
      "cells": [
        "1102",
        "\"maths\"",
        "\"mehta\"",
        "\"mathematics\"",
        "\"bakshi\""
      ],
      "line": 24,
      "id": "admin-book-services;admin-is-able-to-update-the-book;2;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"s@gmail.com\", \"m123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 40600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "s@gmail.com",
      "offset": 13
    },
    {
      "val": "m123",
      "offset": 28
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 228877600,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 123500,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Admin is able to update the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-update-the-book;2;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Admin is updating book",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Admin enters updated values 1102, \"maths\",\"mehta\",\"mathematics\",\"bakshi\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book will be updated",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_updating_book()"
});
formatter.result({
  "duration": 39900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1102",
      "offset": 28
    },
    {
      "val": "maths",
      "offset": 35
    },
    {
      "val": "mehta",
      "offset": 43
    },
    {
      "val": "mathematics",
      "offset": 51
    },
    {
      "val": "bakshi",
      "offset": 65
    }
  ],
  "location": "AdminSteps.admin_enters_updated_values(int,String,String,String,String)"
});
formatter.result({
  "duration": 1219700,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_will_be_updated()"
});
formatter.result({
  "duration": 29100,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Admin is able to remove the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-remove-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "Admin is deleting book",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "BookId is given \u003cbId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Book is deleted",
  "keyword": "Then "
});
formatter.examples({
  "line": 31,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-remove-the-book;",
  "rows": [
    {
      "cells": [
        "bId"
      ],
      "line": 32,
      "id": "admin-book-services;admin-is-able-to-remove-the-book;;1"
    },
    {
      "cells": [
        "505"
      ],
      "line": 33,
      "id": "admin-book-services;admin-is-able-to-remove-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"s@gmail.com\", \"m123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 40200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "s@gmail.com",
      "offset": 13
    },
    {
      "val": "m123",
      "offset": 28
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 234806900,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 20700,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "Admin is able to remove the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-remove-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "Admin is deleting book",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "BookId is given 505",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "Book is deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_deleting_book()"
});
formatter.result({
  "duration": 25100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "505",
      "offset": 16
    }
  ],
  "location": "AdminSteps.bookid_is_given(int)"
});
formatter.result({
  "duration": 352876000,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_is_deleted()"
});
formatter.result({
  "duration": 17900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 35,
  "name": "Admin is able to issue the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-issue-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 36,
  "name": "Admin is in issue page",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Bid and Uid are given \u003cbId\u003e, \u003cuId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Book is issued successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 40,
  "name": "",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-issue-the-book;",
  "rows": [
    {
      "cells": [
        "bId",
        "uId"
      ],
      "line": 41,
      "id": "admin-book-services;admin-is-able-to-issue-the-book;;1"
    },
    {
      "cells": [
        "805",
        "100001"
      ],
      "line": 42,
      "id": "admin-book-services;admin-is-able-to-issue-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"s@gmail.com\", \"m123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 31500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "s@gmail.com",
      "offset": 13
    },
    {
      "val": "m123",
      "offset": 28
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 133649900,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_logged_in()"
});
formatter.result({
  "duration": 19800,
  "status": "passed"
});
formatter.scenario({
  "line": 42,
  "name": "Admin is able to issue the book",
  "description": "",
  "id": "admin-book-services;admin-is-able-to-issue-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 36,
  "name": "Admin is in issue page",
  "keyword": "Given "
});
formatter.step({
  "line": 37,
  "name": "Bid and Uid are given 805, 100001",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 38,
  "name": "Book is issued successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_in_issue_page()"
});
formatter.result({
  "duration": 52400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "805",
      "offset": 22
    },
    {
      "val": "100001",
      "offset": 27
    }
  ],
  "location": "AdminSteps.bid_and_Uid_are_given(int,int)"
});
formatter.result({
  "duration": 171005800,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_is_issued_successfully()"
});
formatter.result({
  "duration": 29500,
  "status": "passed"
});
formatter.uri("student.feature");
formatter.feature({
  "line": 1,
  "name": "Student Book Services",
  "description": "",
  "id": "student-book-services",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "User is able to request the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-request-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Student is on request page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "BookId and UserId are given \u003cbId\u003e, \u003cuId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book is Requested successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "student-book-services;user-is-able-to-request-the-book;",
  "rows": [
    {
      "cells": [
        "bId",
        "uId"
      ],
      "line": 14,
      "id": "student-book-services;user-is-able-to-request-the-book;;1"
    },
    {
      "cells": [
        "902",
        "100118"
      ],
      "line": 15,
      "id": "student-book-services;user-is-able-to-request-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Student is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Student gives \"m@gmail.com\", \"mam123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Student is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_login_page()"
});
formatter.result({
  "duration": 1357000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "m@gmail.com",
      "offset": 15
    },
    {
      "val": "mam123",
      "offset": 30
    }
  ],
  "location": "StudentSteps.student_gives(String,String)"
});
formatter.result({
  "duration": 506072100,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.student_is_logged_in()"
});
formatter.result({
  "duration": 5368000,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "User is able to request the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-request-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Student is on request page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "BookId and UserId are given 902, 100118",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Book is Requested successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_request_page()"
});
formatter.result({
  "duration": 38100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "902",
      "offset": 28
    },
    {
      "val": "100118",
      "offset": 33
    }
  ],
  "location": "StudentSteps.bookid_and_UserId_are_given(int,int)"
});
formatter.result({
  "duration": 446336600,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.book_is_Requested_successfully()"
});
formatter.result({
  "duration": 3335700,
  "error_message": "org.opentest4j.AssertionFailedError: expected: \u003ctrue\u003e but was: \u003cfalse\u003e\r\n\tat org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:55)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:40)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:35)\r\n\tat org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:162)\r\n\tat com.capgemini.librarymanagementsystemspringrest.stepdefinitions.StudentSteps.book_is_Requested_successfully(StudentSteps.java:61)\r\n\tat ✽.Then Book is Requested successfully(student.feature:11)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "line": 17,
  "name": "User is able to return the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-return-the-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Student is on return page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "bookId and userId are given \u003cbId\u003e, \u003cuId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book is returned successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "student-book-services;user-is-able-to-return-the-book;",
  "rows": [
    {
      "cells": [
        "bId",
        "uId"
      ],
      "line": 23,
      "id": "student-book-services;user-is-able-to-return-the-book;;1"
    },
    {
      "cells": [
        "208",
        "100118"
      ],
      "line": 24,
      "id": "student-book-services;user-is-able-to-return-the-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Student is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Student gives \"m@gmail.com\", \"mam123\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Student is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_login_page()"
});
formatter.result({
  "duration": 64000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "m@gmail.com",
      "offset": 15
    },
    {
      "val": "mam123",
      "offset": 30
    }
  ],
  "location": "StudentSteps.student_gives(String,String)"
});
formatter.result({
  "duration": 190966600,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.student_is_logged_in()"
});
formatter.result({
  "duration": 22400,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "User is able to return the book",
  "description": "",
  "id": "student-book-services;user-is-able-to-return-the-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Student is on return page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "bookId and userId are given 208, 100118",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book is returned successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentSteps.student_is_on_return_page()"
});
formatter.result({
  "duration": 46400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "208",
      "offset": 28
    },
    {
      "val": "100118",
      "offset": 33
    }
  ],
  "location": "StudentSteps.bookid_and_userId_are_given(int,int)"
});
formatter.result({
  "duration": 111105900,
  "status": "passed"
});
formatter.match({
  "location": "StudentSteps.book_is_returned_successfully()"
});
formatter.result({
  "duration": 738200,
  "error_message": "org.opentest4j.AssertionFailedError: expected: \u003ctrue\u003e but was: \u003cfalse\u003e\r\n\tat org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:55)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:40)\r\n\tat org.junit.jupiter.api.AssertTrue.assertTrue(AssertTrue.java:35)\r\n\tat org.junit.jupiter.api.Assertions.assertTrue(Assertions.java:162)\r\n\tat com.capgemini.librarymanagementsystemspringrest.stepdefinitions.StudentSteps.book_is_returned_successfully(StudentSteps.java:76)\r\n\tat ✽.Then Book is returned successfully(student.feature:20)\r\n",
  "status": "failed"
});
});