package com.example.employee;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.employee.model.Employee;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EmployeeStepDef {
	

    private RestTemplate restTemplate = new RestTemplate();
    private String defaultUrl = "http://localhost"+":"+8082;

	List<Employee> response = new ArrayList<>();
    String url = defaultUrl + "/employees/";

@When("The client calls employee end point")
public void the_client_calls_employee() {
   response = restTemplate.getForObject(url, List.class);
    assertNotNull(response);
   }

@Then("The client receives answer as emp_id {}, first_name {}, last_name {} and email {}")
public void the_client_receives_answer_as(Long id, String firstName, String lastName, String email) {
	String url = defaultUrl + "/employees/"+ id;
Employee emp = restTemplate.getForObject(url, Employee.class);   
   assertEquals(id, emp.getId());
   assertEquals(firstName, emp.getFirstName());
   assertEquals(lastName, emp.getLastName());
   assertEquals(email, emp.getEmail());
}
}
