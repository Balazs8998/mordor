package com.mordor.backend.horde.dto.mapper;


import com.mordor.backend.horde.domain.Horde;
import com.mordor.backend.horde.dto.request.HordeCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class HordeMapper {

    public Horde hordeCreateDtoToHorde(HordeCreateRequest request){
        Horde horde = new Horde();
        horde.setName(request.name());
        return horde;
    }
}
