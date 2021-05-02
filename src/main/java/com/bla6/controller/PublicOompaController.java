package com.bla6.controller;

import com.bla6.error.OompaError;
import com.bla6.model.api.NewOompaLoompa;
import com.bla6.model.api.OompaLoompa;
import com.bla6.model.entity.OompaLoompaEntity;
import com.bla6.service.OompaLoompaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/public")
public class PublicOompaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicOompaController.class.getName());

    @Autowired
    private OompaLoompaService oompaLoompaService;


    @GetMapping(value = "/v1/oompas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllOompaLoompa() {
        LOGGER.info("START - getAllOompaLoompa()");

        final List<OompaLoompaEntity> oompaList = oompaLoompaService.getOompaLoompaList();

        final List<OompaLoompa> response = oompaList.stream().map(OompaLoompa::new).collect(Collectors.toList());

        if (response.isEmpty()) {
            LOGGER.info("END - getAllOompaLoompa() - {}", HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        LOGGER.info("END - getAllOompaLoompa() - {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/oompas/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllOompaLoompaDetailed() {
        LOGGER.info("START - getAllOompaLoompa()");

        final List<OompaLoompaEntity> oompaList = oompaLoompaService.getOompaLoompaDetailList();

        final List<OompaLoompa> response = oompaList.stream().map(OompaLoompa::new).collect(Collectors.toList());

        if (response.isEmpty()) {
            LOGGER.info("END - getAllOompaLoompa() - {}", HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        LOGGER.info("END - getAllOompaLoompa() - {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/oompas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getOompaLoompa(@PathVariable("id") final String id) {
        LOGGER.info("START - getOompaLoompa() - {}", id);

        OompaLoompaEntity response;

        try {
            response = oompaLoompaService.getOompaLoompa(id);
        } catch (OompaError e) {
            LOGGER.info("END - getOompaLoompa() - {} - id={}", HttpStatus.NO_CONTENT, id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        LOGGER.info("END - getOompaLoompa() - {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/oompas", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewOompaLoompa(@Valid @RequestBody final NewOompaLoompa newOompaLoompa) {
        LOGGER.info("START - addNewOompaLoompa() - {}", newOompaLoompa);

        oompaLoompaService.saveOompaLoompa(newOompaLoompa);

        LOGGER.info("END - addNewOompaLoompa()");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Endpoint to update an existing OompaLoompa
     *
     * @param id of the OompaLoompa
     * @param oompaLoompaList
     * @return
     */
    @PutMapping(value = "/v1/oompas/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateOompaLoompa(@PathVariable("id") @NonNull final String id,
                                               @Valid @RequestBody final OompaLoompa oompaLoompaList)
    {
        LOGGER.info("START - updateOompaLoompa() - id={}, newOompaLoompa={}", id, oompaLoompaList);

        try {
            OompaLoompaEntity response = oompaLoompaService.updateOompaLoompa(oompaLoompaList);
            LOGGER.info("updateOompaLoompa() - Updated={}", response.toString());
        } catch (OompaError e) {
            LOGGER.info("END - updateOompaLoompa() - [error={}, status={}, id={}, oompaLoompa={}]",
                    e, HttpStatus.NO_CONTENT, id, oompaLoompaList);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        LOGGER.info("END - updateOompaLoompa()");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
