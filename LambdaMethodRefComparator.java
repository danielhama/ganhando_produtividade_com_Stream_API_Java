package handson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaMethodRefComparator {
    public static void main(String[] args) {
        List<String> palavras = new ArrayList<String>();

        palavras.add("Dio");
        palavras.add("Bootcamp");
        palavras.add("Java");
        palavras.add("Codifique");
        palavras.add("Stream");
        palavras.add("Lambda");
        palavras.add("Reference");

        // Method Reference é usado para simplificar uma função, passando o tipo de dados que vai ser passado, e utilizando um método do tipo passado
        // no caso foi passado para o comparator uma string, e os :: indica que será utilizado o método length para comparação


        List<Integer> numeros = new ArrayList<Integer>();

        numeros.add(10);
        numeros.add(8);
        numeros.add(167);
        numeros.add(4232);
        numeros.add(11);
        numeros.add(15);
        numeros.add(1546);

        // Utilizando colletions para ordenar
        Collections.sort(numeros);

        Collections.sort(palavras);
        System.out.println(palavras);

        System.out.println(numeros);

        // Lambda

        palavras.sort(Comparator.comparing(s -> s.length())); // IDE mostra a possibiliadade de usar method reference
        System.out.println(palavras);                           //Lambda can be replaced with method reference
//Method Reference
        palavras.sort(Comparator.comparing(String::length));
        System.out.println(palavras);
//        String teste = "teste";
//        System.out.println(teste.substring(teste.length() - 1));

        // Ordenando pela ultima letra
        palavras.sort(Comparator.comparing(s -> s.substring(s.length() - 1))); // Neste caso não é possível utilizar o method reference
        System.out.println(palavras);

        // Lambda para imprimir

        palavras.forEach(s -> System.out.println(s));

        // Method Reference para imprimir
        palavras.forEach(System.out::println);

    }
}


