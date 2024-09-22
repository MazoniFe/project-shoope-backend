package com.shoope.api.service;

import com.shoope.api.dtos.InsertRouteProcessDTO;
import com.shoope.api.entity.RouteProcess;
import com.shoope.api.repository.RouteProcessRepository;
import com.shoope.api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class RouteProcessService {
    @Autowired
    private RouteProcessRepository repository;

    public ResponseEntity<?> register (InsertRouteProcessDTO data) {
        try {
            RouteProcess routeProcess = repository.save(new RouteProcess(null,data.route(), data.station(), data.time(), data.waiting()));
            return ResponseEntity.ok(routeProcess);
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Page<RouteProcess> selectRouteProcesses(Pageable pageable) {
        Pageable sortedByDateDesc = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("time").descending());
        return repository.findAll(sortedByDateDesc);
    }

    public ResponseEntity<?> deleteAll() {
        try {
            repository.deleteAll();
            return ResponseEntity.ok(new Response(200L, "Data cleaning was processed successfully"));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + exception.getMessage());
        }
    }

}
