package com.sooji.web.repository;

import com.sooji.web.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findAllByDeleteYn(Pageable pageable, String deleteYn);

    Board findByBoardIdAndDeleteYn(Long boardId, String deleteYn);
}
