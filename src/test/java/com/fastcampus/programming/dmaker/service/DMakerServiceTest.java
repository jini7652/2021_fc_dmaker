package com.fastcampus.programming.dmaker.service;

import com.fastcampus.programming.dmaker.code.StatusCode;
import com.fastcampus.programming.dmaker.dto.DeveloperDetailDto;
import com.fastcampus.programming.dmaker.entity.Developer;
import com.fastcampus.programming.dmaker.repository.DeveloperRepository;
import com.fastcampus.programming.dmaker.repository.RetiredDeveloperRepository;
import com.fastcampus.programming.dmaker.type.DeveloperLevel;
import com.fastcampus.programming.dmaker.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

/**
 * @author eric_kim
 */
@ExtendWith(MockitoExtension.class)
class DMakerServiceTest {

//    @Autowired
//    private DMakerService dMakerService;
    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloperRepository retiredDeveloperRepository;

    @InjectMocks
    private DMakerService dMakerService;

    /**
     * Dummy 성 데이터를 올리는 방법 => mocking, mockito를 활용하면 됨. 그럼 그 방법은?
     */
    @Test
    public void testSomethoing(){
//        dMakerService.createDeveloper(CreateDeveloper.Request.builder()
//                        .developerLevel(DeveloperLevel.SENIOR)
//                        .developerSkillType(DeveloperSkillType.FRONT_END)
//                        .experienceYear(12)
//                        .memberId("memberId")
//                        .name("name")
//                        .age(32)
//                .build());
//        List<DeveloperDto> allEmployedDelovers = dMakerService.getAllEmployedDelovers();
//        System.out.println("========================");
//        System.out.println(allEmployedDelovers);
//        System.out.println("========================");
        // Mock들의 행동을 정리 => Mocking
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(Developer.builder()
                                .developerLevel(DeveloperLevel.SENIOR)
                                .developerSkillType(DeveloperSkillType.FRONT_END)
                                .experienceYear(12)
                                .statusCode(StatusCode.EMPLOYED)
                                .name("name")
                                .age(12)
                        .build()));
        DeveloperDetailDto developerDetail = dMakerService.getDeveloperDetail("memberId");

        assertEquals(DeveloperLevel.SENIOR, developerDetail.getDeveloperLevel());
        assertEquals(DeveloperSkillType.FRONT_END, developerDetail.getDeveloperSkillType());
        assertEquals(12, developerDetail.getExperienceYear());
    }
}