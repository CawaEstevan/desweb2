package dominio;

import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private List<Venda> vendas;

    public Cliente() {
        // Construtor vazio sem recursão
    }

    public Cliente(String nome) {
        this.nome = nome;
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

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }

    @Override
    public String toString() {
        return "Cliente[nome=" + nome + "]";
    }
}