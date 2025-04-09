package dominio;

import java.util.List;

public class Venda {
    private long id;
    private double valorTotal;
    private List<Produto> produtos;
    private Cliente cliente;

    public Venda() {
        this(0);
    }

    public Venda(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Cliente getCliente() {
        return this.cliente;
    }
    
    @Override
    public String toString() {
        return "Venda[id="+ id + ", valor total="+ valorTotal +"]";
    }
}