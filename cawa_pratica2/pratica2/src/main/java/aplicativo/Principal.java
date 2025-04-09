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
            // Instancia o EntityManagerFactory com as configurações de persistencia
            emf = Persistence.createEntityManagerFactory("aula-jpa"); 
            // Instancia o EntityManager
            em = emf.createEntityManager(); 
            
            em.getTransaction().begin();
    
            // Criação dos produtos
            Produto produto1 = new Produto("Notebook", 3500.00);
            Produto produto2 = new Produto("Smartphone", 2000.00);
            Produto produto3 = new Produto("Tablet", 1200.00);
            Produto produto4 = new Produto("Monitor", 800.00);
            
            // Persistindo os produtos
            em.persist(produto1);
            em.persist(produto2);
            em.persist(produto3);
            em.persist(produto4);
            
            // Criação dos clientes
            Cliente cliente1 = new Cliente("João Silva");
            Cliente cliente2 = new Cliente("Maria Oliveira");
            Cliente cliente3 = new Cliente("Cawa Estevan"); 
            Cliente cliente4 = new Cliente("Pedro Santos");
            
            // Persistindo os clientes
            em.persist(cliente1);
            em.persist(cliente2);
            em.persist(cliente3);
            em.persist(cliente4);
            
            // Criação das vendas
            // Venda 1
            Venda venda1 = new Venda();
            venda1.setCliente(cliente1);
            venda1.setProdutos(Arrays.asList(produto1, produto2));
            venda1.setValorTotal(produto1.getPreco() + produto2.getPreco());
            
            // Venda 2
            Venda venda2 = new Venda();
            venda2.setCliente(cliente2);
            venda2.setProdutos(Arrays.asList(produto3));
            venda2.setValorTotal(produto3.getPreco());
            
            // Venda 3
            Venda venda3 = new Venda();
            venda3.setCliente(cliente3);
            venda3.setProdutos(Arrays.asList(produto1, produto4));
            venda3.setValorTotal(produto1.getPreco() + produto4.getPreco());
            
            // Venda 4
            Venda venda4 = new Venda();
            venda4.setCliente(cliente4);
            venda4.setProdutos(Arrays.asList(produto2, produto3, produto4));
            venda4.setValorTotal(produto2.getPreco() + produto3.getPreco() + produto4.getPreco());
            
            // Persistindo as vendas
            em.persist(venda1);
            em.persist(venda2);
            em.persist(venda3);
            em.persist(venda4);
            
            em.getTransaction().commit(); // Confirmar as alterações realizadas
            
            // Mostrar o resultado dos selects
            System.out.println("\n--- SELECT * FROM cliente ---");
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            for (Cliente c : clientes) {
                System.out.println(c);
            }
            
            System.out.println("\n--- SELECT * FROM produto ---");
            List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
            for (Produto p : produtos) {
                System.out.println(p);
            }
            
            System.out.println("\n--- SELECT * FROM venda ---");
            List<Venda> vendas = em.createQuery("SELECT v FROM Venda v", Venda.class).getResultList();
            for (Venda v : vendas) {
                System.out.println(v);
            }
            
            System.out.println("\n--- SELECT * FROM venda_produto ---");
            List<Object[]> vendaProdutos = em.createNativeQuery("SELECT * FROM venda_produto").getResultList();
            for (Object[] vp : vendaProdutos) {
                System.out.println("Venda ID: " + vp[0] + ", Produto ID: " + vp[1]);
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