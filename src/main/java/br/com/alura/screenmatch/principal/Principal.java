package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.model.DadosEpisodios;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverterDados;

import java.util.*;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI api = new ConsumoAPI();
    private ConverterDados converteDados = new ConverterDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=82f2795b";

    public void exibeMenu() {
        System.out.println("Digite a série que deseja buscar");
        var nomeSerie = leitura.nextLine();
        var json = api.obterDados(ENDERECO + nomeSerie
                .replace(" ", "+") + API_KEY);
        DadosSerie dados = converteDados.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i<= dados.totalTemporadas(); i++) {
			json = api.obterDados(ENDERECO + nomeSerie
                    .replace(" ", "+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);

        /*for (int i = 0; i < dados.totalTemporadas(); i++) {
            List<DadosEpisodios> episodiosTemporadas = temporadas.get(i).episodios();

            for (int j = 0; j < episodiosTemporadas.size(); j++) {
                System.out.println(episodiosTemporadas.get(j).titulo());
            }
        }*/

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));

    }
}