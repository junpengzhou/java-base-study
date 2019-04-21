package clone.model;

import java.io.Serializable;

/**
 * <p>Description: </p>
 *
 * @author Junpengzhou
 * @version 1.0.0
 * @since 2019.04.21 11:36
 */
public class Person implements Cloneable, Serializable {
    private String name;
    private int age;
    private Email email;

    public Person(String name, int age, Email email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public Person clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }
}
