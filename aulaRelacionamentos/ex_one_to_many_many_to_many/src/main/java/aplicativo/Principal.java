package aplicativo;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    
    public static void main(String[] args) {
        // Criando alguns clientes
        Cliente cliente1 = new Cliente("João Silva");
        Cliente cliente2 = new Cliente("Maria Santos");
        
        // Criando alguns produtos
        Produto produto1 = new Produto("Notebook", 3500.00);
        Produto produto2 = new Produto("Smartphone", 1800.00);
        Produto produto3 = new Produto("Monitor", 1200.00);
        
        // Configurando IDs
        cliente1.setId(1L);
        cliente2.setId(2L);
        produto1.setId(1L);
        produto2.setId(2L);
        produto3.setId(3L);
        
        // Criando uma venda para o cliente1
        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setCliente(cliente1);
        
        // Adicionando produtos à venda1
        List<Produto> produtosVenda1 = new ArrayList<>();
        produtosVenda1.add(produto1);
        produtosVenda1.add(produto2);
        venda1.setProdutos(produtosVenda1);
        
        // Calculando o valor total da venda1
        double valorTotal = 0;
        for (Produto produto : produtosVenda1) {
            valorTotal += produto.getPreco();
        }
        venda1.setValorTotal(valorTotal);
        
        // Criando uma venda para o cliente2
        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setCliente(cliente2);
        
        // Adicionando produtos à venda2
        List<Produto> produtosVenda2 = new ArrayList<>();
        produtosVenda2.add(produto2);
        produtosVenda2.add(produto3);
        venda2.setProdutos(produtosVenda2);
        
        // Calculando o valor total da venda2
        valorTotal = 0;
        for (Produto produto : produtosVenda2) {
            valorTotal += produto.getPreco();
        }
        venda2.setValorTotal(valorTotal);
        
        // Associando vendas aos clientes
        List<Venda> vendasCliente1 = new ArrayList<>();
        vendasCliente1.add(venda1);
        cliente1.setVendas(vendasCliente1);
        
        List<Venda> vendasCliente2 = new ArrayList<>();
        vendasCliente2.add(venda2);
        cliente2.setVendas(vendasCliente2);
        
        // Exibindo informações
        System.out.println("=== Informações de Clientes ===");
        System.out.println(cliente1);
        System.out.println("Vendas de " + cliente1.getNome() + ":");
        for (Venda venda : cliente1.getVendas()) {
            System.out.println("  " + venda);
            System.out.println("  Produtos:");
            for (Produto produto : venda.getProdutos()) {
                System.out.println("    " + produto);
            }
        }
        
        System.out.println("\n" + cliente2);
        System.out.println("Vendas de " + cliente2.getNome() + ":");
        for (Venda venda : cliente2.getVendas()) {
            System.out.println("  " + venda);
            System.out.println("  Produtos:");
            for (Produto produto : venda.getProdutos()) {
                System.out.println("    " + produto);
            }
        }
        
        System.out.println("\n=== Resumo de Vendas ===");
        System.out.println("Total de vendas: " + (vendasCliente1.size() + vendasCliente2.size()));
        double valorTotalGeral = 0;
        for (Venda venda : vendasCliente1) {
            valorTotalGeral += venda.getValorTotal();
        }
        for (Venda venda : vendasCliente2) {
            valorTotalGeral += venda.getValorTotal();
        }
        System.out.println("Valor total geral: R$ " + valorTotalGeral);
    }
}