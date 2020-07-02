package com.youyoung.web.domain;

import java.sql.Timestamp;

import lombok.Getter;

//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
//@Entity
//@Table(name = "sos_user")
public class User {

	// 사용자 ID 
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(columnDefinition="INT(11) NOT NULL COMMENT 'UID'")
    private Integer userId;

    // 로그인 ID 
    //@Column(nullable = false , columnDefinition="VARCHAR(20) COMMENT '로그인 아이디'")
    private String loginId;

    // 로그인 PW 
    private String loginPw;

    // 이름 
    private String name;

    // 연락처 
    private String phoneNumber;

    // 상호명 
    private String shopName;

    // 사업자등록번호 
    private String bizNumber;

    // 우편번호 
    private String zipCode;

    // 주소 
    private String address;

    // 상세 주소 
    private String addrDetail;

    // 승인 여부 
    private String confirmYn;

    // 등록일시 
    private Timestamp createdDate;

    // 수정일시 
    private Timestamp modifiedDate;

    // 등록자 
    private Integer createdBy;

    // 수정자 
    private Integer modifiedBy;

    // 삭제여부 
    private String deletedYn;
    
	
}
