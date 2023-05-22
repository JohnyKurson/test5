package zad1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ObjectContainer<T> {
    private Node<T> head;
    private final Predicate<T> condition;

    public ObjectContainer(Predicate<T> condition) {
        this.condition = condition;
    }

    public boolean add(T object) {
        if (object == null){
            throw new NullPointerException("Objekt nie może być nullem");
        }
        if (condition.test(object)) {
            Node<T> newNode = new Node<>(object);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
            return true;
        } else {
            return false;
        }
    }

    public void removeIf(Predicate<T> filter) {
        Node<T> prev = null;
        Node<T> current = head;
        while (current != null) {
            if (filter.test(current.getObject())) {
                if (prev == null) {
                    head = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
            } else {
                prev = current;
            }
            current = current.getNext();
        }
    }

    public List<T> getWithFilter(Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            if (filter.test(current.getObject())) {
                result.add(current.getObject());
            }
            current = current.getNext();
        }
        return result;
    }

    public void storeToFile(String fileName, Predicate<T> filter, ObjectFormatter<T> formatter) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            Node<T> current = head;
            while (current != null) {
                if (filter.test(current.getObject())) {
                    String line = formatter.format(current.getObject());
                    writer.println(line);
                }
                current = current.getNext();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Błąd podczas zapisu do pliku: " + fileName, e);
        }
    }

    public List<T> getObjects() {
        List<T> result = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            result.add(current.getObject());
            current = current.getNext();
        }
        return result;
    }


    private static class Node<T> {
        private T object;
        private Node<T> next;

        public Node(T object) {
            this.object = object;
        }

        public T getObject() {
            return object;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}



