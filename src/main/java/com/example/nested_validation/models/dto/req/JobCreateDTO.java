package com.example.nested_validation.models.dto.req;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobCreateDTO {
    @NotBlank(message = "Tiêu đề tin tuyển dụng không được để trống")
    private String title;

    @NotNull(message = "Thông tin công ty không được để trống")
    @Valid
    private CompanyDTO company;
}
