package handson;

import handson.Ordenacao.Produto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamApi {

    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<Livro>();
        livros.add(new Livro("Java - Guia do Programador: Atualizado Para Java 16", "Peter Jandl Junior", 2021));
        livros.add(new Livro("Desenvolvimento Real de Software: Um guia de projetos para fundamentos em Java",
                "Raoul-Gabriel Urma e  Richard Warburton", 2021));
        livros.add(new Livro(
                "Microsserviços Prontos Para a Produção: Construindo Sistemas Padronizados em uma Organização de Engenharia de Software",
                "Susan J. Fowler", 2017));
        livros.add(new Livro("Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos",
                "Aditya Y. Bhargava", 2017));
        livros.add(new Livro("Kotlin em Ação", "Dmitry Jemerov e Svetlana Isakova", 2017));

        // Ordenando a lista de livros pelo ano
        //Method Reference
        livros.sort(Comparator.comparing(Livro::getAno));
        System.out.println("Livros após a ordenação (Ano): ");
        System.out.println("---------------------------------------------");

        livros.forEach(System.out::println);
        System.out.println(" ");


        System.out.println("Ordenação por Autor");
        System.out.println("---------------------------------------------");

        livros.sort(Comparator.comparing(Livro::getAutor));
        System.out.println("Livros após a ordenação (Autor): ");
        livros.forEach(System.out::println);
        System.out.println(" ");

        livros.sort(Comparator.comparing(Livro::getTitulo));

        System.out.println("Livros após a ordenação (Título): ");
        System.out.println("---------------------------------------------");

        livros.forEach(System.out::println);
        System.out.println(" ");


        System.out.println("-----------------STREAMS------------------------");
        //Streams são fluxo de dados utilizados para possamos trabalhar com esses dados de forma mais criteriosa
        // Stream é um fluxo, ao utilizar streams, podemos realizar operaçães de filtragem, agregação, ordenação,
        // e não alteramos o conjunto de dados original.
        System.out.println("Filtrando por ano igual a 2017");
        System.out.println("---------------------------------------------");


        livros.stream().filter(livro -> livro.getAno() == 2017).forEach(System.out::println);
        // Lista com metodos stream filtrando com função lambda por ano, igual a 2017, imprimindo utilizando method referenca
        System.out.println(" ");
        System.out.println("Filtrando por título, contendo 'Java'");
        System.out.println("---------------------------------------------");

        System.out.println(" ");

        livros.stream()
                .filter(livro -> livro.getTitulo().contains("Java"))
                .forEach(System.out::println);
        System.out.println(" ");
        System.out.println("------Streams com Produto---------------------------------------");
        System.out.println(" ");


//        System.out.println("Filtrando por título, contendo 'Java'");
        List<Produto> produtos = new ArrayList<Produto>();

        produtos.add(new Produto(123, "Mouse sem fio", 100, 10));
        produtos.add(new Produto(321, "Teclado sem fio", 200, 65));
        produtos.add(new Produto(456, "Monitor sem fio", 300, 400));
        produtos.add(new Produto(789, "Mouse sem fio", 100, 30));
        produtos.add(new Produto(987, "Teclado sem fio", 200, 545));

        produtos.stream()
                .filter(p -> p.getPreco() > 100)
                .forEach(System.out::println);
        System.out.println(" ");
        System.out.println("O stream pode ser usado para fazer cálculos matemáticos, como a soma de quantidade de produtos, filtrando pelos preço maior que 100");

        System.out.println("------Soma quantidade de produtos---------------------------------------");
        int somaQuantidade = produtos.stream()
                .filter(p -> p.getPreco() > 100) // Filtra quantidade de produtos maior que 100
                .mapToInt(Produto::getQuantidade)// mapeia a quantidade de produtos
                .peek(System.out::println)// imprime a quantidade de produtos
                .sum(); // soma a quantidade de produtos
        System.out.println(somaQuantidade);

        System.out.println("------Soma preco de produtos---------------------------------------");

        double somaValor = produtos.stream()
                .filter(p -> p.getPreco() > 100) // Filtra quantidade de produtos maior que 100
                .mapToDouble(Produto::getPreco)// mapeia a quantidade de produtos
                .peek(System.out::println)
                .sum();// imprime a quantidade de produtos
        // multiplica o
        System.out.println(somaValor);

        System.out.println("------Insere em array ---------------------------------------");

        List<Double> listaPreco = new ArrayList<Double>();
        produtos.stream()
                .filter(p -> p.getPreco() > 100) // Filtra quantidade de produtos maior que 100
                .mapToDouble(Produto::getPreco)// mapeia a quantidade de produtos
                .peek(System.out::println)
                .forEach(listaPreco::add);// imprime a quantidade de produtos
        System.out.println(listaPreco);

        List<Integer> listaqtd = new ArrayList<Integer>();
        List<Double> listamultiplica = new ArrayList<Double>();
        AtomicInteger i = new AtomicInteger();
        produtos.stream()
                .filter(p -> p.getPreco() > 100) // Filtra quantidade de produtos maior que 100
                .mapToInt(Produto::getQuantidade)// mapeia a quantidade de produtos
                .peek(listaqtd::add)
                .forEach(p -> {
                    listamultiplica.add(p * listaPreco.get(i.get()));
                    i.getAndIncrement();
                });
        System.out.println(listaqtd);

        System.out.println(listamultiplica);//


    }
}