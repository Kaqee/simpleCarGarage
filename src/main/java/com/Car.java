package com;

import lombok.*;

import java.math.BigDecimal;


@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String marka;
    private BigDecimal cena;
    private int iloscDrzwi;
    private String kolor;
    private int przebieg;
    private int rocznik;

}
