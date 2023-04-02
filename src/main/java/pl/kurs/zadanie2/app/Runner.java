package pl.kurs.zadanie2.app;

import org.apache.commons.lang3.StringUtils;
import pl.kurs.zadanie2.exceptions.InvalidPeselException;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Please enter your first name:");
            Optional<String> firstNameOpt = Optional.ofNullable(scanner.nextLine());
            firstNameOpt.ifPresentOrElse(x -> System.out.println("Length of your name: " + x.length()),
                    () -> System.out.println(0));

            System.out.println("Enter your PESEL number:");
            Optional<String> peselOpt = Optional.ofNullable(scanner.nextLine());
            LocalDate birthDate = peselOpt
                    .filter(x -> x.length() == 11 && StringUtils.isNumeric(x))
                    .map(x -> getBirthDateFromPesel(x))
                    .orElseThrow(() -> new InvalidPeselException("Invalid input"));
            System.out.println("Your date of birth: " + birthDate);

        } catch (InvalidPeselException e) {
            System.err.println(e.getMessage());
        }

        scanner.close();
    }

    private static LocalDate getBirthDateFromPesel(String pesel) {
        int year = Integer.parseInt(pesel.substring(0, 2));
        String fullYear = (year >= 0 && year <= 18) ? "20" + year : "19" + year;
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));
        return LocalDate.of(Integer.parseInt(fullYear), month, day);
    }

}
