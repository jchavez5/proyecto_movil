package com.example.josechavez.proyectoseguros;

/**
 * Created by Josechavez on 05/06/2018.
 */

public class metodo {
    public static int gamma1(int i){
        switch (i) {
            case 0: return 80028352; //acpm	credito	gama alta

            case 1: return 40028352; //acpm	credito	gama media

            case 2: return 20028352; //acpm	credito	gama baja

        }
        return 0;
    }
    public static int gamma2(int i){
        switch (i) {
            case 0: return  80008352; //acpm	efectivo	gama alta

            case 1: return  40008352; //acpm	efectivo	gama media

            case 2: return  20008352; // acpm	efectivo	gama baja

        }
        return 0;
    }
    public static int gamma3(int i){
        switch (i) {
            case 0: return 80029021; //gasolina	credito	gama alta

            case 1: return 40029021; //gasolina	credito	gama media

            case 2: return 20029021; //gasolina	credito	gama baja
        }
        return 0;
    }
    public static int gamma4(int i){
        switch (i) {
            case 0: return 80009021; //gasolina	efectivo	gama alta


            case 1: return 40009021; //gasolina	efectivo	gama media


            case 2: return 20009021; //gasolina	efectivo	gama baja


        }
        return 0;
    }

}
