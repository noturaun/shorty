package com.noturaun.shorty.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseBody<T> {
    private String status;
    private String message;
    private T data;
    private List<String> errors;
}
