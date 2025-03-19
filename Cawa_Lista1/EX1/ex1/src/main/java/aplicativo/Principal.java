package aplicativo;
import dominio.Pessoa;
import dominio.Professor;
import dominio.Vendedor;
import dominio.Aluno;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class Principal {
public static void main(String[] args) {
//Instancia o EntityManagerFactory com as configurações de persistencia
EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
//Intancia o EntityManager
EntityManager em = emf.createEntityManager();

Pessoa pessoa1 = new Pessoa("Rafael", 35);
Vendedor vendedor1 = new Vendedor("Cawa", 50, 01);
Cliente cliente1 = new Cliente("Gabriel", 20, 01);


em.getTransaction().begin();// iniciar transação com banco de dados

em.persist(pessoa1);
em.persist(vendedor1);
em.persist(cliente1);


//consulta em jpql
Query consultaP = em.createQuery("select pessoa1 from Pessoa pessoa1");
ArrayList<Pessoa> listaP = (ArrayList<Pessoa>) consultaP.getResultList();

//consulta em jpql
Query consultaA = em.createQuery("select vendedor1 from Vendedor vendedor");
ArrayList<Vendedor> listaA = (ArrayList<Vendedor>) consultaA.getResultList();

Query consultaC = em.createQuery("select cliente1 from Cliente cliente1");
ArrayList<Cliente> listaC = (ArrayList<Cliente>) consultaA.getResultList();

em.getTransaction().commit();//confirmar as alterações realizadas
emf.close();
em.close();
for(Pessoa objP: listaP) {
System.out.println(objP);
}
for(Vendedor objA: listaA) {
System.out.println(objA);
}
for(Cliente objC: listaA) {
    System.out.println(objC);
    }
}
}