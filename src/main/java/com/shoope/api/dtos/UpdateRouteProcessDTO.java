package com.shoope.api.dtos;

public record UpdateRouteProcessDTO(
        Long id,
        String station,
        String route,
        String time,
        boolean waiting
) {
}