package dev.danilosales.linguagem;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.function.IntPredicate;

public class LocalVar {

    @Test
    void localTypeInference() {
        var primiteInt = 1; // int
        var doubleVal = 5d; //double

        // final List<String> objectList
        final var objectList = List.of("A", "B", "C");

        var palavra = ""; // String
        for (var str: objectList){
            palavra += str.toLowerCase();
        }
    }

    @Test
    void algumasRegrinhas() {

        // No caso de byte e short deve-se fazer o cast
        // se não será inferido o tipo int ao var
        var byteVal = (byte) 4;

        // Não tem como inferir um tipo nos casos abaixo
        //var naoCompila;
        //var naoCompila = null;
        //var naoCompila = {-1, 1};

        // O tipo é inferido na hora da inicialização da variavel
        var map = new HashMap<>();
        map.put(1, "Teste");
        //var naoCompila = map.get(1).trim();
        // O map é um Map<Object, Object>

        var predicate = new IntPredicate() {
            public boolean test(int value) {
                return value > 0;
            }
        };

        //predicate = (int i) -> (i % 2) == 0;
    }

    @FunctionalInterface
    interface Lambda {
        Long myFunction(Long x, Long y);
    }

    

}
