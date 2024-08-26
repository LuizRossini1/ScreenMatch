package br.com.alura.screenmatch.model;
import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosSerie(@JsonAlias("title") String titulo,
                         @JsonAlias("totalSeasons") Integer totalTemporadas,
                         @JsonAlias("imbdRating") String avaliacao) {
}