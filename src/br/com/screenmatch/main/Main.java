package br.com.screenmatch.main;

import br.com.screenmatch.modules.BuscaFilmes;

public class Main {
    public static void main(String[] args) {
        BuscaFilmes busca = new BuscaFilmes("ad13bfac");

        System.out.println(busca.retornaFilme("matrix"));
    }
}
