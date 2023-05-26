package br.com.screenmatch.modules;

public class Titulo {
    public String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        if(meuTituloOmdb.year().length() > 4){
            System.out.println("a");
            //throw  new ErroConversaoDeANoException("Não consegui converter o ano porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    @Override
    public String toString() {
        return "(Titulo = " + nome +
                " Ano de lançamento = " + anoDeLancamento +
                " DuracaoEmMinutos = " + duracaoEmMinutos + " min)"
                ;
    }

}
