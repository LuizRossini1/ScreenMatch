package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.service.ConsumoAPI;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    ConsumoAPI api = new ConsumoAPI();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=82f2795b";

    public void exibeMenu() {
        System.out.println("Digite a série que deseja buscar");
        var nomeSerie = leitura.nextLine();
        var json = api.obterDados(ENDERECO + nomeSerie
                .replace(" ", "+") + API_KEY);
    }
}