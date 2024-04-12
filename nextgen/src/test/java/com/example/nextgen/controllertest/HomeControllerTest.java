package com.example.nextgen.controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.nextgen.controller.HomeController;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Autowired
    private MockMvc mockMvc;

    @Before(value = "")
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void testViewLoginPage() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(view().name("newhome"));
    }

    @Test
    public void testViewSecure() throws Exception {
        mockMvc.perform(get("/secured"))
               .andExpect(status().isOk())
               .andExpect(content().string("hello secure"));
    }
}
