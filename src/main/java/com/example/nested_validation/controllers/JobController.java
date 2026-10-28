package com.example.nested_validation.controllers;

import com.example.nested_validation.models.dto.req.JobCreateDTO;
import com.example.nested_validation.models.dto.wrapper.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    @PostMapping
    public ResponseEntity<?> createJob(@Valid @RequestBody JobCreateDTO request, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();

            fieldErrors.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

            return ResponseEntity.badRequest().body(
                    ApiResponse.builder()
                            .status(HttpStatus.BAD_REQUEST.name())
                            .message("Data Failed")
                            .data(errors)
                            .build()
            );
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.builder()
                        .status(HttpStatus.CREATED.name())
                        .message("Tạo tin tuyển dụng thành công")
                        .data(request)
                        .build()
        );
    }
}
