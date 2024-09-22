package com.shoope.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "route_process")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RouteProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station", nullable = false, length = 20)
    private String station;

    @Column(name = "route", nullable = false, length = 20)
    private String route;

    @Column(name = "time", nullable = false)
    private String time; // Alternativamente, pode usar LocalTime

    @Column(name = "waiting", nullable = false)
    private boolean waiting;
}
