package hu.petloc.idomok;

public abstract class FaIdom {

    private static double fajsuly = 0.8;

    public static double getFajsuly() {
        return fajsuly;
    }

    public abstract double terfogat();

    public double suly() {
        return terfogat() * fajsuly;
    }
}
