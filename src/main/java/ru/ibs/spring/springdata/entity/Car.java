package ru.ibs.spring.springdata.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="manufacturerName")
    private String manufacturerName;

    @Column(name="modelName")
    private String modelName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="engine_id")
    @JsonManagedReference("car-engine")
    private Engine engine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "steering_wheel_id")
    @JsonManagedReference("car-steeringWheel")
    private SteeringWheel steeringWheel;

    public Car(String manufacturerName, String modelName) {
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
    }

//    public String toString() {
//        return String.join(" ", manufacturerName, modelName);
//    }
}
