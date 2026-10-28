package com.example.nested_validation.models.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    @NotBlank(message = "Tên công ty không được để trống")
    private String name;

    @Size(min = 10, max = 13, message = "Mã số thuế phải từ 10 đến 13 ký tự")
    private String taxCode;
}
