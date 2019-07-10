package com.simplon.enigma.repository;

import com.simplon.enigma.model.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Fadi NOUFAL
 */
@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {

    @Query("select new com.simplon.enigma.model.Score(s.person, s.value) "
            + "from Score s order by s.value desc")
    Page<Score> findAllByValue(Pageable pageable);
}
