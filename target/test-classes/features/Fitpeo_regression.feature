Feature: Functionality testing of Fitpeo Revenue Calculator

  @Calculate_Revenue
  Scenario Outline: Revenue Calculator Functionality
    Given User navigate to Fitpeo landing page
    When User navigate to "Revenue Calculator" Page
    And Scroll Down to the slider section
    When User set the slider "<Patient_number>"
    Then Set the patient number to "<Patient_number1>"
    And User choose CPT codes"<code1>", "<code2>", "<code3>" and "<code4>"
    Then User validate Total Recurring reimbursement "<value>"

    Examples: 
      | Patient_number | Patient_number1 | code1     | code2     | code3     | code4     | value  |
      |            820 |               520 | CPT-99091 | CPT-99453 | CPT-99454 | CPT-99474 | 70200 |
