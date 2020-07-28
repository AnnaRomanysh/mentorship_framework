package com.epam.mentorship.core.models;

import com.epam.mentorship.core.enums.Gender;
import com.epam.mentorship.core.enums.State;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter @Builder
public class User {

    int id;
    Gender gender;
    String firstName;
    String lastName;
    String email;
    String password;
    LocalDate dateOfBirth;
    String company;
    String address;
    String getAddress2;
    String city;
    State state;
    int zip;
    String country;
    long homePhone;
    long mobilePhone;

    public User(){

    }

    public User(int id, Gender gender, String firstName, String lastName, String email, String password, LocalDate dateOfBirth, String company, String address, String getAddress2, String city, State state, int zip, String country, long homePhone, long mobilePhone) {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.company = company;
        this.address = address;
        this.getAddress2 = getAddress2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                firstName.equals(user.firstName) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gender=" + gender +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", getAddress2='" + getAddress2 + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", zip=" + zip +
                ", country='" + country + '\'' +
                ", homePhone=" + homePhone +
                ", mobilePhone=" + mobilePhone +
                '}';
    }
}
