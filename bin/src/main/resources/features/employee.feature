Feature: Testing CRUD operations
 
  Scenario Outline: client wants to check get method
  When the client calls  /employee 
  Then the client receives answer as '<id>','<firstName>','<lastName>','<email>'
  
  Examples:
  |id||firstName|lastName|email|
  |1|testUser|testLastName|abc@gmail.com|
  |2|Teju|soma|teju.soma@gmail.com|
  