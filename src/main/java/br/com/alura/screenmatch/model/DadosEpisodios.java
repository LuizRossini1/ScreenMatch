package br.com.alura.screenmatch.model;
import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosEpisodios(@JsonAlias("Title") String titulo,
                             @JsonAlias("Episode") Integer numeroEpisodio,
                             @JsonAlias("imbdRating") String avaliacao,
                             @JsonAlias("Released") String dataDeLancamento) {
}