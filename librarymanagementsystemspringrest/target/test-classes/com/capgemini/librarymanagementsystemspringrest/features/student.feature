Feature: Student Book Services

  Background: 
    Given Student is on login page
    When Student gives "m@gmail.com", "mam123"
    Then Student is logged in

  Scenario Outline: User is able to request the book
    Given Student is on request page
    When BookId and UserId are given <bId>, <uId>
    Then Book is Requested successfully

    Examples: 
      | bId  | uId    |
      |902 | 100118 |

  Scenario Outline: User is able to return the book
    Given Student is on return page
    When bookId and userId are given <bId>, <uId>
    Then Book is returned successfully

    Examples: 
      | bId  | uId    |
      | 208 | 100118 |