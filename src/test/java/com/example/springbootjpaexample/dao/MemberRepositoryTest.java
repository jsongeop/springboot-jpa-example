package com.example.springbootjpaexample.dao;

import com.example.springbootjpaexample.domain.member.dao.MemberRepository;
import com.example.springbootjpaexample.domain.member.dao.MemberRepositorys;
import com.example.springbootjpaexample.domain.member.domain.Member;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberRepositorys memberRepositorys;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given
        Member member = new Member();
        member.setName("MemberA");

        //when
        Long saveId = memberRepositorys.save(member);
        Member findMember = memberRepositorys.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(findMember).isEqualTo(member);

    }
}
