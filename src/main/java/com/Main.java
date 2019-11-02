package com;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.Sort.sortowanieSamochodow;

public class Main {
    public static void main(String[] args) {
        List<Car> car = new ArrayList<Car>();

        System.out.println("\nWitaj w komisie samochodowym!");
        Scanner scanner = new Scanner(System.in);

        int wybor = 0;
        do {
            System.out.println("\n1. Dodawanie nowego samochodu");
            System.out.println("2. Wyświetlanie listy samochodów");
            System.out.println("3. Usuwanie wprowadzonych samochodów");
            System.out.println("4. Wyjscie z programu\n");
            System.out.println("Wybierz jedną z powyzszych opcji");

            wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    dodowanieSamochodu(car);
                    break;

                case 2:
                    if (car.isEmpty()) {
                        System.out.println("Lista jest pusta, dodaj samochód");
                    } else {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Lista samochodów:\n");
                        System.out.println(car.toString() + "\n");

                        int wybor2 = 0;

                        do {
                            System.out.println("Dostępne opcje: ");
                            System.out.println("Sortowanie samochodów - wybierz 1");
                            System.out.println("Filtrowanie samochodów - wybierz 2");
                            wybor2 = scanner1.nextInt();
                            if (wybor2 == 1) {
                                sortowanieSamochodow(car);
                            }
                            if (wybor2 == 2) {
                                filtrowanieSamochodow(car);
                            }
                        } while (wybor2 > 2 || wybor2 < 1);
                        break;


                    }
                case 3:
                    if (car.isEmpty()) {
                        System.out.println("Lista jest pusta, dodaj samochód");
                    } else {
                        usuwanieSamochodu(car);
                    }

                case 4:
                    break;
                default:

            }


        } while (wybor != 4);
    }

    private static void usuwanieSamochodu(List<Car> car) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Która pozycje z Listy samochodów chcesz usunąc?" + " Aktualna ilosc pozycji na liscie: " + car.size());

        int indeks = scanner.nextInt();
        while (indeks > car.size() || indeks < 1) {
            System.out.println("Poza granicami listy, sprobuj ponownie");
            indeks = scanner.nextInt();
        }
        car.remove(indeks - 1);
        System.out.println("Pozycja " + indeks + " usunięta");
        System.out.println(car.toString());

    }

    private static void dodowanieSamochodu(List<Car> car) {
        Car car1 = new Car();
        Scanner sc = new Scanner(System.in);
        System.out.println("Wybrano dodanie nowego samochodu");

        System.out.println("podaj marka");
        car1.setMarka(sc.next());
        System.out.println("podaj cena");
        car1.setCena(sc.nextBigDecimal());
        System.out.println("podaj ilosc drzwi");
        car1.setIloscDrzwi(sc.nextInt());

        System.out.println("podaj kolor");
        car1.setKolor(sc.next());
        System.out.println("podaj przebieg");
        car1.setPrzebieg(sc.nextInt());
        System.out.println("podaj rocznik");
        car1.setRocznik(sc.nextInt());
        car.add(car1);
        System.out.println("Dodano \n" + car1);
    }

    private static void filtrowanieSamochodow(List<Car> car) {
        Scanner parametrFiltrowania = new Scanner(System.in);
        Scanner wartosc = new Scanner(System.in);

        int parametr = 0;

        do {
            System.out.println("Wybrano filtrowanie samochodów, Po jakim parametrze chcesz filtorwać?");
            System.out.println("1. Marka \n2. Cena \n3. Ilosc drzwi \n4. Kolor \n5. Przebieg \n6. Rocznik");
            parametr = parametrFiltrowania.nextInt();
        } while (parametr < 1 || parametr > 6);

        if (parametr == 1) {
            System.out.println("Podaj jakiej marki");
            String marka = wartosc.next();

            car.stream().filter(c -> c.getMarka().equals(marka)).forEach(System.out::println);
        } else if (parametr == 2) {
            System.out.println("Podaj jakiej ceny szukasz");
            BigDecimal cena = wartosc.nextBigDecimal();

            car.stream().filter(c -> c.getCena().equals(cena)).collect(Collectors.toList()).forEach(System.out::println);
        } else if (parametr == 3) {
            System.out.println("Podaj jakiej ilosc drzwi szuakasz");
            int iloscDrzwi = wartosc.nextInt();

            car.stream().filter(c -> c.getIloscDrzwi() == iloscDrzwi).collect(Collectors.toList()).forEach(System.out::println);

        } else if (parametr == 4) {
            System.out.println("Podaj jakiego koloru szukasz");
            String kolor = wartosc.next();

            car.stream().filter(c -> c.getKolor().equals(kolor)).collect(Collectors.toList()).forEach(System.out::println);
        }

        if (parametr == 5) {
            System.out.println("Podaj jakiego przebiegu szukasz");
            int przebieg = wartosc.nextInt();

            car.stream().filter(c -> c.getPrzebieg() == przebieg).collect(Collectors.toList()).forEach(System.out::println);
        }

        if (parametr == 6) {
            System.out.println("Podaj jakiego roczniku szukasz");
            int rocznik = wartosc.nextInt();

            car.stream().filter(c -> c.getRocznik() == rocznik).collect(Collectors.toList()).forEach(System.out::println);
        }
    }

}