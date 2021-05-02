package com.bla6.model.entity;

import com.bla6.model.api.NewOompaLoompa;
import com.bla6.model.api.OompaLoompa;
import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


// Lombok's toString can be used instead of Guava MoreObjects
//@ToString
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oompa_loompa")
public class OompaLoompaEntity implements Serializable {

    private static final long serialVersionUID = 2170812355943439297L;

    @Id
    @Column(name = "id", length = 1024, updatable = false)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "job")
    private String job;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "description")
    private String description;

    public OompaLoompaEntity(NewOompaLoompa newOompaLoompa) {
        this.name = newOompaLoompa.getName();
        this.age = newOompaLoompa.getAge();
        this.job = newOompaLoompa.getJob();
        this.height = newOompaLoompa.getHeight();
        this.weight = newOompaLoompa.getWeight();
        this.description = newOompaLoompa.getDescription();
    }

    public OompaLoompaEntity(OompaLoompa oompaLoompa) {
        this.id = oompaLoompa.getId();
        this.name = oompaLoompa.getName();
        this.age = oompaLoompa.getAge();
        this.job = oompaLoompa.getJob();
        this.height = oompaLoompa.getHeight();
        this.weight = oompaLoompa.getWeight();
        this.description = oompaLoompa.getDescription();
    }

    /**
     * For non detailed object
     * @param id
     * @param name
     * @param age
     * @param job
     */
    public OompaLoompaEntity(final String id, final String name, final Integer age, final String job, final String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    /**
     * For non detailed object
     * @param id
     * @param name
     * @param age
     * @param job
     */
    public OompaLoompaEntity(final String id, final String name, final Integer age, final String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(OompaLoompaEntity.class).omitNullValues()
                .add("id", id)
                .add("name", name)
                .add("age", age)
                .add("job", job)
                .add("height", height)
                .add("weight", weight)
                .add("description", description)
                .toString();
    }
}
