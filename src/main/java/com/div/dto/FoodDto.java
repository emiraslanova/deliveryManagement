package com.div.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    @NotBlank
    private  String name ;

    @NotBlank
    private String desc;

    @NotBlank
    private  double amount;

    @NotBlank
    private String foodDetails;

    @NotBlank
    private String image;

}
