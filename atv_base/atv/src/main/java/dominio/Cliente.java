package dominio;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
    
    public Cliente() {
        this("");
    }
    
    public Cliente(String nome) {
        setNome(nome);
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
    
    public List<Venda> getVendas() {
        return vendas;
    }
    
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }
}