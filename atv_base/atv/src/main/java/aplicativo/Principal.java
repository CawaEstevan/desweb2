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
            emf = Persistence.createEntityManagerFactory("aula-jpa");
            em = emf.createEntityManager();
            
            // Criando produtos
            Produto produto1 = new Produto("Notebook", 3500.0);
            Produto produto2 = new Produto("Smartphone", 2000.0);
            Produto produto3 = new Produto("Monitor", 800.0);
            
            // Criando clientes
            Cliente cliente1 = new Cliente("Rafael");
            Cliente cliente2 = new Cliente("Guilherme");
            
            // Criando vendas
            Venda venda1 = new Venda(5500.0); // Notebook + Smartphone
            Venda venda2 = new Venda(800.0);  // Monitor
            Venda venda3 = new Venda(2000.0); // Smartphone
            
            // Associando produtos às vendas
            venda1.setProdutos(Arrays.asList(produto1, produto2));
            venda2.setProdutos(Arrays.asList(produto3));
            venda3.setProdutos(Arrays.asList(produto2));
            
            // Associando vendas aos clientes
            venda1.setCliente(cliente1);
            venda2.setCliente(cliente1);
            venda3.setCliente(cliente2);
            
            em.getTransaction().begin();
            
            // Persistindo os objetos
            em.persist(produto1);
            em.persist(produto2);
            em.persist(produto3);
            
            em.persist(cliente1);
            em.persist(cliente2);
            
            em.persist(venda1);
            em.persist(venda2);
            em.persist(venda3);
            
            // Consultando os dados
            Query consultaProdutos = em.createQuery("select p from Produto p");
            ArrayList<Produto> listaProdutos = (ArrayList<Produto>)consultaProdutos.getResultList();
            
            Query consultaVendas = em.createQuery("select v from Venda v");
            ArrayList<Venda> listaVendas = (ArrayList<Venda>)consultaVendas.getResultList();
            
            Query consultaClientes = em.createQuery("select c from Cliente c");
            ArrayList<Cliente> listaClientes = (ArrayList<Cliente>)consultaClientes.getResultList();
            
            em.getTransaction().commit();
            
            // Exibindo os resultados
            System.out.println("=== PRODUTOS ===");
            for(Produto produto: listaProdutos) {
                System.out.println(produto);
            }
        
            System.out.println("\n=== VENDAS ===");
            for(Venda venda: listaVendas) {
                System.out.println(venda);
            }
            
            System.out.println("\n=== CLIENTES ===");
            for(Cliente cliente: listaClientes) {
                System.out.println(cliente);
            }
        } catch (Exception e) {
            if(em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if(em != null) {
                em.close();
            }
            if(emf != null) {
                emf.close();
            }
        }
    }
}