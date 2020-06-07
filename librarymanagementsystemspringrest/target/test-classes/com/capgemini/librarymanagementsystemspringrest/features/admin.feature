Feature: Admin Book Services

  Background: 
    Given Admin is on login page
    When Admin gives "s@gmail.com", "m123"
    Then Admin is logged in

  Scenario Outline: Admin is able to add the book
    Given Admin is adding book
    When Admin enters  <bookName>,<author>,<category>,<publisher>
    Then Book should be added

    Examples: 
      | bookName | author  | category      | publisher |
      | "science"  | "karan" | "mathematics" | "goels"   |

  Scenario Outline: Admin is able to update the book
    Given Admin is updating book
    When Admin enters updated values <bId>, <bookName>,<author>,<category>,<publisher>
    Then Book will be updated

    Examples: 2
      | bId  | bookName | author  | category      | publisher |
      | 1102 | "maths"  | "mehta" | "mathematics" | "bakshi"  |

  Scenario Outline: Admin is able to remove the book
    Given Admin is deleting book
    When BookId is given <bId>
    Then Book is deleted

    Examples: 
      | bId  |
      | 505 |

  Scenario Outline: Admin is able to issue the book
    Given Admin is in issue page
    When Bid and Uid are given <bId>, <uId>
    Then Book is issued successfully

    Examples: 
      | bId  | uId    |
      | 805  | 100001 |
