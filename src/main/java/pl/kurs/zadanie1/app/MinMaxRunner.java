package pl.kurs.zadanie1.app;

import pl.kurs.zadanie1.services.MinMaxService;

import java.util.ArrayList;
import java.util.List;

public class MinMaxRunner {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(-12);
        integerList.add(null);
        integerList.add(222);
        integerList.add(-22);
        integerList.add(12);
        integerList.add(0);
        System.out.println("MinMaxService.getMinAndMax(integerList) = " + MinMaxService.getMinAndMax(integerList));
        System.out.println("MinMaxService.getMinAndMax(integerList).getMin() = "
                + MinMaxService.getMinAndMax(integerList).getMin());

        List<String> stringList = List.of("Lolek", "Bolek", "Antek", "Rysiek", "Zosia", "Krysia");
        System.out.println("MinMaxService.getMinAndMax(stringList) = " + MinMaxService.getMinAndMax(stringList));
        System.out.println("MinMaxService.getMinAndMax(stringList).getMax() = "
                + MinMaxService.getMinAndMax(stringList).getMax());

    }
}
