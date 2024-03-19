package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "entities")
public class TechEntity {

    @Id
    @Column(unique = true)
    private String id;
    @Column(unique = true, length = 50)
    private String name;
    @Column(length = 90)
    private String description;

}
