@regression
Feature: Add to cart
  Background:
    Given user is on the "login-page"
    And UK address is set on "address-page"

  Scenario:Adding item to cart
    And user add 4 "Gwyn Endurance Tee Medium Green" is added to cart
    Then cart total should be "$92.00"


  Scenario:Update item on cart
    Given user add 4 "Gwyn Endurance Tee Medium Green" is added to cart
    And the quantity of Gwyn Endurance Tee is update to 3
    When Gwyn Endurance Tee Small Yellow and "Quest Lumaflex" Band is added
    Then cart total should be "$116"
