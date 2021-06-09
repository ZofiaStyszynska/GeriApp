package com.example.geriafarm.controllers;


import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.DTO.ActiveSubstDTO;
import com.example.geriafarm.services.ATCService;
import com.example.geriafarm.services.ActiveSubstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ActiveSubstControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ATCService atcService;

    @MockBean
    private ActiveSubstService activeSubstService;

    ActiveSubstDTO activeSubstDTO = new ActiveSubstDTO("furosemid", ATCdto.builder().atcDto("C03CA01").build()
           );
}
