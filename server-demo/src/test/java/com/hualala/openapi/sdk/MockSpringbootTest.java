package com.hualala.openapi.sdk;

import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class MockSpringbootTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(new URI("/order")))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testHello1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/order/query"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testHello2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/order").param("orderKey", "22233").param("groupID", "1155"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testHello3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/order").param("orderKey", "34546"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testHello4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/order")
            .contentType(MediaType.APPLICATION_ATOM_XML)
            .content("par"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testHello5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/order")
            .contentType(MediaType.APPLICATION_ATOM_XML)
            .content("{\"sid\":1,\"name\":\"admin\",\"birthday\":\"1983-10-22\",\"salary\":\"1000\",\"bonus\":100}"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
    }

}