Feature: Testing CRUD operations
 
  Scenario Outline: client wants to check get method
  When The client calls employee end point 
  Then The client receives answer as emp_id <id>, first_name <firstName>, last_name <lastName> and email <email>
  
  Examples:
  |  id   |   firstName   |    lastName    |      email              |
  |  1    |  testUser     |  testLastName  |   abc@gmail.com         |
  |  2    |    Teju       |    soma        |   teju.soma@gmail.com   |