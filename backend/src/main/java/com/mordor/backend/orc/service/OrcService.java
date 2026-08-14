package com.mordor.backend.orc.service;


import com.mordor.backend.core.exception.ResourceNotFoundException;
import com.mordor.backend.orc.domain.Orc;
import com.mordor.backend.orc.domain.enums.RaceType;
import com.mordor.backend.orc.domain.enums.WeaponType;
import com.mordor.backend.orc.dto.request.OrcCreateRequest;
import com.mordor.backend.orc.dto.response.OrcCreateRequiedResponse;
import com.mordor.backend.orc.dto.response.OrcItemResponse;
import com.mordor.backend.orc.dto.response.RaceTypeItemResponse;
import com.mordor.backend.orc.dto.response.WeaponTypeItemResponse;
import com.mordor.backend.orc.mapper.OrcMapper;
import com.mordor.backend.orc.repository.OrcRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j

@Service
@Transactional
public class OrcService {

    private final OrcRepository orcRepository;
    private final OrcMapper orcMapper = new OrcMapper();

    public OrcService(OrcRepository orcRepository) {
        this.orcRepository = orcRepository;
    }


    public List<OrcItemResponse> getAllOrcs() {
        return orcRepository.findAll().stream()
                .map(orcMapper::orcToItemResponse)
                .toList();
    }

    public void save(OrcCreateRequest request) {

        Orc orc;
        if (request.id() != null) {
            orc =orcRepository.findById(request.id()).orElseThrow(() ->
                    new ResourceNotFoundException("Orc not found with id: " + request.id()));
            orc = orcMapper.updateOrcDtoToEntity(orc,request);
        } else {
            orc = orcMapper.newOrcDtoToEntity(request);
        }
        orcRepository.save(orc);
    }

    public void delete(Long id) {
        Orc orc = orcRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Orc not found with id: " + id));
        orcRepository.deleteById(id);
    }

    public OrcCreateRequiedResponse getCreateOrcRequiredData() {
        List<RaceTypeItemResponse> raceTypes = getRaceTypes();
        List<WeaponTypeItemResponse> weaponTypes = getWeaponTypes();
        return new OrcCreateRequiedResponse(raceTypes, weaponTypes);
    }

    private List<WeaponTypeItemResponse> getWeaponTypes() {
        List<WeaponType> weaponTypes = List.of(WeaponType.values());

        return weaponTypes.stream().map(weaponType ->
                new WeaponTypeItemResponse(weaponType.getDisplayName())).toList();
    }

    private List<RaceTypeItemResponse> getRaceTypes() {
        List<RaceType> raceTypes = List.of(RaceType.values());

        return raceTypes.stream()
                .map(raceType ->
                        new RaceTypeItemResponse(raceType.getDisplayName()))
                .toList();
    }

    public OrcItemResponse getOrcById(Long id) {
        Orc orc = orcRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Orc not found with id: " + id));
        return orcMapper.orcToItemResponse(orc);
    }
}
