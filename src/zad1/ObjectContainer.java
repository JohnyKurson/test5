package zad1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ObjectContainer<T> {
    private final List<T> objects;
    private final Predicate<T> condition;

    public ObjectContainer(Predicate<T> condition) {
        this.objects = new ArrayList<>();
        this.condition = condition;
    }
    public boolean add(T object) {
        if (condition.test(object)) {
            return objects.add(object);
        } else {
            return false;
        }
    }

    public List<T> getWithFilter(Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T object : objects) {
            if (filter.test(object)) {
                result.add(object);
            }
        }
        return result;
    }

    public boolean removeIf(Predicate<T> filter) {
        return objects.removeIf(filter);
    }

    public void storeToFile(String fileName, Predicate<T> filter, ObjectFormatter<T> formatter) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T object : objects) {
                if (filter.test(object)) {
                    String line = formatter.format(object);
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }

    public List<T> getObjects() {
        return new ArrayList<>(objects);
    }

}



