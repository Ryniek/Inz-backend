package pl.rynski.inzynierkabackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import pl.rynski.inzynierkabackend.dao.dto.request.UserDto;
import pl.rynski.inzynierkabackend.dao.model.User;
import pl.rynski.inzynierkabackend.dao.model.UserRole;
import pl.rynski.inzynierkabackend.repository.UserRepository;
import pl.rynski.inzynierkabackend.repository.UserRoleRepository;
import pl.rynski.inzynierkabackend.security.JwtResponse;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Transactional
    void shouldLoginAndTokenWorks() throws Exception {
        prepareDummyUserAndRole();

        UserDto userDto = new UserDto("test", "pass");

        MvcResult login = mockMvc.perform(MockMvcRequestBuilders.post("/auth/login")
                .content(objectMapper.writeValueAsString(userDto)))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        JwtResponse jwtResponse = objectMapper.readValue(login.getResponse().getContentAsString(), JwtResponse.class);

        mockMvc.perform(MockMvcRequestBuilders.get("/auth/token/test")
                .header("Authorization", "Bearer " + jwtResponse.getToken()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().string("Secured"));

        assertNotNull(jwtResponse.getToken());
    }

    @Test
    void shouldRegister() {
    }

    private User prepareDummyUserAndRole() {
        User user = new User();
        user.setEmail("test");
        user.setPassword(passwordEncoder.encode("pass"));
        user.setRegisterTime(LocalDateTime.now());
        UserRole userRole = new UserRole();
        userRole.setName("role");
        userRoleRepository.save(userRole);
        user.setUserRole(userRole);
        userRepository.save(user);
        return user;
    }
}