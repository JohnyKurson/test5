package zad2;

import java.util.Map;
import java.util.function.Function;

public class FiguraFactory {
    private static final Map<String, Function<double[], Figura>> figuraMap = Map.of(
            "KWADRAT", parametry -> new Kwadrat(parametry[0]),
            "PROSTOKAT", parametry -> new Prostokat(parametry[0], parametry[1]),
            "KOLO", parametry -> new Kolo(parametry[0]));

    public static Figura stworzFigure(String typ, double[] parametry) {
        Function<double[], Figura> figuraCreator = figuraMap.get(typ);
        if (figuraCreator != null) {
            return figuraCreator.apply(parametry);
        } else {
            throw new IllegalArgumentException("Nieznany typ figury: " + typ);
        }
    }
}


