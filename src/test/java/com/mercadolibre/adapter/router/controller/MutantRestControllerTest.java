package com.mercadolibre.adapter.router.controller;

import com.google.gson.Gson;
import com.mercadolibre.AppUnifiedXmenMagneto;
import com.mercadolibre.adapter.router.facade.MutantFacade;
import com.mercadolibre.domain.service.model.request.MutantDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static com.mercadolibre.adapter.router.RouterConsts.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppUnifiedXmenMagneto.class)
public class MutantRestControllerTest {
    private MockMvc mockMvc;
    private Gson gson;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private MutantFacade mutantFacade;

    @Before
    public void init(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        gson = new Gson();
    }

    @Test
    public void statusServiceTest() throws Exception {
        String urlService = CONTROLLER_PATH.concat(MAPPING_STATUS);
        mockMvc.perform(get(urlService).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

   /* @Test
    public void isMutantTest() throws Exception {
        String urlService = CONTROLLER_PATH.concat(MAPPING_POST_MUTANT);
        mockMvc.perform(post(urlService).contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(new MutantDTO())))
                .andExpect(status().isOk()).andReturn();
    }*/


    @Test
    public void getStatsTest() throws Exception {
        String urlService = CONTROLLER_PATH.concat(MAPPING_GET_MUTANT);
        mockMvc.perform(get(urlService).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }
}
