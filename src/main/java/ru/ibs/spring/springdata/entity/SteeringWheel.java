package ru.ibs.spring.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SteeringWheel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    String type;

    @OneToOne(mappedBy = "steeringWheel")
    @JsonBackReference
    private Car car;

    public SteeringWheel(String type) {
        this.type = type;
    }
}
