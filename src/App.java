import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        HttpClient client = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        for(Map<String, String> filme: listaDeFilmes){
            
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream =  new URL(urlImagem).openStream();
            String nomeDoArquivo = titulo + ".png";

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeDoArquivo);
            System.out.println(titulo);
            System.out.println();
        };
    }
}