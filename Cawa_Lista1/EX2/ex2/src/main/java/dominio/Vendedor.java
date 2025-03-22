package dominio;

import javax.persistence.Entity;

@Entity
public class Vendedor extends Pessoa {
    private int codVendedor;
    
    public Vendedor() {
        this("", 0, 0);
    }
    
    public Vendedor(String nome, int idade, int codVendedor) {
        super(nome, idade);
        setCodVendedor(codVendedor);
    }
    
    public int getCodVendedor() {
        return this.codVendedor;
    }
    
    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
    }
    
    @Override
    public String toString() {
        return "Vendedor [idPessoa= " + super.getIdPessoa() + ", nome= " + super.getNome() + 
               ", idade= " + super.getIdade() + ", codVendedor= " + getCodVendedor() + "]";
    }
}