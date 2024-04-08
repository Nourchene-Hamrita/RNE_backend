package com.RNE.referentiel.controller;

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
import com.RNE.referentiel.serviceInterface.StatusService;

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

    @GetMapping("/{statusCode}")
    public ResponseEntity<StatusDTO> getStatusByCode(@PathVariable String statusCode) {
        return new ResponseEntity<StatusDTO>(statusService.getStatusByCode(statusCode), HttpStatus.OK);

    }

    @PutMapping("/update/{statusCode}")
    public ResponseEntity<StatusDTO> updateStatus(@PathVariable String statusCode, @RequestBody StatusDTO statusDTO) {
        return new ResponseEntity<StatusDTO>(statusService.updateStatus(statusCode, statusDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{statusCode}")
    public ResponseEntity<String> deleteStatusCode(@PathVariable String statusCode) {
        statusService.deleteStatus(statusCode);
        return new ResponseEntity<String>("Status successfully deleted!", HttpStatus.OK);
    }
}