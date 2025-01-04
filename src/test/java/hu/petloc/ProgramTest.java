package hu.petloc;

import hu.petloc.idomok.FaIdom;
import hu.petloc.idomok.Gomb;
import hu.petloc.idomok.Hasab;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramTest {
    //FaIdomokProgram program;
    /* vagy static a program vagy nem static az Ini */
    static FaIdomokProgram program;

    @BeforeAll
    static void programIni(){
        Class<?> clazz = FaIdomokProgram.class;
        String pkg = clazz.getPackageName();
        //assertEquals("hu.soter", pkg, "a csomag 'hu.soter' legyen.");
        /*egyedi package mindenkinél */
        assertEquals("hu.petloc", pkg, "a csomag 'hu.petloc' legyen.");

        program = new FaIdomokProgram();
        program.ujIdom(new Gomb(1));
        program.ujIdom(new Hasab(1,1,1));
    }

    @Test
    void testLista(){
        ArrayList<FaIdom> lista = program.getLista();
        Assertions.assertEquals(2, lista.size());

        lista.add(new Gomb(1));
        //Assertions.assertEquals(2, program.getLista().size());
        /* méret tévesen lett megadva */
        Assertions.assertEquals(3, program.getLista().size());
    }

    @Test
    void testSzamolasok(){
        //Assertions.assertEquals(4.16, program.osszSuly(), 0.001);
        //Assertions.assertEquals(3.36, program.gombokOsszSuly(), 0.001);
        /* hiányzik az első gömb súlya */
        Assertions.assertEquals(7.502, program.osszSuly(), 0.001);
        Assertions.assertEquals(6.702, program.gombokOsszSuly(), 0.001);

        //Hasab hasab = new Hasab(1.0, 1.0, 1.0);
        /* az új idom nem része a listának, ujIdom() metódus szükséges */
        Hasab hasab = new Hasab(1.0, 1.0, 1.0);
        program.ujIdom(hasab);
        Assertions.assertEquals(hasab.terfogat(), program.minV().terfogat());
        Gomb gomb = new Gomb(1.0);
        /* az új idom nem része a listának, ujIdom() metódus szükséges */
        program.ujIdom(gomb);
        Assertions.assertEquals(gomb.terfogat(), program.maxV().terfogat());
    }
}