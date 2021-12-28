package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.dto.CreateDeveloper;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.exception.DMakerException;
import com.fastcampus.programming.dmaker.exception.DmakerErrorCode;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.Optional;


/**
 * @@author eric_kim
 */
@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    // ACID
    // Atomic
    // Consisteny
    // Isolation
    // Durability
    @Transactional
    public void createDeveloper(CreateDeveloper.Request request) {
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYear(2)
                .name("Olaf")
                .age(5)
                .build();

        developerRepository.save(developer);
    }

    /**
     * Business Validation Sample
     * @param request
     */
    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        // Business Validation
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYear = request.getExperienceYear();
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYear < 10) {
//            throw new RuntimeException("SENIOR need 10 year experiences.");
            throw new DMakerException(DmakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYear < 4 || experienceYear > 10)) {
        }
        if (developerLevel == DeveloperLevel.JUNIOR && experienceYear > 4) {
            throw new DMakerException(DmakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

//        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
//        if(developer.isPresent())
//            throw new DMakerException((DmakerErrorCode.DUPLICATED_MEMBER_ID));
        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer -> {
                    throw new DMakerException(DmakerErrorCode.DUPLICATED_MEMBER_ID);
                }));
    }
}
