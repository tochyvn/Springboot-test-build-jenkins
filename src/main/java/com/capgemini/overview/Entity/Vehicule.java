package com.capgemini.overview.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vehicule")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicule {

    @Id @GeneratedValue
    private Long id;

    @Column
    private String name;
}
