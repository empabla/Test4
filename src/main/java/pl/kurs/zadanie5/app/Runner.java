package pl.kurs.zadanie5.app;

import pl.kurs.zadanie5.exceptions.InvalidBirthDateException;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String datePattern = "dd.MM.yyyy";

        boolean errorOccurs = true;

        do {
            try {

                System.out.println("Please enter your date of birth in the following format: " + datePattern);
                String input = scanner.nextLine();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePattern);
                LocalDate birthDate = LocalDate.parse(input, dtf);
                if (birthDate.isAfter(LocalDate.now()))
                    throw new InvalidBirthDateException("Your birth date cannot be after today.");

                LocalDate today = LocalDate.now();
                long days = ChronoUnit.DAYS.between(birthDate, today);
                long months = ChronoUnit.MONTHS.between(birthDate.withDayOfMonth(1), today.withDayOfMonth(1));
                long years = ChronoUnit.YEARS.between(birthDate, today);
                System.out.println("You've been alive for " + days + " days.");
                System.out.println("You've been alive for " + months + " months.");
                System.out.println("You've been alive for " + years + " years.");
                Period p = Period.between(birthDate, today);
                System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                        " months, and " + p.getDays() +
                        " days old.");

                String dayOfWeek = birthDate.getDayOfWeek().toString();
                System.out.println("Day of week of your birthday: " + dayOfWeek);

                LocalDate friday13 = birthDate.withDayOfMonth(13);
                if (friday13.isBefore(birthDate))
                    friday13 = friday13.plusMonths(1);
                while (friday13.getDayOfWeek() != DayOfWeek.FRIDAY)
                    friday13 = friday13.plusMonths(1);
                System.out.println("First friday 13 after your birth date: " + friday13.format(dtf));

                errorOccurs = false;

            } catch (InvalidBirthDateException e) {
                System.err.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.err.println("Invalid input. Please use the following format: " + datePattern);
            }
        } while (errorOccurs);

        scanner.close();
    }


}

