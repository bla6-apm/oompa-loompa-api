package com.bla6.controller;

import com.bla6.error.OompaError;
import com.bla6.model.api.NewOompaLoompa;
import com.bla6.model.api.OompaLoompa;
import com.bla6.model.entity.OompaLoompaEntity;
import com.bla6.service.OompaLoompaService;
import com.bla6.utils.Utils;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicOompaControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicOompaControllerTest.class.getName());

    @Autowired
    private OompaLoompaService oompaLoompaService;

    @Test
    public void getAllOompaLoompaTest() {
        final NewOompaLoompa newOompaLoompa = NewOompaLoompa.builder()
                .name("adroompa")
                .age(26)
                .job("RRHH")
                .build();
        final List<OompaLoompaEntity> dataList = oompaLoompaService.getOompaLoompaList();

        assertThat(dataList.get(0).getName(), is(newOompaLoompa.getName()));

        assertThat(dataList, not(IsEmptyCollection.empty()));

        LOGGER.info("START - getAllOompaLoompaTest() - {}", dataList);
    }

    @Test
    public void getAllOompaLoompaDetailTest() {
        final List<OompaLoompaEntity> dataList = oompaLoompaService.getOompaLoompaDetailList();

        assertThat(dataList, hasSize(5));

        assertThat(dataList.size(), is(5));

        assertThat(dataList, not(IsEmptyCollection.empty()));
    }

    @Test
    public void getOompaLoompaTest() throws OompaError {

        final String uuid = "be414e09-deff-4c40-8cdb-75e72fe84b09";

        final OompaLoompaEntity data = oompaLoompaService.getOompaLoompa(uuid);

        assertThat(data.getId(), is(uuid));
    }

    @Test
    public void addNewOompaTest(){
        final NewOompaLoompa newOompaLoompa = NewOompaLoompa.builder()
                .name(Utils.generateRandomName() + "oompa")
                .age(Utils.getRandomNumberUsingInts())
                .job(Utils.generateRandomName())
                .height("1.32")
                .weight("0.7")
                .description(Utils.getDescription())
                .build();
        oompaLoompaService.saveOompaLoompa(newOompaLoompa);

        final OompaLoompaEntity oompaPersisted = oompaLoompaService.getOompaLoompaByName(newOompaLoompa.getName());
        assertThat(oompaPersisted.getName(), is(newOompaLoompa.getName()));
    }

    @Test
    public void updateOompaLoompaTest() throws OompaError {
        final List<OompaLoompaEntity> dataList = oompaLoompaService.getOompaLoompaList();

        final OompaLoompa updateOompa = OompaLoompa.builder()
                .id(dataList.get(0).getId())
                .name(Utils.generateRandomName() + "oompa")
                .age(Utils.getRandomNumberUsingInts())
                .job(Utils.generateRandomName())
                .description("from test" + Utils.getRandomNumberUsingInts())
                .build();

        final OompaLoompaEntity updated = oompaLoompaService.updateOompaLoompa(updateOompa);

        assertThat(updated.getAge(), is(updateOompa.getAge()));
    }

}
