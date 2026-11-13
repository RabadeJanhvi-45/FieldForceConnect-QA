
Feature: Add Customer functionality

  @addCustomer
  Scenario Outline: Add a customer with valid details
    Given the user is on the login page
    When the user enters valid credentials
    And the user clicks the Sign In button
    Then the user should successfully reach the dashboard

    When the user navigates to My Customers
    And the user opens the New Customer form
    And the user enters customer name "<customerName>"

    And the user clicks the Save button

    Examples:
      | customerName       |
      | QA Test Customer 1 |
      | QA Test Customer 2 |

#Feature: Add Customer functionality
#
#  @addCustomer
#  Scenario Outline: Add a customer with valid details
#    Given the user is on the login page
#    When the user enters valid credentials
#    And the user clicks the Sign In button
#    Then the user should successfully reach the dashboard
#
#    When the user navigates to My Customers
#    And the user opens the New Customer form
#    And the user enters customer name "<customerName>"
#    And the user enters reference number "<refNo>"
#    And the user enters contact person "<contactPerson>"
#    And the user enters mobile number "<mobile>"
#    And the user enters telephone number "<telephone>"
#    #And the user enters email "<email>"
#    #And the user enters designation "<designation>"
#    #And the user enters contact location "<contactLocation>"
#    #And the user opens the address picker
#    #And the user enters pincode "<pincode>"
#    #And the user enters website "<website>"
#    #And the user enters other information "<otherInfo>"
#    #Then the New Customer form should display customer name "<customerName>"
#    And the user clicks the Save button
#
#    Examples:
#      #| customerName       | refNo |  contactPerson| mobile     | telephone
#      #| QA Test Customer 1 | QA001 | Test Contact  | 9876543210 | 022123456
#      #| QA Test Customer 2 | QA002 | Test Contact  | 9876543211 | 022123457