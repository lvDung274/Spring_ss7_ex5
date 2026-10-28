package com.example.nested_validation.models.dto.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    String status;
    String message;
    T data;
}
