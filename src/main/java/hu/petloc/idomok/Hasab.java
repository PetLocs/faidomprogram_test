package hu.petloc.idomok;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Hasab extends FaIdom{
    private double A;
    private double B;
    private double M;

    public Hasab(double a, double b, double m) {
        A = a;
        B = b;
        M = m;
    }

    public Hasab() {
        this(1, 1, 1);
    }

    public double getA() {
        return this.A;
    }

    public double getB() {
        return this.B;
    }

    public double getM() {
        return this.M;
    }

    @Override
    public double terfogat() {
        return Math.round(A*B*M*10)/10.0;
    }

    @Override
    public double suly() {
        return Math.round(super.suly() * 10)/10.0;
    }
}
