package pl.kurs.zadanie3.app;

import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(10, -5, 15, -15, 17, -17, -55, 50, 25, -50, 75, -10, 55, 0, 50);
        List<Integer> fiveLargestNumbers = getFiveLargestNumbers(integerList);
        System.out.println("fiveLargestNumbers = " + fiveLargestNumbers);

        List<Integer> integerList1 = List.of();
        List<Integer> fiveLargestNumbers1 = getFiveLargestNumbers(integerList1);
        System.out.println("fiveLargestNumbers1 = " + fiveLargestNumbers1);

        List<Integer> integerList2 = null;
        List<Integer> fiveLargestNumbers2 = getFiveLargestNumbers(integerList2);
        System.out.println("fiveLargestNumbers2 = " + fiveLargestNumbers2);

        List<Integer> integerList3 = List.of(10, -5, 15, -15);
        List<Integer> fiveLargestNumbers3 = getFiveLargestNumbers(integerList3);
        System.out.println("fiveLargestNumbers3 = " + fiveLargestNumbers3);

    }

    public static List<Integer> getFiveLargestNumbers(List<Integer> integerList) {
        return Optional.ofNullable(integerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
//                .distinct() //jeśli elementy na zwróconej liście mają być różne
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.size() >= 5 ? list : Collections.emptyList()));
    }

//    opcja 2
    public static List<Integer> getFiveLargestNumbers1(List<Integer> integerList) {
        int elementsQty = Optional.ofNullable(integerList)
                .orElseGet(Collections::emptyList)
                .size();
        return elementsQty < 5 ? Collections.emptyList() : Optional.of(integerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
//                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());
    }

}
