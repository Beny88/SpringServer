package com.tomson.microservicea.controller;

import com.tomson.microservicea.model.User;
import com.tomson.microservicea.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void setup() {
        userController = new UserController(userService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .build();
    }

    @Test
    public void getUserTest() throws Exception {
        final Long userId = 1L;

        final User user = new User();
        user.setId(userId);
        user.setFirstName("tomson");

        Mockito.when(userService.getUser(userId)).thenReturn(user);

        mockMvc.perform(get(String.format("/user/%s", userId)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("tomson"));

        Mockito.verify(userService, Mockito.times(1)).getUser(userId);
    }
}