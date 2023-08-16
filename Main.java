package handson;
;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("___________________________________________");
        ArrayList<Livro> livros = new ArrayList<Livro>() {
            {
                add(new Livro("Java - Guia do Programador: Atualizado Para Java 16", "Peter Jandl Junior", 2021));
                add(new Livro("Desenvolvimento Real de Software: Um guia de projetos para fundamentos em Java",
                        "Raoul-Gabriel Urma e  Richard Warburton", 2021));
                add(new Livro(
                        "Microsserviços Prontos Para a Produção: Construindo Sistemas Padronizados em uma Organização de Engenharia de Software",
                        "Susan J. Fowler", 2017));
                add(new Livro("Entendendo Algoritmos: Um Guia Ilustrado Para Programadores e Outros Curiosos",
                        "Aditya Y. Bhargava", 2017));
                add(new Livro("Kotlin em Ação", "Dmitry Jemerov e Svetlana Isakova", 2017));

        }
        };


}}
