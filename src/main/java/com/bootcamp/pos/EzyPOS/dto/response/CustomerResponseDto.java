package com.bootcamp.pos.EzyPOS.dto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponseDto {
    private String id;
    private String name;
    private String address;
    private double salary;
}
