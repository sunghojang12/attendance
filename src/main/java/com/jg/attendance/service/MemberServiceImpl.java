package com.jg.attendance.service;

import com.jg.attendance.domain.member.MemberRequest;
import com.jg.attendance.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    /**
     * 사원 정보 저장(사원등록)
     * @param memberRequest
     */
    @Transactional
    @Override
    public void signUp(MemberRequest memberRequest) {
        memberRequest.encodingPassword(passwordEncoder);
        memberRequest.hireDate();
        memberMapper.save(memberRequest);
    }
}
