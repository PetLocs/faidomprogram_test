package hu.petloc.idomok;

public class Gomb extends FaIdom{
    private double sugar;

    public Gomb(double sugar) {
        this.sugar = sugar;
    }

    public Gomb() {
        this(1);
    }

    @Override
    public double terfogat() {
        return Math.round(4*Math.pow(sugar,3)*Math.PI/3*10)/10.0;
    }

    @Override
    public double suly() {
        return Math.round(super.suly() * 100)/100.0;
    }
}
