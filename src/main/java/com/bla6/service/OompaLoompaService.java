package com.bla6.service;

import com.bla6.error.OompaError;
import com.bla6.model.api.NewOompaLoompa;
import com.bla6.model.api.OompaLoompa;
import com.bla6.model.entity.OompaLoompaEntity;

import java.util.List;

public interface OompaLoompaService
{

    List<OompaLoompaEntity> getOompaLoompaList();

    List<OompaLoompaEntity> getOompaLoompaDetailList();

    OompaLoompaEntity getOompaLoompa(final String id) throws OompaError;

    OompaLoompaEntity getOompaLoompaByName(final String name);

    void saveOompaLoompa(NewOompaLoompa newOompaLoompa);

    OompaLoompaEntity updateOompaLoompa(OompaLoompa oompaLoompa) throws OompaError;
}
