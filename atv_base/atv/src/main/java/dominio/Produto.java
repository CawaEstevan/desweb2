package dominio;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private Double preco;
    
    @ManyToMany(mappedBy = "produtos")
    private List<Venda> vendas;
    
    public Produto() {
        this("", 0.0);
    }
    
    public Produto(String nome, Double preco) {
        setNome(nome);
        setPreco(preco);
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Double getPreco() {
        return preco;
    }
    
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public List<Venda> getVendas() {
        return vendas;
    }
    
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + "]";
    }
}