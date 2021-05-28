package com.example.geriafarm.services.implementation;

import com.example.geriafarm.DTO.ATCdto;
import com.example.geriafarm.repositories.ATCRepository;
import com.example.geriafarm.services.ATCService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DefaultATCService implements ATCService {
    private final ATCRepository atcRepository;

    public DefaultATCService(ATCRepository atcRepository) {
        this.atcRepository = atcRepository;
    }

    @Override
    public ATCdto addATC(ATCdto atcDto) {
        return null;
    }

    @Override
    public ATCdto updateATC(ATCdto atcDto) {
        return null;
    }

    @Override
    public ATCdto getATC(UUID atcID) {
        return null;
    }

    @Override
    public List<ATCdto> getATCs() {
        return null;
    }
}
