package com.shoope.api.repository;

import com.shoope.api.entity.RouteProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RouteProcessRepository extends JpaRepository<RouteProcess, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO route_process (station, route, time, waiting) VALUES (:station, :route, :time, :waiting)", nativeQuery = true)
    void insertRouteProcess(@Param("station") String station,
                            @Param("route") String route,
                            @Param("time") String time,
                            @Param("waiting") boolean waiting);

    @Modifying
    @Transactional
    @Query(value = "UPDATE route_process SET station = :station, route = :route, time = :time, waiting = :waiting WHERE id = :id", nativeQuery = true)
    void updateRouteProcess(@Param("id") Long id,
                            @Param("station") String station,
                            @Param("route") String route,
                            @Param("time") String time,
                            @Param("waiting") boolean waiting);

    @Query(value = "SELECT * FROM route_process WHERE id = :id", nativeQuery = true)
    RouteProcess loadRouteProcess(@Param("id") Long id);

    @Query(value = "SELECT * FROM route_process", nativeQuery = true)
    List<RouteProcess> findAllRouteProcesses();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM RProcess WHERE id = :id", nativeQuery = true)
    void deleteRouteProcessById(@Param("id") Long id);
}
