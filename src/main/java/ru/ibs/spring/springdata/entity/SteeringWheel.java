package ru.ibs.spring.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SteeringWheel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    String type;

    @OneToOne(mappedBy = "steeringWheel")
    @JsonBackReference("car-steeringWheel")
    private Car car;

    public SteeringWheel(String type) {
        this.type = type;
    }
}
