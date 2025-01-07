package hu.petloc.idomok;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdomokTest {
    FaIdom idom;

    @Test
    void testAbstract() throws NoSuchMethodException {
        Class<?> clazz = FaIdom.class;
        assertTrue(Modifier.isAbstract(clazz.getModifiers()), "A 'FaIdom' osztály legyen abstract.");

        String pkg = clazz.getPackageName();
        //assertEquals("hu.soter.idomok", pkg, "a csomag 'hu.soter.idomok' legyen.");
        /*egyedi package mindenkinél */
        assertEquals("hu.petloc.idomok", pkg, "a csomag 'hu.petloc.idomok' legyen.");

        Method method = clazz.getDeclaredMethod("terfogat");
        boolean abs = Modifier.isAbstract(method.getModifiers());
        assertTrue(abs, "a 'terfogat' metódus legyen abstract.");
    }

    @Test
    void testFajsuly(){
        assertEquals(0.8, FaIdom.getFajsuly());
    }

    @Test
    void testGombTerfogat(){
        idom = new Gomb(1.0);
        //assertEquals(4.2, idom.terfogat(), 0.001);
        /* 4.18879020479 a helyes várt érték, deltán kívül van.
         vagy pontosítjuk a várt értéket,
         vagy módosítjuk a deltát,
         vagy módosítjuk a sugarat.
         */
        //assertEquals(4.188, idom.terfogat(), 0.001);
        /* kerekítéssel megoldható */
        assertEquals(4.2, idom.terfogat(), 0.001);
    }

    @Test
    void testGombSuly(){
        idom = new Gomb(1.0);
        //assertEquals(3.36, idom.suly(), 0.001);
        /* 3.35103216382 a helyes várt érték, deltán kívül van.
         vagy pontosítjuk a várt értéket,
         vagy módosítjuk a deltát,
         vagy módosítjuk a sugarat.
         */
        //assertEquals(3.351, idom.suly(), 0.001);
        /* kerekítéssel megoldható */
        assertEquals(3.36, idom.suly(), 0.001);
    }

    @Test
    void testHasabTerfogat(){
        idom = new Hasab(1.0, 1.0, 1.0);
        assertEquals(1, idom.terfogat(), 0.001);
    }

    @Test
    void testHasabSuly(){
        idom = new Hasab(1.0, 1.0, 1.0);
        assertEquals(0.8, idom.suly(), 0.001);
    }

    @Test
    void testHasabParamSorrend(){
        Hasab hasab = new Hasab(1,2,3);
        assertEquals(1, hasab.getA());
        assertEquals(2, hasab.getB());
        assertEquals(3, hasab.getM());
    }
}