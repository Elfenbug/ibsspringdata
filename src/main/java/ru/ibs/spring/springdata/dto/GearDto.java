package ru.ibs.spring.springdata.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import ru.ibs.spring.springdata.entity.Engine;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "gearSize",
        "engine"
})
public class GearDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("gearSize")
    private Integer gearSize;
    @JsonProperty("engine")
    private Engine engine;
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

    @JsonProperty("gearSize")
    public Integer getGearSize() {
        return gearSize;
    }

    @JsonProperty("gearSize")
    public void setGearSize(Integer gearSize) {
        this.gearSize = gearSize;
    }

    @JsonProperty("engine")
    public Engine getEngine() {
        return engine;
    }

    @JsonProperty("engine")
    public void setEngine(Engine engine) {
        this.engine = engine;
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
