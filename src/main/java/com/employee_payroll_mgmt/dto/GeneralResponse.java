package com.employee_payroll_mgmt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GeneralResponse {
    private boolean success;

    private String message;

    private Object data;
}
