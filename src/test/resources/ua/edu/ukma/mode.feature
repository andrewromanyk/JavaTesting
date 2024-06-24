Feature: Mode finder

  Scenario Outline: mode of array
    Given I get array <a>
    Then the mode is <b>

    Examples: array
      | a                               | b |
      |[1, 2, 2, 3, 4, 5, 6]            | 2 |
      |[13]                             | 13|
      |[-1, -1, 2, 0, 10, 11]           |-1 |
      |[10, 10, 10, 111, 11, 11, 11, 11]| 11|
      |[-10, -10, 11, 10, -11, 10, -10] |-10|