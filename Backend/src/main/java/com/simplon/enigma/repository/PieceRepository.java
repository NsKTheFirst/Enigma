package com.simplon.enigma.repository;

import com.simplon.enigma.model.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Fadi NOUFAL
 */
@Repository
public interface PieceRepository extends JpaRepository<Piece, UUID> {

    Piece findAllByNumPage(Integer numPage);
}
