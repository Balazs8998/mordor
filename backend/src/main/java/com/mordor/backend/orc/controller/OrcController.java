package com.mordor.backend.orc.controller;


import com.mordor.backend.orc.dto.request.OrcCreateRequest;
import com.mordor.backend.orc.dto.response.OrcCreateRequiedResponse;
import com.mordor.backend.orc.dto.response.OrcItemResponse;
import com.mordor.backend.orc.service.OrcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j

@RestController
@RequestMapping("/api/orc")
public class OrcController {

    private final OrcService orcService;

    public OrcController(OrcService orcService) {
        this.orcService = orcService;
    }

    @GetMapping
    public ResponseEntity<List<OrcItemResponse>> getAllOrcs() {
        List<OrcItemResponse> orcs = orcService.getAllOrcs();
        return ResponseEntity.ok(orcs);
    }

    @GetMapping("/required-data")
    public ResponseEntity<OrcCreateRequiedResponse> getCreateOrcRequiredData() {
        OrcCreateRequiedResponse response = orcService.getCreateOrcRequiredData();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createOrc(@RequestBody OrcCreateRequest request) {
        orcService.save(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOrc(@PathVariable Long id) {
        orcService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcItemResponse> getOrcById(@PathVariable Long id) {
        OrcItemResponse orc = orcService.getOrcById(id);
        return ResponseEntity.ok(orc);
    }

}
