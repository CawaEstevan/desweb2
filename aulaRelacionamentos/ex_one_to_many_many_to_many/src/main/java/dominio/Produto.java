package dominio;

import java.util.List;

public class Produto {
    private long id;
    private String nome;
    private double preco;
    private List<Venda> vendas;

    public Produto() {
        this("", 0);
    }

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }

    @Override
    public String toString() {
        return "Produto[nome=" + nome + ", preco=" + preco + "]";
    }
}