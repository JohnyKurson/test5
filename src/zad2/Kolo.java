package zad2;

public class Kolo implements Figura{
    private double promien;

    public Kolo(double promien) {
        this.promien = promien;
    }

    @Override
    public double obliczPole() {
        return Math.PI * Math.pow(promien,2);
    }

    @Override
    public double obliczObwod() {
        return 2 * Math.PI * promien;
    }

    public double getPromien() {
        return promien;
    }

    public void setPromien(double promien) {
        this.promien = promien;
    }

    @Override
    public String toString() {
        return "Koło:" +
                " Promień: " + promien;
    }
}
