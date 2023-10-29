package com.jg.attendance.service;

import com.jg.attendance.domain.member.MemberRequest;
import org.springframework.transaction.annotation.Transactional;

public interface MemberService {


    void signUp(MemberRequest memberRequest);
}
