package com.anton.uzhva.springsecurity.FirstSecurity.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "person")
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column( name = "username")
    @Size (min = 2, max = 100, message = "Имя не должно быть меньше 2 символов и не больше 100 символов")
    private String userName;

    @NotEmpty
    @Column (name = "password")
    @Size (min=2 ,max = 100, message = "Пароль не должен быть меньше 2 символов и не больше 100 символов" )
    private String password;

    public Person() {
    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
