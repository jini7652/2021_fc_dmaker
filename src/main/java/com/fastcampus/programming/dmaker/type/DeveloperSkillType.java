package com.fastcampus.programming.dmaker.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author eric_kim
 */
@AllArgsConstructor
@Getter
public enum DeveloperSkillType {
    FRONT_END("프론트앤드 개발자"),
    BACK_END("백엔드 개발자"),
    FULL_STACK("풀스택 개발자")
    ;

    private final String description;
}
