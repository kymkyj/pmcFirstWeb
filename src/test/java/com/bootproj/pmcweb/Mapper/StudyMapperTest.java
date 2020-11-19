package com.bootproj.pmcweb.Mapper;

import com.bootproj.pmcweb.Config.DatabaseConfiguration;
import com.bootproj.pmcweb.Domain.enumclass.StudyStatus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;
import com.bootproj.pmcweb.Domain.Study;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class) //Junit4의 Runwith과 같은 기능을 하는 Junit5 어노테이션
@SpringBootTest(classes = {Study.class, DatabaseConfiguration.class})
//@SpringBootTest(classes = PmcwebApplication.class) // Junit5 기준 Application Context사용할 때 사용
// TODO : mock test 코드 작성도 해보기
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Order를 붙일 때 사용
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 진짜 데이터베이스에 테스트
public class StudyMapperTest {

    @Autowired
    private StudyMapper studyMapper;

    @Test
    public void findAll(){
        Integer limit = 10;
        Integer page = 0;
        List<Study> list = studyMapper.getStudyList(limit, page);
        assertThat(list.size() > 0);
    }

    @Test
    @Order(1)
    public void insertStudy() throws ParseException {
        Study testStudy = new Study();
        String title = "study mapper test study";
        String description = "this is description";
        Date startDate = new SimpleDateFormat("yyyy-mm-dd").parse("2020-10-11");
        Date endDate = new SimpleDateFormat("yyyy-mm-dd").parse("2021-04-10");
        Long subjectId = 1L;
        Long regionId = 1L;
        testStudy.setTitle(title);
        testStudy.setDescription(description);
        testStudy.setStartDate(startDate);
        testStudy.setEndDate(endDate);
        testStudy.setSubjectId(subjectId);
        testStudy.setRegionId(regionId);
        try {
            Integer isSuccess = studyMapper.insertStudy(testStudy);
            assertThat(testStudy.getId()!=null);
            assertThat(isSuccess == 1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void getDetail(){
        Long findId = 3L;
        Study test = studyMapper.getStudyDetail(findId);
        assertThat(test.getId().equals(findId));
    }

    @Test
    public void putStatus(){
        Long studyId = 3L;
        String del = StudyStatus.DELETE.getTitle();
        String open = StudyStatus.OPEN.getTitle();
        String close = StudyStatus.CLOSE.getTitle();
        studyMapper.putStudyStatus(studyId, del);

        Study test = studyMapper.getStudyDetail(studyId);
        assertThat(test.getStatus().equals(del));

//      studyMapper.putStudyStatus(studyId, open);
//      studyMapper.putStudyStatus(studyId, close);
    }
}
