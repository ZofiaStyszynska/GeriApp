package com.example.geriafarm.services;

import com.example.geriafarm.DTO.ATCdto;

import java.util.List;
import java.util.UUID;

public interface ATCService {

    ATCdto addATC(ATCdto atcDto);
    ATCdto updateATC(ATCdto atcDto);
    ATCdto getATC(UUID atcID);
    List<ATCdto> getATCs();
}
