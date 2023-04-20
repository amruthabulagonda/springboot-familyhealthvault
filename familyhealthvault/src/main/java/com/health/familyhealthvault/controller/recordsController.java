package com.health.familyhealthvault.controller;

import com.google.api.client.util.Data;
import com.health.familyhealthvault.entity.Record;
import com.health.familyhealthvault.service.recordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class recordsController {

    @Autowired
    public recordsService recordsService;

    @GetMapping("/getrecord")
    public Record getRecord(@RequestParam String documentId) throws ExecutionException, InterruptedException {
        return recordsService.getRecord(documentId);
    }

    @PostMapping("/newrecord")
    public String saveNewRecord(@RequestBody Record record) throws ExecutionException, InterruptedException {
        return recordsService.saveRecord(record);
    }

}
