import java.io.*;

// Класс Person


public class Main {
    // Метод для сериализации объекта Person в файл
    public static void serializePerson(Person person, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(person);
            System.out.println("Объект успешно сериализован в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка сериализации: " + e.getMessage());
        }
    }

    // Метод для десериализации объекта Person из файла
    public static Person deserializePerson(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Person) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка десериализации: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Создаем объект Person
        Person person = new Person("Иван", 30);

        // Имя файла для хранения объекта
        String fileName = "person.ser";

        // Сериализация объекта
        serializePerson(person, fileName);

        // Десериализация объекта
        Person deserializedPerson = deserializePerson(fileName);

        // Вывод результата десериализации
        if (deserializedPerson != null) {
            System.out.println("Десериализованный объект: " + deserializedPerson);
        }
    }
}