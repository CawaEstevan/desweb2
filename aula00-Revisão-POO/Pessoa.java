public class Pessoa{
    private String nome;
    private int idade;
    private long cpf;


    public Pessoa(){
        this("",0,0);
    }
    public Pessoa(String nome, int idade){
        this(nome,idade,0);
    }

    public Pessoa(String nome, int idade, long cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void setNome(String nome){
        nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setIdade(int idade){
        idade = idade;
    }

    public int getIdade(){
        return idade;
    }

    public void setCpf(long cpf){
        cpf = cpf;
    }

    public long getCpf(){
        return cpf;
    }
    
    @Override
    public String toString(){
        return "Pessoa(Nome="+ getNome() +", Idade=" + getIdade() +",CPF=" + getCpf()+ ")";
    }
}





