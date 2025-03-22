package aplicativo;

import dominio.Pessoa;
import dominio.Vendedor;
import dominio.Cliente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Principal {
    public static void main(String[] args) {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex1-jpa");
        
        EntityManager em = emf.createEntityManager();
        
        // Criar instâncias conforme solicitado na atividade
        Pessoa pessoa = new Pessoa("José", 35);
        Vendedor vendedor = new Vendedor("Cawa", 20, 1); 
        Cliente cliente = new Cliente("Rafael", 34, 1);
        
        em.getTransaction().begin(); // iniciar transação com banco de dados
        em.persist(pessoa);
        em.persist(vendedor);
        em.persist(cliente);
        
        // Consulta para recuperar todas as pessoas
        Query consultaP = em.createQuery("select p from Pessoa p");
        ArrayList<Pessoa> listaP = (ArrayList<Pessoa>) consultaP.getResultList();
        
        em.getTransaction().commit(); // confirmar as alterações realizadas
        
        emf.close();
        em.close();
        
        // Exibindo resultados
        for (Pessoa p: listaP) {
            System.out.println(p);
        }
    }
}