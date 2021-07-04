package com.example.geriafarm.controllers;


import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.entities.ATC;
import com.example.geriafarm.entities.ActiveSubst;
import com.example.geriafarm.repositories.ActiveSubstRepository;
import com.example.geriafarm.services.ATCService;
import com.example.geriafarm.services.ActiveSubstService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static java.lang.String.format;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class ActiveSubstControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActiveSubstService activeSubstService;

    @Autowired
    ActiveSubstRepository activeSubstRepository;


    @Test
    @Transactional
    void shouldAddActiveSubstance() throws Exception {
        final UUID id = new UUID(1234,567);
        final String testName = "furosemid";
        final String atcDTOTest = "C03CA01";
        final ATC testATC = new ATC(null, "C","03","C","A","01");
        final ActiveSubst activeSubstTest = new ActiveSubst(id,testName, testATC);

        when(activeSubstService.addSubstance(any(ActiveSubstDTO.class))).thenReturn(activeSubstTest.getId());

        mockMvc.perform(
                post("/activesubstances")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(format("{\"name\":\"%s\",\"atc\":\"%s\"}",  testName, atcDTOTest)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(testName)))
                .andExpect(jsonPath("$.atc.atcDto", is(atcDTOTest)));

    }
}
