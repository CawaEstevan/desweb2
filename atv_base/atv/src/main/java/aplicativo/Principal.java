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
            emf = Persistence.createEntityManagerFactory("atv-jpa");
            em = emf.createEntityManager();
            
            em.getTransaction().begin();
            
            // Criando produtos
            Produto p1 = new Produto("Camiseta", 49.90);
            Produto p2 = new Produto("Calça", 99.90);
            Produto p3 = new Produto("Tênis", 199.90);
            Produto p4 = new Produto("Meias", 19.90);
            
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            
            // Criando clientes
            Cliente c1 = new Cliente("João");
            Cliente c2 = new Cliente("Maria");
            Cliente c3 = new Cliente("Pedro");
            Cliente c4 = new Cliente("Ana");
            
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            
            // Criando vendas
            Venda v1 = new Venda(149.80, c1);
            v1.setProdutos(Arrays.asList(p1, p2));
            
            Venda v2 = new Venda(219.80, c2);
            v2.setProdutos(Arrays.asList(p3, p4));
            
            Venda v3 = new Venda(249.80, c3);
            v3.setProdutos(Arrays.asList(p1, p3));
            
            Venda v4 = new Venda(119.80, c4);
            v4.setProdutos(Arrays.asList(p2, p4));
            
            em.persist(v1);
            em.persist(v2);
            em.persist(v3);
            em.persist(v4);
            
            // Confirma as alterações no banco de dados
            em.getTransaction().commit();
            
            // Consultas JPQL - Consultas são feitas após o commit
            Query consultaProdutos = em.createQuery("select produto from Produto produto");
            ArrayList<Produto> listaProdutos = (ArrayList<Produto>) consultaProdutos.getResultList();
            
            Query consultaClientes = em.createQuery("select cliente from Cliente cliente");
            ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) consultaClientes.getResultList();
            
            Query consultaVendas = em.createQuery("select venda from Venda venda");
            ArrayList<Venda> listaVendas = (ArrayList<Venda>) consultaVendas.getResultList();
            
            // Exibindo resultados ANTES de fechar as conexões
            System.out.println("=== PRODUTOS ===");
            for (Produto p : listaProdutos) {
                System.out.println(p);
            }
            
            System.out.println("\n=== CLIENTES ===");
            for (Cliente c : listaClientes) {
                System.out.println(c);
            }
            
            System.out.println("\n=== VENDAS ===");
            for (Venda v : listaVendas) {
                System.out.println(v);
            }
            
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // Fechando conexões apenas no finally
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}