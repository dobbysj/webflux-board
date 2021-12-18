package com.sooji.web.service;

import com.sooji.web.domain.Board;
import com.sooji.web.domain.BoardDTO;
import com.sooji.web.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    public Page<Board> findAll(Pageable pageable){
        return boardRepository.findAllByDeleteYn(pageable, "N");
    }

    public Board selectBoard(Long boardId){
        return boardRepository.findByBoardIdAndDeleteYn(boardId, "N");
    }

    public Board saveBoard(BoardDTO boardDTO){
        return boardRepository.save(boardDTO.toEntity());
    }

    public Board updateBoard(BoardDTO boardDTO){
        //Board board = boardRepository.findById(boardDTO.getBoardId()).get();
        //BoardDTO bdto = modelMapper.map(board, BoardDTO.class);
        return boardRepository.save(boardDTO.toEntity());
    }

    public Board deleteBoard(Long boardId){
        Board board = boardRepository.findById(boardId).get();
        BoardDTO bdto = modelMapper.map(board, BoardDTO.class);
        bdto.setDeleteYn("Y");
        return boardRepository.save(bdto.toEntity());
    }
}
