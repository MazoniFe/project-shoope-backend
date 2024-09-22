package com.shoope.api.dtos;

public record ReadRouteProcessDTO(
        Long id,
        String station,
        String route,
        String time,
        boolean waiting
) {
}