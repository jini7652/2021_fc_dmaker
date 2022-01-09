package com.fastcampus.programming.dmaker.dto;

import com.fastcampus.programming.dmaker.exception.DmakerErrorCode;
import lombok.*;

/**
 * @author eric_kim
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DMakerErrorResponse {
    private DmakerErrorCode errorCode;
    private String errorMessage;
}
