import java.io.Serializable;

class Person implements Serializable {
    private String name;
    private int age;

    // Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Переопределение toString для удобного вывода
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}
