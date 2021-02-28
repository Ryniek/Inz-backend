package pl.rynski.inzynierkabackend.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import pl.rynski.inzynierkabackend.dao.dto.response.DepartmentResponse;
import pl.rynski.inzynierkabackend.dao.model.Department;
import pl.rynski.inzynierkabackend.repository.DepartmentRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "test")
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    @Transactional
    void shouldReturnAllDepartments() throws Exception {
        //given
        Department d1 = new Department("Test1");
        Department d2 = new Department("Test2");
        departmentRepository.saveAll(List.of(d1, d2));
        //when
        MvcResult mvcResult = mockMvc.perform(get("/department"))
                .andDo(print())
                .andExpect(status().is(200))
                //.andExpect(jsonPath("$[0].id", is(1)));
                .andReturn();
        //then
        List<DepartmentResponse> response = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<DepartmentResponse>>() {});
        assertEquals(response.get(0).getId(), d1.getId());
        assertEquals(response.get(1).getName(), d2.getName());
        assertEquals(response.size(), 2);
    }
}