package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("aula-jpa"); // Instancia o EntityManagerFactory
            em = emf.createEntityManager(); // Instancia o EntityManager
            
            em.getTransaction().begin();
            
            // Criando produtos
            Produto p1 = new Produto("Notebook", 3500.0);
            Produto p2 = new Produto("Smartphone", 2200.0);
            Produto p3 = new Produto("Monitor", 1200.0);
            Produto p4 = new Produto("Teclado", 150.0);
            
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            
            // Criando clientes
            Cliente c1 = new Cliente("João Silva");
            Cliente c2 = new Cliente("Maria Oliveira");
            Cliente c3 = new Cliente("Pedro Santos");
            Cliente c4 = new Cliente("Ana Souza");
            
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            
            // Criando vendas
            Venda v1 = new Venda(3650.0, c1); // Notebook + Teclado
            v1.setProdutos(Arrays.asList(p1, p4));
            
            Venda v2 = new Venda(2200.0, c2); // Smartphone
            v2.setProdutos(Arrays.asList(p2));
            
            Venda v3 = new Venda(4700.0, c3); // Notebook + Monitor
            v3.setProdutos(Arrays.asList(p1, p3));
            
            Venda v4 = new Venda(3400.0, c4); // Monitor + Smartphone
            v4.setProdutos(Arrays.asList(p3, p2));
            
            em.persist(v1);
            em.persist(v2);
            em.persist(v3);
            em.persist(v4);
            
            // Consultas em JPQL
            Query consultaVendas = em.createQuery("select v from Venda v");
            ArrayList<Venda> listaVendas = (ArrayList<Venda>) consultaVendas.getResultList();
            
            Query consultaProdutos = em.createQuery("select p from Produto p");
            ArrayList<Produto> listaProdutos = (ArrayList<Produto>) consultaProdutos.getResultList();
            
            Query consultaClientes = em.createQuery("select c from Cliente c");
            ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) consultaClientes.getResultList();
            
            em.getTransaction().commit(); // Confirmar as alterações realizadas
            
            // Imprimindo os resultados
            System.out.println("\n--- PRODUTOS ---");
            for (Produto p : listaProdutos) {
                System.out.println(p);
            }
            
            System.out.println("\n--- CLIENTES ---");
            for (Cliente c : listaClientes) {
                System.out.println(c);
            }
            
            System.out.println("\n--- VENDAS ---");
            for (Venda v : listaVendas) {
                System.out.println(v);
                System.out.println("  Produtos:");
                for (Produto p : v.getProdutos()) {
                    System.out.println("    - " + p.getNome() + " (R$ " + p.getPreco() + ")");
                }
                System.out.println();
            }
        } catch (Exception e) {
            if (em != null && em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}