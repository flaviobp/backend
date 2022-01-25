package br.usp.ime.verao.backend.meme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private final MemeRepository memeRepository;

    @Autowired
    public MemeController(MemeRepository memeRepository){
        this.memeRepository = memeRepository;
    }

    @PostMapping
    public Meme create(@RequestBody Meme meme){
        return this.memeRepository.save(meme);
    }

    @GetMapping
    public List findAll(){
        return memeRepository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return memeRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Meme meme){
        return memeRepository.findById(id)
                .map(record -> {
                    record.setName(meme.getName());
                    record.setKeywords(meme.getKeywords());
                    record.setMidia(meme.getMidia());
                    Meme updated = memeRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return memeRepository.findById(id)
                .map(record -> {
                    memeRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
