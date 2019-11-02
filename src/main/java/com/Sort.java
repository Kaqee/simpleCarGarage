package com;



import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Sort {

public static void sortowanieSamochodow(List<Car> auta){
    Scanner parametrSortowania=new Scanner(System.in);
    int parametr=0;

    do {

        System.out.println("Wybrno sortowanie samochodów, po jakim parametrze chcesz sortowac?");

        System.out.println("1. Marka \n2. Cena \n3. Ilosc drzwi \n4. Marka \n5. Przebieg \n6. Rocznik");
        parametr = parametrSortowania.nextInt();
    }while (parametr<1 || parametr>6);

if(parametr==1){
auta.stream()
    .sorted(Comparator.comparing(Car::getMarka))
    .forEach(System.out::println);
}

if(parametr==2){
    auta.stream()
    .sorted((Car c1, Car c2)->{
        BigDecimal cena1=c1.getCena();
        BigDecimal cena2=c2.getCena();
        return cena1.compareTo(cena2);
    }).forEach(System.out::println);
}


if(parametr==3){
    auta.stream()
    .sorted((c1,c2)->((Integer)c1.getIloscDrzwi()).compareTo(c1.getIloscDrzwi()))
.forEach(System.out::println);
}

if(parametr==4){
    auta.stream()
    .sorted(Comparator.comparing(Car::getKolor))
    .forEach(System.out::println);
}


if(parametr==5){
    auta.stream()
            .sorted((c1,c2)->c1.getPrzebieg()-c2.getPrzebieg())
            .forEach(System.out::println);
}

if(parametr==6){
    auta.stream()
            .sorted(Comparator.comparing(Car::getRocznik))
            .forEach(System.out::println);
}


}






}
