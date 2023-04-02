package pl.kurs.zadanie4.app;

import pl.kurs.zadanie4.exceptions.NoWomenException;
import pl.kurs.zadanie4.models.Person;
import pl.kurs.zadanie4.services.PersonService;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws NoWomenException {

        List<Person> peopleList = List.of(
                new Person("Adam", "Nowak", "Warszawa", 30),
                new Person("Katarzyna", "Kowalska", "Kraków", 25),
                new Person("Tomasz", "Lewandowski", "Gdańsk", 42),
                new Person("Anna", "Wiśniewska", "Poznań", 22),
                new Person("Michał", "Kubiak", "Szczecin", 33),
                new Person("Magdalena", "Cieślak", "Lublin", 20),
                new Person("Jan", "Zieliński", "Katowice", 37),
                new Person("Aleksander", "Piotrowski", "Wrocław", 24),
                new Person("Grzegorz", "Mazurek", "Łódź", 50),
                new Person("Joanna", "Szymańska", "Gdańsk", 27),
                new Person("Piotr", "Jankowski", "Kraków", 29),
                new Person("Natalia", "Kaczmarek", "Rzeszów", 26),
                new Person("Krzysztof", "Kowalczyk", "Warszawa", 36),
                new Person("Karolina", "Nowicka", "Warszawa", 23),
                new Person("Marcin", "Górski", "Gdańsk", 35),
                new Person("Monika", "Adamczyk", "Warszawa", 32),
                new Person("Bartosz", "Dąbrowski", "Sopot", 34),
                new Person("Adrian", "Kwiatkowski", "Kraków", 21),
                new Person("Kamil", "Sikora", "Kraków", 38),
                new Person("Izabela", "Wojciechowska", "Wrocław", 39)
        );

        PersonService service = new PersonService();

        System.out.println("Oldest woman age = " + service.getOldestWoman(peopleList));
        System.out.println("Average age of people = " + service.getAverageAge(peopleList));
        System.out.println("Average women age = " + service.getAverageWomenAge(peopleList));
        System.out.println("Average men age = " + service.getAverageMenAge(peopleList));
        System.out.println("Average women age from method w/ function = "
                + service.getAverageAgeOfSex(peopleList, x -> x.getFirstName().endsWith("a")));
        System.out.println("Average women age from method w/ function = "
                + service.getAverageAgeOfSex(peopleList, x -> !x.getFirstName().endsWith("a")));
        System.out.println("City with most people = " + service.getCityWithMostPeople(peopleList));
        System.out.println("All distinct cities = " + service.getAllDistinctCities(peopleList));

    }
}
