package zad2;

public class Kwadrat implements Figura{
    private double bok;

    public Kwadrat(double bok) {
        this.bok = bok;
    }

    @Override
    public double obliczPole() {
        return Math.pow(bok,2);
    }

    @Override
    public double obliczObwod() {
        return 4*bok;
    }

    public double getBok() {
        return bok;
    }

    public void setBok(double bok) {
        this.bok = bok;
    }

    @Override
    public String toString() {
        return "Kwadrat:" +
                " Bok: " + bok;
    }

}
