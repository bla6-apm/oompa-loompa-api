package com.bla6.model.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

// Lombok's toString can be used instead of Guava MoreObjects
//@ToString
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class NewOompaLoompa implements Serializable {

    private static final long serialVersionUID = 6474833451408021412L;

    @JsonIgnore
    private String id;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("age")
    @NotNull
    private Integer age;

    @JsonProperty("job")
    @NotNull
    private String job;

    @JsonProperty("height")
    private String height;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("description")
    private String description;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(NewOompaLoompa.class).omitNullValues()
                .add("name", name)
                .add("age", age)
                .add("job", job)
                .add("height", height)
                .add("weight", weight)
                .add("description", description)
                .toString();
    }
}
