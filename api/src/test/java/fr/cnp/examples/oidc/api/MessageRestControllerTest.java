package fr.cnp.examples.oidc.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@WebMvcTest
@RunWith(SpringRunner.class)
public class MessageRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getPublicMessage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/public"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("public"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }


    @Test
    public void getSecuredMessage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/secured"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("secured"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }


    @Test
    public void getAdminMessage() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/admin"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(3L))
                .andExpect(MockMvcResultMatchers.jsonPath("message").value("admin"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }





}