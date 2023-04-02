package pl.kurs.zadanie4.services;

import pl.kurs.zadanie4.exceptions.NoWomenException;
import pl.kurs.zadanie4.models.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {

    public PersonService() {
    }

    public Person getOldestWoman(List<Person> people) throws NoWomenException {
        return Optional.ofNullable(people)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomenException("No woman found"));
    }

    public long getAverageAge(List<Person> people) {
        return Math.round(Optional.ofNullable(people)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0));
    }

    public long getAverageWomenAge(List<Person> people) {
        return Math.round(Optional.ofNullable(people)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> x.getFirstName().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0));
    }

    public long getAverageMenAge(List<Person> people) {
        return Math.round(Optional.ofNullable(people)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.getFirstName().endsWith("a"))
                .mapToInt(Person::getAge)
                .average()
                .orElse(0));
    }

    public long getAverageAgeOfSex(List<Person> people, Predicate<Person> sexPredicate) {
        return Math.round(Optional.ofNullable(people)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(sexPredicate)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0));
    }

    public List<String> getCityWithMostPeople(List<Person> people) {
        Map<String, Long> map = Optional.ofNullable(people)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getCity()))
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));
        long max = map
                .values()
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);
        return map
                .entrySet()
                .stream()
                .filter(x -> x.getValue().equals(max))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Set<String> getAllDistinctCities(List<Person> people) {
        return Optional.ofNullable(people)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(Person::getCity)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

}
