package com.fastcampus.programming.dmaker.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eric_kim
 */
@Getter
@AllArgsConstructor
public enum StatusCode {
    EMPLOYED("고용"),
    RETIRED("퇴직")
    ;

    private final String description;
}
