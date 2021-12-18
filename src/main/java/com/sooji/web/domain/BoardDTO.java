package com.sooji.web.domain;

import lombok.Data;

@Data
public class BoardDTO {

    private Long boardId;

    private String title;

    private String content;

    private String writer;

    private String deleteYn = "N";

    public Board toEntity(){
        return Board.builder()
                .boardId(boardId)
                .title(title)
                .content(content)
                .writer(writer)
                .deleteYn(deleteYn)
                .build();
    }
}
