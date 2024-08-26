package br.com.alura.screenmatch;
import br.com.alura.screenmatch.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var api = new ConsumoAPI();
		var json = api.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=82f2795b");
		System.out.println(json);
//		json = api.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
	}
}