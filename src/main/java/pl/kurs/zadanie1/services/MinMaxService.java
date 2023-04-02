package pl.kurs.zadanie1.services;

import pl.kurs.zadanie1.models.MinMax;

import java.awt.image.ImageProducer;
import java.util.*;

public class MinMaxService {

    public static <T extends Comparable> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements.isEmpty())
            throw new IllegalArgumentException("Provided list is empty");
        T min = elements.get(0);
        T max = elements.get(0);
        for (T element : elements)
            if (element != null) {
                if (element.compareTo(min) < 0)
                    min = element;
                if (element.compareTo(max) > 0)
                    max = element;
            }
        return new MinMax<T>(min, max);
    }

//    opcja 2 - z użyciem strumieni
    public static <T extends Comparable> MinMax<T> getMinAndMaxFromStream(List<T> elements) {
        T min = Optional.ofNullable(elements)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .min(Comparable::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("No elements found"));
        T max = Optional.ofNullable(elements)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparable::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("No elements found"));
        return new MinMax<>(min, max);
    }

}