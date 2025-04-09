package dominio;

import java.util.List;

import java.persistence.Entity;
import java.persistence.Id;

public class Venda{

    @Id
    private long Id;
    private double valorTotal;
    private List<Produto> produtos;
    //private Cliente;

    public Venda(){
        this(0);
    }

    public Venda(double valorTotal){
        this.valorTotal = valorTotal;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public long getId(){
        return this.Id;
    }

    public void setValorTotal(double valorTotal){
        this.valorTotal = valorTotal;
    }

    public double getValorTotal(){
        return this.valorTotal;
    }

    public void setProdutos(List<Produto> produtos){
        this.produtos = produtos;
    }

    public List<Produto> getProdutos(){
        return this.produtos;
    }
    
    @Override
    public String toString(){
        return "Venda[id="+ Id + ", valor total="+ valorTotal +"]";
    }

}