package dominio;


import java.io.Serializable;
import java.security.CodeSigner;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //identifica que apenas UMA tabela será criada no banco de dados.
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
//public class Pessoa implements Serializable {
public class Vendedor{

	//private static final long serialVersionUID = 1L; //Id padrão do Serializable
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String nome;
	private int idade;
	private int CodVendedor;
		
	public Vendedor() {
		this("",0,0);
	}

	public Pessoa(String nome, int idade, int CodVendedor) {
		setNome(nome);
		setCpf(idade);
	}

	public long getCodVendedor() {
		return CodVendedor;
	}

	public void setCodVendedor(int CodVendedor) {
		this.CodVendedor = CodVendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setCpf(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Vendedor [nome=" + nome + ", Idade=" + idade + ", CodVendedor=" + CodVendedor + "]";
	}
}
