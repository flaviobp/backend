package br.usp.ime.verao.backend.meme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private final MemeService memeService;

    @Autowired
    public MemeController(MemeService memeService){
        this.memeService = memeService;
    }

    @PostMapping
    public Meme create(@RequestBody Meme meme){
        return this.memeService.create(meme);
    }

    @GetMapping
    public List listAll(){
        return memeService.listAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return memeService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Meme meme){
        return memeService.update(id, meme)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return (memeService.deleteById(id)?ResponseEntity.ok().build():ResponseEntity.notFound().build());
    }
}
