package com.sooji.web.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditor {

    @CreatedDate
    @Column(name="created_date", insertable=true, nullable = false, updatable = false, columnDefinition = "datetime comment '등록일'")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name="modified_date", columnDefinition = "datetime comment '수정일'")
    private LocalDateTime modifiedDate;

}
