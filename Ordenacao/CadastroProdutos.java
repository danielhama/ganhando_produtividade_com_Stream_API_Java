package handson.Ordenacao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionaProduto(long cod, String nome, double valor, int quantidade) {
        produtoSet.add(new Produto(cod, nome, valor, quantidade));
    }

    public Set<Produto> exibirProdutoPorNome() {
        Set<Produto> produtoPorNome = new TreeSet<>(produtoSet);
        return produtoPorNome;
    }

    public Set<Produto> exibirProdutoPorPreco() {
        Set<Produto> produtoPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtoPorPreco.addAll(produtoSet);
        return produtoPorPreco;
    }

    public Set<Produto> exibirProdutoPorQtd() {
        Set<Produto> produtoPorQtd = new TreeSet<>(new ComparatorPorQtd());
        produtoPorQtd.addAll(produtoSet);
        return produtoPorQtd;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.adicionaProduto(1, "Za",
                210.00, 1000);
        cadastroProdutos.adicionaProduto(2, "BBB",
                10.00, 80);
        cadastroProdutos.adicionaProduto(3, "gCC",
                20.00, 50);
        cadastroProdutos.adicionaProduto(4, "fDD",
                200.00, 100);
        cadastroProdutos.adicionaProduto(5, "EEE", 210.00, 101);

//        System.out.println(cadastroProdutos.produtoSet);
        System.out.println(cadastroProdutos.exibirProdutoPorNome());
        System.out.println(cadastroProdutos.exibirProdutoPorQtd());
        System.out.println(cadastroProdutos.exibirProdutoPorPreco());

    }
}



