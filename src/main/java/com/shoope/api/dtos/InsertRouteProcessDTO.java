package com.shoope.api.dtos;

public record InsertRouteProcessDTO(
        String station,
        String route,
        String time,
        boolean waiting
) {
}