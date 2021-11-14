package ru.ibs.spring.springdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="manufacturerName")
    private String manufacturerName;

    @Column(name="modelName")
    private String modelName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="engine_id")
    @JsonManagedReference
    private Engine engine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "steering_wheel_id")
    @JsonManagedReference
    private SteeringWheel steeringWheel;

    public Car(String manufacturerName, String modelName) {
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
    }

//    public String toString() {
//        return String.join(" ", manufacturerName, modelName);
//    }
}
