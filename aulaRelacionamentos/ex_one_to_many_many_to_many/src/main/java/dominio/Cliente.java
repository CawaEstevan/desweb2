package dominio;

public class Cliente{
    private Long Id;
    private String nome;
    private List<Venda> vendas;

    public Cliente(){
        this();
    }

    public Cliente(String nome){
        this.nome = nome;
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

    public void setVendas(List<Venda> vendas){
        this.vendas = vendas;
    }

    public List<Venda> getVendas(){
        return this.vendas;
    }

    @Override
    public String toString(){
        return "Cliente[nome=" + nome + "]";
    }

}