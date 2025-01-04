package hu.petloc;

import hu.petloc.idomok.FaIdom;
import hu.petloc.idomok.Gomb;
import hu.petloc.idomok.Hasab;

import java.awt.*;
import java.util.ArrayList;

public class FaIdomokProgram {
    private ArrayList<FaIdom> idomok;

    public FaIdomokProgram() {
        this.idomok = new ArrayList<>();
        idomok.clear();
    }

    public void ujIdom(FaIdom idom){
        idomok.add(idom);
    };

    public ArrayList<FaIdom> getLista() {
        return this.idomok;
    }

    public double osszSuly() {
        double sum = 0;
        for (FaIdom idom : idomok){
            sum += idom.suly();
        }
        return sum;
    }

    public double gombokOsszSuly() {
        double sum = 0;
        for (FaIdom idom : idomok){
            if (idom instanceof Gomb) {
                sum += idom.suly();
            }
        }
        return sum;
    }

    public FaIdom minV() {
        double min = Double.POSITIVE_INFINITY;
        int index = 0;
        for (int i = 0; i < idomok.size(); i++) {
            if (idomok.get(i).terfogat() < min){
                min = idomok.get(i).terfogat();
                index = i;
            }
        }
        return idomok.get(index);
    }

    public FaIdom maxV() {
        double max = 0;
        int index = 0;
        for (int i = 0; i < idomok.size(); i++) {
            if (idomok.get(i).terfogat() > max){
                max = idomok.get(i).terfogat();
                index = i;
            }
        }
        return idomok.get(index);
    }
}