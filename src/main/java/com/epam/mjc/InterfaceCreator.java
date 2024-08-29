package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return l -> {
            for (String s : l) {
                if (!Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return l -> {
            List<Integer> evens = new ArrayList<>();
            for (Integer i : l) {
                if (i % 2 == 0) {
                    evens.add(i);
                }
            }
            l.addAll(evens);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredCollection = new ArrayList<>();

            for (String s : values) {
                if (new StringTokenizer(s).countTokens() > 3 &&
                        Character.isUpperCase(s.charAt(0)) &&
                        '.' == s.charAt(s.length() - 1)) {
                    filteredCollection.add(s);
                }
            }

            return filteredCollection;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return l -> {
            Map<String, Integer> map = new HashMap<>();

            for (String s : l) {
                map.put(s, s.length());
            }

            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (l1, l2) -> {
            List<Integer> concatenated = new ArrayList<>(l1);
            concatenated.addAll(l2);
            return concatenated;
        };
    }
}
