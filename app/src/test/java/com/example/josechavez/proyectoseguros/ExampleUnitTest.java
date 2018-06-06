package com.example.josechavez.proyectoseguros;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Prueba1() throws Exception {
        assertEquals(80028352, metodo.gamma1(0),0); //acpm	credito	gama alta
    }

    @Test
    public void Prueba2() throws Exception {
        assertEquals(40028352, metodo.gamma1(1),0); //acpm	credito	gama media
    }


    @Test
    public void Prueba3() throws Exception {
        assertEquals(80008352, metodo.gamma2(0),0); //acpm	efectivo	gama alta
    }

    @Test
    public void Prueba4() throws Exception {
        assertEquals(40008352, metodo.gamma2(1),0); //acpm	efectivo	gama media
    }

    @Test
    public void Prueba5() throws Exception {
        assertEquals(80029021, metodo.gamma3(0),0);//gasolina	credito	gama alta
    }

    @Test
    public void Prueba6() throws Exception {
        assertEquals(40029021, metodo.gamma3(1),0); //gasolina	credito	gama media

    }

    @Test
    public void Prueba7() throws Exception {
        assertEquals(80009021, metodo.gamma4(0),0); //gasolina	efectivo	gama alta
    }

    @Test
    public void Prueba8() throws Exception {
        assertEquals(40009021, metodo.gamma4(1),0); //gasolina	efectivo	gama media
    }
}
