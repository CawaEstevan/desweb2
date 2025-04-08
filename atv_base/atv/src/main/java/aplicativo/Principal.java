package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vendas-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Criando e persistindo cliente
            Cliente c1 = new Cliente("João");
            em.persist(c1);

            // Criando e persistindo produtos
            Produto p1 = new Produto("Camisa", 59.90);
            Produto p2 = new Produto("Shorts", 39.90);
            em.persist(p1);
            em.persist(p2);

            // Criando venda e associando produtos e cliente
            Venda v1 = new Venda(99.80, c1);
            v1.getProdutos().add(p1);
            v1.getProdutos().add(p2);

            // Persistindo venda
            em.persist(v1);

            em.getTransaction().commit(); // ESSENCIAL!

            System.out.println("Dados inseridos com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
