package com.sooji.web.controller;

import com.sooji.web.domain.Board;
import com.sooji.web.domain.BoardDTO;
import com.sooji.web.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Api(tags = {"게시판 API"})
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/board", produces = MediaTypes.HAL_JSON_VALUE)
public class BoardController {

    private final BoardService boardService;

    //목록
    @ApiOperation(value="게시글 목록")
    @GetMapping
    public ResponseEntity boardList(HttpServletRequest request, @PageableDefault Pageable pageable) throws Exception {
        Page<Board> boards = boardService.findAll(pageable);
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    //상세
    @ApiOperation(value="게시글 상세")
    @GetMapping("/{boardIdx}")
    public ResponseEntity boardDetail(HttpServletRequest request, @PathVariable(name="boardIdx", required=true) Long boardIdx) throws Exception {
        Board board = boardService.selectBoard(boardIdx);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    //등록
    @ApiOperation(value="게시글 등록")
    @PostMapping
    public ResponseEntity boardInsert(@RequestBody BoardDTO boardDTO) throws Exception {
        Board board = boardService.saveBoard(boardDTO);

        WebMvcLinkBuilder builder = linkTo(BoardController.class);
        URI uri = builder.toUri();

        // HAL
        EntityModel<Board> entityModel = EntityModel.of(board);
        entityModel.add(linkTo(BoardController.class).withSelfRel());
        entityModel.add(linkTo(BoardController.class).slash(board.getBoardId()).withRel("detail"));

        return ResponseEntity.created(uri).body(entityModel);
    }

    //수정
    @ApiOperation(value="게시글 수정")
    @PutMapping("/{boardIdx}")
    public ResponseEntity boardUpdate(@PathVariable(name="boardIdx", required = true) Long boardIdx
            , @RequestBody BoardDTO boardDTO) throws Exception {
        boardDTO.setBoardId(boardIdx);
        Board board = boardService.updateBoard(boardDTO);

        WebMvcLinkBuilder builder = linkTo(BoardController.class);
        URI uri = builder.toUri();

        // HAL
        EntityModel<Board> entityModel = EntityModel.of(board);
        entityModel.add(linkTo(BoardController.class).withSelfRel());
        entityModel.add(linkTo(BoardController.class).slash(board.getBoardId()).withRel("detail"));

        return ResponseEntity.created(uri).body(entityModel);
    }

    //삭제
    @ApiOperation(value="게시글 삭제")
    @DeleteMapping("{boardIdx}")
    public ResponseEntity<String> boardDelete(@PathVariable(name="boardIdx", required=true) Long boardIdx) throws Exception {
        Board board = this.boardService.deleteBoard(boardIdx);
        if (board != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
