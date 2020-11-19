package com.bootproj.pmcweb.Controller;

import com.bootproj.pmcweb.Domain.StudyMember;
import com.bootproj.pmcweb.Network.Header;
import com.bootproj.pmcweb.Service.StudyMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RequestMapping("/studyMember")
@RestController
@RequiredArgsConstructor
public class StudyMemberController {

    private final StudyMemberService studyMemberService;

    /**
     * Study Member REST API
     * made by songi
     */

    // 스터디 참여
    @PostMapping
    public ResponseEntity<Header> joinStudy(@ModelAttribute StudyMember studyMember){
        Long id = studyMemberService.joinStudy(studyMember);
        HashMap<String, Long> resultMap = new HashMap<>();
        resultMap.put("memberId", id);
        log.info("result > ", resultMap);
        return new ResponseEntity(Header.OK(resultMap), HttpStatus.CREATED);
    }

    // 스터디 참여요청 수락 거절
    @PutMapping("/status/{studyId}")
    public ResponseEntity<Header> changeMemberStatus(@PathVariable(value = "studyId")Long studyId, @RequestParam(value = "memberId")Long memberId){

        return new ResponseEntity(Header.OK(), HttpStatus.OK);
    }
}
