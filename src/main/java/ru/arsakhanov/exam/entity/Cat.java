package ru.arsakhanov.exam.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "cats")
@Data
public class Cat {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "cat_id")
    private Long catID;

    @Column(name = "cat_name")
    private String catName;

    @Column(name = "age")
    private int age;

}
