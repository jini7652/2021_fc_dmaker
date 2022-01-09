package com.fastcampus.programming.dmaker.controller;

import com.fastcampus.programming.dmaker.dto.*;
import com.fastcampus.programming.dmaker.exception.DMakerException;
import com.fastcampus.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author eric_kim
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {

    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        log.info("GET /developers HTTP/1.1");
//        return Arrays.asList("Snow", "Olaf", "Elsa");
        return dMakerService.getAllEmployedDelovers();
    }

    @GetMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ) {
        log.info("GET /developers HTTP/1.1");
//        return Arrays.asList("Snow", "Olaf", "Elsa");
        return dMakerService.getDeveloperDetail(memberId);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request
            ) {
        log.info("request : {}", request);

        return dMakerService.createDeveloper(request);
//        return Collections.singletonList("Olaf");
    }

    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable String memberId,
            @Valid @RequestBody EditDeveloper.Request request
    ) {
        log.info("GET /developers HTTP/1.1");
//        return Arrays.asList("Snow", "Olaf", "Elsa");
        return dMakerService.editDeveloper(memberId, request);
    }

    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto deteteDeveloper(
            @PathVariable String memberId
    ) {
        return dMakerService.deleteDeveloer(memberId);
    }

//    /**
//     * Controller Global Exception Control - 2022.01.09
//     * exception > DMakerExcptionHandler로 이동
//     * @param e
//     * @param request
//     * @return
//     */
////    @ResponseStatus(value = HttpStatus.CONFLICT)
//    @ExceptionHandler(DMakerException.class)
//    public DMakerErrorResponse handleException(
//            DMakerException e,
//            HttpServletRequest request
//    ) {
//        log.error("errorCode: {}, url: {}, message: {}", e.getDMakerErrorCode(), request.getRequestURI(), e.getDetailMessage());
//        return DMakerErrorResponse.builder()
//                .errorCode(e.getDMakerErrorCode())
//                .errorMessage(e.getDetailMessage())
//                .build();
//    }

}