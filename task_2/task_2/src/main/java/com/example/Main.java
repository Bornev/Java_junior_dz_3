package com.example;

public class Main {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();

        // Добавление
        Person person1 = new Person("Иван", 30);
        Person person2 = new Person("Мария", 25);
        repository.addPerson(person1);
        repository.addPerson(person2);

        // Обновление
        person1.setName("Иван Иванович");
        repository.updatePerson(person1);

        // Удаление
        repository.deletePerson(person2.getId());

        // Закрытие ресурсов
        repository.close();

        System.out.println("Добавлено: " + person1);
        System.out.println("Добавлено: " + person2);
        System.out.println("Обновлено: " + person1);
        System.out.println("Удалено: " + person2);

    }
    
}