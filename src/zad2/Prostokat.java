package zad2;

public class Prostokat implements Figura{
    private double bok1,bok2;

    public Prostokat(double bok1, double bok2) {
        this.bok1 = bok1;
        this.bok2 = bok2;
    }

    @Override
    public double obliczPole() {
        return bok1*bok2;
    }

    @Override
    public double obliczObwod() {
        return 2*(bok1 +bok2);
    }

    public double getBok1() {
        return bok1;
    }

    public void setBok1(double bok1) {
        this.bok1 = bok1;
    }

    public double getBok2() {
        return bok2;
    }

    public void setBok2(double bok2) {
        this.bok2 = bok2;
    }

    @Override
    public String toString() {
        return "Prostokat: " +
                "Bok A: " + bok1 +
                ", Bok B: " + bok2;
    }
}
