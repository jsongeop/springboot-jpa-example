package com.example.springbootjpaexample.domain.member.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "MEMBER") // Member 엔티티와 매핑할 테이블명 지정 -> 클래스명과 일치 시 명시하지 않아도 됨
@Entity // Member 클래스가 엔티티임을 명시
public class Member {

    @Id // Persiscontext에서 식별할 수 있는 값 -> 반드시 유니크한 값
    @GeneratedValue(strategy = GenerationType.AUTO) // Id가 생성되는 전략 시퀀스 개념..?
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;
}
