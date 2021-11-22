package com.godcodes.SpringApplicationGradle.models;

import com.godcodes.SpringApplicationGradle.SpringApplicationGradleApplication;
import com.google.gson.Gson;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(
        indexes = {
                @Index(columnList = "email", unique = true),
        },
        uniqueConstraints = {@UniqueConstraint(columnNames = {"firstname", "lastname"})}
)
public class Member extends Model<Member> {

    public enum Gender {MALE, FEMALE}

    String firstname;
    String lastname;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Column(unique = true)
    String phone;
    @Column(unique = true)
    String email;
    LocalDate dob;
    String address;

    @Transient
    private int age;

    public Member() {
    }

//    public Member(Long id, String firstname, String lastname, Gender gender, String phone, String email, LocalDate dob, String address) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.gender = gender;
//        this.phone = phone;
//        this.email = email;
//        this.dob = dob;
//        this.address = address;
//    }

    public Member(String firstname, String lastname, Gender gender, String phone, String email, LocalDate dob, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.address = address;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return super.getId();
    }

    public void setId(Long id) {
        super.setId(id);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + getId() +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
