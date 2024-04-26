package com.example.project1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldDto {
    @JsonProperty("numbers")
    private int[] numbers;

}
