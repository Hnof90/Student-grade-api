package com.alhanof.grades;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest //start the full application for testing
@AutoConfigureMockMvc //craete fake http clint to test the API
public class StudentControllerTest {
 @Autowired 
 private MockMvc mockMvc; //simulate HTTP requests to the API


 @Test
 void shouldReturnAllStudents() throws Exception {
 mockMvc.perform(get("/api/students"))
 .andExpect(status().isOk())
 .andExpect(jsonPath("$.length()").value(2));
 }


 @Test
 void shouldAddNewStudent() throws Exception {
 String json = "{\"name\":\"Khalid\",\"course\":\"SE4111\",\"grade\":91.0}";
 mockMvc.perform(post("/api/students")
 .contentType("application/json")
 .content(json))
 .andExpect(status().isOk())
 .andExpect(jsonPath("$.name").value("Khalid"));
 }
}
