package com.RNE.referentiel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.services.StatusService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/status")
@AllArgsConstructor
public class StatusController {

    private StatusService statusService;

    @PostMapping
    public ResponseEntity<StatusDTO> saveStatus(@RequestBody StatusDTO statusDTO) {
        return new ResponseEntity<StatusDTO>(statusService.saveStatus(statusDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StatusDTO>> getAllStatuses() {
        return new ResponseEntity<List<StatusDTO>>(statusService.getAllStatuses(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<StatusDTO> getStatusByCode(@PathVariable String code) {
        return new ResponseEntity<StatusDTO>(statusService.getStatusByCode(code), HttpStatus.OK);

    }

    @PutMapping("/update/{code}")
    public ResponseEntity<StatusDTO> updateStatus(@PathVariable String code, @RequestBody StatusDTO statusDTO) {
        return new ResponseEntity<StatusDTO>(statusService.updateStatus(code, statusDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<String> deleteStatusCode(@PathVariable String code) {
        statusService.deleteStatus(code);
        return new ResponseEntity<String>("Status successfully deleted!", HttpStatus.OK);
    }
}