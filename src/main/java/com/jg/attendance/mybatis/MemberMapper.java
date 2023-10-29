package com.jg.attendance.mybatis;

import com.jg.attendance.domain.member.MemberRequest;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface MemberMapper {

    /**
     * 사원 정보 저장 (사원등록)
     * @param memberRequest
     */
    void save(MemberRequest memberRequest);
}
