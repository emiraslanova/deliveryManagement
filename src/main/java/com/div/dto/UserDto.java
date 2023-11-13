package com.div.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
@NotBlank
private String name;

private  String surname ;

private LocalDate birthdate;

private String phoneNumber;

private  boolean active;

private String email;


}
