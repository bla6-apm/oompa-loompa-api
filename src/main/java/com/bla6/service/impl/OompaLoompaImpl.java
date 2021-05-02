package com.bla6.service.impl;

import com.bla6.error.OompaError;
import com.bla6.model.api.NewOompaLoompa;
import com.bla6.model.api.OompaLoompa;
import com.bla6.model.entity.OompaLoompaEntity;
import com.bla6.model.repository.OompaLoompaRepository;
import com.bla6.service.OompaLoompaService;
import com.bla6.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OompaLoompaImpl implements OompaLoompaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OompaLoompaImpl.class.getName());

    @Autowired
    private OompaLoompaRepository oompaLoompaRepository;

    @Override
    public List<OompaLoompaEntity> getOompaLoompaList() {
        return oompaLoompaRepository.getOompaData();
    }

    @Override
    public List<OompaLoompaEntity> getOompaLoompaDetailList() {
        return oompaLoompaRepository.findAll();
    }

    @Override
    public OompaLoompaEntity getOompaLoompa(final String id) throws OompaError {
        Optional<OompaLoompaEntity> optionalData = oompaLoompaRepository.findById(id);
        if (!optionalData.isPresent())
            throw new OompaError(HttpStatus.NOT_FOUND, Constants.OOMPA_ERROR_NOT_FOUND);

        return optionalData.get();
    }

    @Override
    public OompaLoompaEntity getOompaLoompaByName(final String name) {
        return oompaLoompaRepository.findByOompaName(name);
    }

    @Override
    public void saveOompaLoompa(final NewOompaLoompa newOompaLoompa) {
        final OompaLoompaEntity newOompa = new OompaLoompaEntity(newOompaLoompa);
        oompaLoompaRepository.save(newOompa);
    }

    @Override
    public OompaLoompaEntity updateOompaLoompa(OompaLoompa oompaLoompa) throws OompaError {
        final OompaLoompaEntity input = new OompaLoompaEntity(oompaLoompa);

        try {
            oompaLoompaRepository.save(input);
        } catch (Exception e) {
            LOGGER.info("updateOompaLoompa() - something went wrong during updated [error={}, message={}]",
                    e.getMessage(), Constants.OOMPA_ERROR_NOT_FOUND);
            throw new OompaError(HttpStatus.NOT_FOUND, Constants.OOMPA_ERROR_NOT_FOUND);
        }

        return oompaLoompaRepository.save(input);
    }


}
