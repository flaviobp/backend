package br.usp.ime.verao.backend.meme;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Meme {

    @Id
    @SequenceGenerator(
            name = "meme_seq_generator",
            sequenceName = "meme_seq_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meme_seq_generator"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            unique = false
    )
    private String name;

    @ElementCollection
    @CollectionTable(name = "memekeyword", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "keyword")
    private Set<String> keywords;

    @Column(
            name = "midia",
            nullable = false,
            unique = false,
            columnDefinition = "TEXT"
    )
    private String midia;

    public Meme() {
    }

    public Meme(String name, Set<String> keywords, String midia) {
        this.name = name;
        this.keywords = keywords;
        this.midia = midia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }
}
