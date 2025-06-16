package com.couriersync.backendenvios.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseDTO {
    private Integer id;
    private String name;
    private String email;
    private String phone;
}