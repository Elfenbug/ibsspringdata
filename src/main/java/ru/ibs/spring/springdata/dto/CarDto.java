package ru.ibs.spring.springdata.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.ibs.spring.springdata.entity.Engine;
import ru.ibs.spring.springdata.entity.SteeringWheel;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "manufacturerName",
        "modelName",
        "engine",
        "steeringWheel"
})

public class CarDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("manufacturerName")
    private String manufacturerName;
    @JsonProperty("modelName")
    private String modelName;
    @JsonProperty("engine")
    private Engine engine;
    @JsonProperty("steeringWheel")
    private SteeringWheel steeringWheel;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("manufacturerName")
    public String getManufacturerName() {
        return manufacturerName;
    }

    @JsonProperty("manufacturerName")
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @JsonProperty("modelName")
    public String getModelName() {
        return modelName;
    }

    @JsonProperty("modelName")
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @JsonProperty("engine")
    public Engine getEngine() {
        return engine;
    }

    @JsonProperty("engine")
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @JsonProperty("steeringWheel")
    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }

    @JsonProperty("steeringWheel")
    public void setSteeringWheel(SteeringWheel steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}