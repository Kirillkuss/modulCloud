package com.itrail.react.reactprod.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private Integer code;
    private String token;
}
