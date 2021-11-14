package ru.ibs.spring.springdata.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Gear {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="gearSize")
    private int gearSize;

    @ManyToOne
    @JoinColumn(name = "engine_id")
    @JsonIgnore
   // @JsonManagedReference("gear-engine")
    private Engine engine;


    public Gear(int size) {
        this.gearSize = size;
    }

    public String toString() {
        return "Gear for engine " + engine.toString() + " with size " + getGearSize();
    }
}
