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
        // Instancia o EntityManagerFactory com as configurações de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ex2-jpa");
        // Instancia o EntityManager
        EntityManager em = emf.createEntityManager();

        // Crie seu nome e idade reais aqui
        Vendedor vendedor = new Vendedor("Cawa", 20, 01);
        Cliente cliente = new Cliente("Rafael", 34, 01);

        em.getTransaction().begin();
        // iniciar transação com banco de dados

        em.persist(vendedor);
        em.persist(cliente);

        // consulta em jpql para vendedores
        Query consultaVendedor = em.createQuery("select vendedor from Vendedor vendedor");
        ArrayList<Vendedor> listaVendedor = (ArrayList<Vendedor>) consultaVendedor.getResultList();

        // consulta em jpql para clientes
        Query consultaCliente = em.createQuery("select cliente from Cliente cliente");
        ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) consultaCliente.getResultList();

        em.getTransaction().commit();
        // confirmar as alterações realizadas
        
        emf.close();
        em.close();

        System.out.println("==== Vendedores ====");
        for (Vendedor objVendedor: listaVendedor) {
            System.out.println(objVendedor);
        }

        System.out.println("==== Clientes ====");
        for (Cliente objCliente: listaCliente) {
            System.out.println(objCliente);
        }
    }
}