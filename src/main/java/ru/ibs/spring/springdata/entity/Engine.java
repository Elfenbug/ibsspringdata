package ru.ibs.spring.springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Engine {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "engine", cascade = CascadeType.ALL)
    @JsonBackReference
    private Car car;

    @OneToMany(mappedBy = "engine", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Gear> gears;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "engine_manual"
            , joinColumns = @JoinColumn(name = "engines_id")
            , inverseJoinColumns = @JoinColumn(name = "manuals_id"))
    @JsonBackReference
    private List<Manual> manuals;

    public Engine(String engineType) {
        this.type = engineType;
        this.gears = new LinkedList<>();
        this.manuals = new LinkedList<>();
    }

    public void addGearToEngine(Gear gear) {
        if (gears == null) {
            gears = new ArrayList<>();
        }
        gears.add(gear);
    }

    public String toString() {
        return type;
    }
}
