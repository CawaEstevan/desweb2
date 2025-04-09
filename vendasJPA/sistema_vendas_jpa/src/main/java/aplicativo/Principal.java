package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            emf = Persistence.createEntityManagerFactory("vendas-jpa"); // Instancia o EntityManagerFactory
            em = emf.createEntityManager(); // Instancia o EntityManager
            
            em.getTransaction().begin();
            
            // Criando produtos
            Produto prod1 = new Produto("Notebook", 3500.0);
            Produto prod2 = new Produto("Smartphone", 2200.0);
            Produto prod3 = new Produto("Tablet", 1800.0);
            Produto prod4 = new Produto("Monitor", 1200.0);
            
            em.persist(prod1);
            em.persist(prod2);
            em.persist(prod3);
            em.persist(prod4);
            
            // Criando clientes
            Cliente cli1 = new Cliente("João Silva");
            Cliente cli2 = new Cliente("Maria Oliveira");
            Cliente cli3 = new Cliente("Carlos Santos");
            
            em.persist(cli1);
            em.persist(cli2);
            em.persist(cli3);
            
            // Criando vendas
            Venda venda1 = new Venda(0.0, cli1);
            venda1.adicionarProduto(prod1);
            venda1.adicionarProduto(prod2);
            
            Venda venda2 = new Venda(0.0, cli2);
            venda2.adicionarProduto(prod3);
            venda2.adicionarProduto(prod4);
            
            Venda venda3 = new Venda(0.0, cli3);
            venda3.adicionarProduto(prod1);
            venda3.adicionarProduto(prod3);
            
            em.persist(venda1);
            em.persist(venda2);
            em.persist(venda3);
            
            // Consultas JPQL
            Query consultaProdutos = em.createQuery("select p from Produto p");
            ArrayList<Produto> listaProdutos = (ArrayList<Produto>) consultaProdutos.getResultList();
            
            Query consultaClientes = em.createQuery("select c from Cliente c");
            ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) consultaClientes.getResultList();
            
            Query consultaVendas = em.createQuery("select v from Venda v");
            ArrayList<Venda> listaVendas = (ArrayList<Venda>) consultaVendas.getResultList();
            
            em.getTransaction().commit(); // Confirma as alterações realizadas
            
            // Exibindo resultados
            System.out.println("\n=== PRODUTOS ===");
            for (Produto p : listaProdutos) {
                System.out.println(p);
            }
            
            System.out.println("\n=== CLIENTES ===");
            for (Cliente c : listaClientes) {
                System.out.println(c);
            }
            
            System.out.println("\n=== VENDAS ===");
            for (Venda v : listaVendas) {
                System.out.println(v + " - Produtos: " + v.getProdutos().size());
            }
            
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
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