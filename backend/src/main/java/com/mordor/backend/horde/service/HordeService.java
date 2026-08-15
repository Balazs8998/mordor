package com.mordor.backend.horde.service;


import com.mordor.backend.horde.dto.request.HordeCreateRequest;
import com.mordor.backend.horde.dto.mapper.HordeMapper;
import com.mordor.backend.horde.repository.HordeRepositry;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HordeService {

    private final HordeRepositry hordeRepositry;
    private final HordeMapper hordeMapper = new HordeMapper();

    public HordeService(HordeRepositry hordeRepositry) {
        this.hordeRepositry = hordeRepositry;
    }

    public void createHorde(HordeCreateRequest request) {

        hordeRepositry.save(hordeMapper.hordeCreateDtoToHorde(request));
    }
}
