import java.util.List;
import java.util.ArrayList;

public class Carrinho {
    private String pedidos;
    private String pedidoFinal = " ";
    private List<Produto> produtos = new ArrayList<>();;

    public Carrinho(Produto produto, int quantidade) {
        this.produtos.add(produto);
    }

    public boolean removeProduto(String nome, double valor) {
        for (Produto e : produtos) {
            if (e.getNome().equalsIgnoreCase(nome) && e.getValor() == valor) {
                produtos.remove(e);
                return true;
            }
        }
        System.out.printf("%nProduto não está no carrinho!%n");
        return false;
    }

    public double valorPagamento(String escolha, String forma, int quantidade) {
        double pagFinal = 0;

        for (Produto e : produtos) {
            if (forma.equals("2") && e != null) {
                if (e.getNome().equalsIgnoreCase(escolha)) {
                    pagFinal += quantidade * e.getValor();
                    // Concateno para imprimir no recibo do pedido (GAMBIARRA)
                    pedidoFinal += e.getNome();
                    pedidoFinal += "%n" + "Total de produtos comprados: " + quantidade;
                    break;
                }
            } else {
                if (e.getNome().equalsIgnoreCase(escolha) && e != null) {
                    pagFinal = (quantidade * e.getValor()) * 0.10;

                    // Concateno para imprimir no recibo do pedido (GAMBIARRA)
                    pedidoFinal += e.getNome();
                    pedidoFinal += ("%n" + "Total de produtos comprados: " + quantidade);
                    break;
                }
            }
        }
        return pagFinal;
    }

    public String getPedidos() {
        return pedidos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String toString() {
        return String.format(pedidoFinal);
    }
}