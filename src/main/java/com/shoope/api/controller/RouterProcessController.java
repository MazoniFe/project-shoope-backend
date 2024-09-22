package com.shoope.api.controller;

import com.shoope.api.dtos.InsertRouteProcessDTO;
import com.shoope.api.entity.RouteProcess;
import com.shoope.api.service.RouteProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class RouterProcessController {

    @Autowired
    private RouteProcessService service;

    @PostMapping
    public ResponseEntity<?> insertRouteProcess (@RequestBody InsertRouteProcessDTO data) {
        return service.register(data);
    }

    @GetMapping
    public Page<RouteProcess> getRouteProcesses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.selectRouteProcesses(pageable);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<?> deleteAllData() {
        return service.deleteAll();
    }
}
