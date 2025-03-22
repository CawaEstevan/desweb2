package aplicativo;

import dominio.Vendedor;
import dominio.Cliente;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Principal {
    public static void main(String[] args) {
        // Instancia o EntityManagerFactory com as configurações de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex2-jpa");
        // Instancia o EntityManager
        EntityManager em = emf.createEntityManager();
        
        // Criar instâncias conforme solicitado na atividade
        Vendedor vendedor = new Vendedor("SeuNome", SuaIdade, 1); // Substitua por seus dados
        Cliente cliente = new Cliente("Rafael", 34, 1);
        
        em.getTransaction().begin(); // iniciar transação com banco de dados
        em.persist(vendedor);
        em.persist(cliente);
        
        // Consultas
        Query consultaV = em.createQuery("select v from Vendedor v");
        ArrayList<Vendedor> listaV = (ArrayList<Vendedor>) consultaV.getResultList();
        
        Query consultaC = em.createQuery("select c from Cliente c");
        ArrayList<Cliente> listaC = (ArrayList<Cliente>) consultaC.getResultList();
        
        em.getTransaction().commit(); // confirmar as alterações realizadas
        
        emf.close();
        em.close();
        
        // Exibindo resultados
        for (Vendedor v: listaV) {
            System.out.println(v);
        }
        
        for (Cliente c: listaC) {
            System.out.println(c);
        }
    }
}