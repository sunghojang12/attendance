package com.jg.attendance.domain.member;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 사원 등록,수정에 사용될 요청 클래스
 */
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 생성
@Data
public class MemberRequest {

    private int employee_num; // 사원번호
    private String id; // 아이디
    private String pass; // 비밀번호 - PasswordEncoder 추후사용(SpringSecurity)
    private String name; // 이름
    private String address_p; // 기본주소
    private String address_d; // 상세주소
    private String tell; // 전화번호
    private String department; // 부서
    private String position; // 직급
    private LocalDate hire_date; // 입사일

    /**
     * 비밀번호 암호화
     * @param passwordEncoder
     */
    public void encodingPassword(PasswordEncoder passwordEncoder){
        if(StringUtils.isEmpty(pass)){
            return;
        }
        pass = passwordEncoder.encode(pass);
    }

    public void hireDate(){
        hire_date = LocalDate.now();
    }





}
