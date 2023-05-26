package br.com.screenmatch.modules;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class BuscaFilmes {
    public String busca;
    private final String chave;


    public BuscaFilmes(String apiKey){
        this.chave = apiKey;
    }

    public Titulo retornaFilme(String busca){

        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + chave;

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);


            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            return meuTitulo;

        } catch (NumberFormatException | IOException | InterruptedException exception) {

            System.out.println("Houve algum erro");

            System.out.println(exception + "\n");

        }catch (Exception e){
            System.out.println(e);
        }
            finally {
            System.out.println("Processo finalizado!");
        }

        return new Titulo(new TituloOmdb(null,null,null));
    }
}
