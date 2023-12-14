package MoEzwawi.entities;

import MoEzwawi.entities.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="people")
public class Person {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String email;
    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "person")
    private List<Participation> listOfParticipations;

    public Person() {
    }
    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String surname, String email, LocalDate dateOfBirth, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Participation> getListOfParticipations() {
        return listOfParticipations;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
