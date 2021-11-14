package ru.ibs.spring.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Manual {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "engine_manual"
            , joinColumns = @JoinColumn(name = "manuals_id")
            , inverseJoinColumns = @JoinColumn(name = "engines_id"))
    @JsonIgnore
    //@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
    private List<Engine> engines;

    public Manual(String type) {
        this.type = type;
        this.engines = new ArrayList<>();
    }
}
