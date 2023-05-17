package zad1;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectContainer<Person> peopleFromWarsaw = new ObjectContainer<>(p -> p.getCity().equals("Warsaw"));

        peopleFromWarsaw.add(new Person("Jan", "Warsaw", 30));
        peopleFromWarsaw.add(new Person("Weronika", "Warsaw", 20));
        peopleFromWarsaw.add(new Person("Waldek", "Monaco", 34));
        peopleFromWarsaw.add(new Person("Anna", "Warsaw", 45));
        peopleFromWarsaw.add(new Person("Karolina", "Gdansk", 25));
        peopleFromWarsaw.add(new Person("Piotr", "Warsaw", 60));

        List<Person> females = peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a"));
        System.out.println("Females from Warsaw: " + females);

        peopleFromWarsaw.removeIf(p -> p.getAge() > 50);
        System.out.println("People under 50: " + peopleFromWarsaw.getObjects());

        peopleFromWarsaw.storeToFile("youngPeopleFromWarsaw.txt", p -> p.getAge() < 30, p -> "Name: " + p.getName() + ", Age: " + p.getAge() + ", City: " + p.getCity());


    }
    /*
    Bez uzycia struktur danych typu kolekcje, tablice, mapy czy zapisywania do pliku, nalezy stworzyc klase ObjectContainer w taki sposob aby wykonal
sie ponizszy kod: (przyklad dla klasy Person (name, city, age) - ale ma dzialac dla dowolnej klasy)
ObjectContainer<Person> peopleFromWarsaw = new ObjectContainer(p -> p.getCity().equals("Warsaw"));//tu w konstruktorze podajemy warunek do dodawania osoby do kontenera.
peopleFromWarsaw.add(new Person("Jan", "Warsaw", 30)); // powinno byc ok, Jan jest z warszawy
peopleFromWarsaw.add(new Person("Weronika","Warsaw", 20)); // powinno byc tez okej, Weronika jest z warszawy
peopleFromWarsaw.add(new Person("Waldek", "Monaco", 34));// no waldka niedoda, jest z Monaco, wiec tu powinno albo rzucic wyjatkiem, albo metoda add powinna zwrocic po prostu false - co wybierzesz to twoja decyzja.
//do tego ponizej mozesz juz stosowac liste, no bo masz zwrocic liste:)
List<Person> females = peopleFromWarsaw.getWithFilter(p -> p.getName().endsWith("a")); // zwraca nam wszystkie osoby spelniajace dany warunek.
peopleFromWarsaw.removeIf(p -> p.getAge() > 50); // powinno nam usuwac ludzi spelniajacy dany warunek w nawiasie.
//tu naturalnie mozesz stosowac zapis do pliku bo wymaga tego polecenie
peopleFromWarsaw.storeToFile("youngPeopleFromWarsaw.txt", p -> p.getAge() < 30, p -> p.getName()+";"+p.getAge()+";"+p.getCity());
//metoda powinna zapisac obiekty do pliku z pierwszego argumenty metody, tylko te co spelniaja drugi warunek metody, w formacie z trzeciego warunku metody.



     */


}
