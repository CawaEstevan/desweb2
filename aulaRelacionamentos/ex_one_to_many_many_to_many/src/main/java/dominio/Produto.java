package dominio;

public class Produto{
    private long Id;
    private Sring nome;
    private double preco;
    private Lista<Venda> vendas;

    public Produto(){
        this("", 0);
    }

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public void setId(log Id){
        this.Id = Id;
    }

    public long getId(){
        return this.Id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setVenda(List<Venda> vendas){
        this.vendas = vendas;
    }

    public List<Venda> getVenda(){
        return this.vendas;
    }

    @Override
    public String toString(){
        return "Produto[nome=" + nome + ", preco=" + preco + "]";
    }
}
