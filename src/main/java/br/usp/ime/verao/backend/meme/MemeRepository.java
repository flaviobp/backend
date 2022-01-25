package br.usp.ime.verao.backend.meme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemeRepository  extends JpaRepository<Meme, Long> {

    Optional<Meme> findByName(String name);
}
