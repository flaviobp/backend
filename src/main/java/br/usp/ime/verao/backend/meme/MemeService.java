package br.usp.ime.verao.backend.meme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MemeService {

    private final MemeRepository memeRepository;

    @Autowired
    public MemeService(MemeRepository memeRepository) {
        this.memeRepository = memeRepository;
    }

    public Meme create(Meme meme){
        return this.memeRepository.save(meme);
    }

    public List<Meme> listAll(){
        return memeRepository.findAll();
    }

    public Optional<Meme> findById(long id){
        return memeRepository.findById(id);
    }

    public Optional<Meme> update(long id, Meme meme){
        return memeRepository.findById(id)
                .map(record -> {
                    record.setName(meme.getName());
                    record.setKeywords(meme.getKeywords());
                    record.setMidia(meme.getMidia());
                    Meme updated = memeRepository.save(record);
                    return Optional.of(updated);
                }).orElse(Optional.empty());
    }

    public boolean deleteById(long id){
        return memeRepository.findById(id)
                .map(record -> {
                    memeRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
