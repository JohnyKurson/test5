package zad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Figura> figury = wczytajFiguryZPliku("src/zad2/figury.txt");
        int liczbaKwadratow = policzKwadraty(figury);
        System.out.println("Liczba kwadratów: " + liczbaKwadratow);
        wypiszPolaIObwodyFigur(figury);
    }

    public static List<Figura> wczytajFiguryZPliku(String nazwaPliku) {
        List<Figura> figury = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nazwaPliku))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dane = linia.split(";");
                String typFigury = dane[0];
                double[] parametry = new double[dane.length - 1];
                for (int i = 1; i < dane.length; i++) {
                    parametry[i - 1] = Double.parseDouble(dane[i]);
                }
                figury.add(FiguraFactory.stworzFigure(typFigury, parametry));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return figury;
    }

    public static int policzKwadraty(List<Figura> figury) {
        int liczbaKwadratow = 0;
        for (Figura figura : figury) {
            if (figura instanceof Kwadrat) {
                liczbaKwadratow++;
            }
        }
        return liczbaKwadratow;
    }

    public static void wypiszPolaIObwodyFigur(List<Figura> figury) {
        for (Figura figura : figury) {
            String typFigury = figura.getClass().getSimpleName();
            double pole = figura.obliczPole();
            double obwod = figura.obliczObwod();
            System.out.println("Figura: " + typFigury + ", Pole: " + pole + ", Obwód: " + obwod);
        }
    }
}

    /*

    Dany jest plik figury.txt który wygląda mniej wiecej tak:
KWADRAT;10
KWADRAT;20
PROSTOKAT;10;30
KOLO;10
KOLO;20
PROSTOKAT;40;50
KWADRAT;60
nalezy wczytac figury z tego pliku oraz stworzyc z nich liste/tablice figur w programie.
nastepnie nalezy przeiterowac po tej liscie/tablicy i wypisac:
- ile jest kwadratow
- dla kazdej figury wypisac jej pole oraz obwod.

nie mozna uzywac ifow/switchow do rozwiazania problemu wczytywania figur.

    */


