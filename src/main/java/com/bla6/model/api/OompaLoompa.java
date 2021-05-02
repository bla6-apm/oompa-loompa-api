package com.bla6.model.api;

import com.bla6.model.entity.OompaLoompaEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Lombok's toString can be used instead of Guava MoreObjects
//@ToString
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OompaLoompa implements Serializable {

    private static final long serialVersionUID = 6474833451408021412L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("job")
    private String job;

    @JsonProperty("height")
    private String height;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("description")
    private String description;

    public OompaLoompa(OompaLoompaEntity oompaLoompaEntity) {
        if (oompaLoompaEntity.getId() != null)
            this.id = oompaLoompaEntity.getId();
        this.name = oompaLoompaEntity.getName();
        this.age = oompaLoompaEntity.getAge();
        this.job = oompaLoompaEntity.getJob();

        if (oompaLoompaEntity.getHeight() != null)
            this.height = oompaLoompaEntity.getHeight();
        if (oompaLoompaEntity.getWeight() != null)
            this.weight = oompaLoompaEntity.getWeight();
        if (oompaLoompaEntity.getDescription() != null)
            this.description = oompaLoompaEntity.getDescription();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(OompaLoompa.class).omitNullValues()
                .add("name", name)
                .add("age", age)
                .add("job", job)
                .add("height", height)
                .add("weight", weight)
                .add("description", description)
                .toString();
    }
}
