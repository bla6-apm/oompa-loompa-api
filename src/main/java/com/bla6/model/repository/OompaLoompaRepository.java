package com.bla6.model.repository;

import com.bla6.model.entity.OompaLoompaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OompaLoompaRepository extends JpaRepository<OompaLoompaEntity, String>
{
    @Query("SELECT new com.bla6.model.entity.OompaLoompaEntity(o.id, o.name, o.age, o.job) FROM OompaLoompaEntity o")
    List<OompaLoompaEntity> getOompaData();

    @Query("SELECT o FROM OompaLoompaEntity o WHERE o.id=:id")
    OompaLoompaEntity findByOompaId(@Param("id") String id);

    @Query("SELECT o FROM OompaLoompaEntity o WHERE o.name=:name")
    OompaLoompaEntity findByOompaName(@Param("name") String name);
}
