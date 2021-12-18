package com.sooji.web.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
@Table(name = "board")
public class Board extends Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id", columnDefinition = "bigint comment '게시 ID'")
    private Long boardId;

    @Column(name="title", columnDefinition = "varchar(200) comment '제목'")
    private String title;

    @Column(name="content", columnDefinition = "longtext comment '내용'")
    private String content;

    @Column(name="writer", columnDefinition = "varchar(45) comment '작성자'")
    private String writer;

    @Column(name="delete_yn", columnDefinition = "varchar(1) default 'N' comment '삭제여부'")
    private String deleteYn;

    @Builder
    public Board(Long boardId, String title, String content, String writer, String deleteYn) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.deleteYn = deleteYn;
    }
}
