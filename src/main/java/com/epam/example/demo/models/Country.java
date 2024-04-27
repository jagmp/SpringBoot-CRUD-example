package com.epam.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Country")
public class Country implements Serializable {

    @Id
    @SequenceGenerator(sequenceName = "SEQ_Country", name = "sequence_country", initialValue = 6, allocationSize = 1)
    @GeneratedValue(generator = "sequence_country", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
}