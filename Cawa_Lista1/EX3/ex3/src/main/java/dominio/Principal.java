package aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.ArrayList;

import dominio.Pessoa;
import dominio.Vendedor;
import dominio.Cliente;

public class Principal {
    public static void main(String[] args) {
        // Instancia o EntityManagerFactory com as configurações de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex3-jpa");
        
        // Instancia o EntityManager
        EntityManager em = emf.createEntityManager();

        // Cria os objetos conforme especificado
        Vendedor vendedor = new Vendedor("SeuNome", SuaIdade, 1); 
        Cliente cliente = new Cliente("Rafael", 34, 1);

        // Inicia transação com o banco de dados
        em.getTransaction().begin();
        
        // Persiste os objetos
        em.persist(vendedor);
        em.persist(cliente);
        
        // Consulta em JPQL para recuperar vendedores
        Query consultaV = em.createQuery("select v from Vendedor v");
        ArrayList<Vendedor> listaV = (ArrayList<Vendedor>) consultaV.getResultList();
        
        // Consulta em JPQL para recuperar clientes
        Query consultaC = em.createQuery("select c from Cliente c");
        ArrayList<Cliente> listaC = (ArrayList<Cliente>) consultaC.getResultList();
        
        // Confirma as alterações realizadas
        em.getTransaction().commit();
        
        // Fecha as conexões
        em.close();
        emf.close();
        
        // Imprime os resultados
        System.out.println("\n=== Vendedores ===");
        for (Vendedor v : listaV) {
            System.out.println(v);
        }
        
        System.out.println("\n=== Clientes ===");
        for (Cliente c : listaC) {
            System.out.println(c);
        }
    }
}