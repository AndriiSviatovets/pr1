package pr1.pr1;

import java.util.UUID;

public class Student {
    private String id; // Унікальний ідентифікатор
    private String name;
    private int age;
    private String email;

    public Student() {
        this.id = UUID.randomUUID().toString(); // Автоматична генерація ID
    }

    public Student(String name, int age, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}