package uk.ac.ebi.pride.utilities.trackhub.registry;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.PostTrackHub;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.SearchType;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.TrackType;

/**
 * This code is licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * ==Overview==
 * <p>
 * This class
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 27/07/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/test-context.xml" })
public class TrackHubRegistryClientTest {

    Logger logger = LoggerFactory.getLogger(TrackHubRegistryClientTest.class);

    @Autowired
    private TrackHubRegistryClient client;

    @Test
    public void getAllTrackHubs() throws Exception {
        Assert.assertTrue(client.getAllTrackHubs().size() > 0 );
    }


    @Test
    public void updateTrackHub() throws Exception {
        boolean updateTrue = client.updateTrackHub( "http://ftp.pride.ebi.ac.uk/pride/data/proteogenomics/latest/proteoannotator/trackhub/homo_sapiens/hub.txt");
        Assert.assertTrue(updateTrue);
    }


    @Test
    public void updateTrackHubNew() throws Exception {
        PostTrackHub trackHub = new PostTrackHub();
        trackHub.setUrl("http://ftp.pride.ebi.ac.uk/pride/data/cluster/trackhubs/2017-09/hub.txt");

        trackHub.setType(TrackType.PROTEOMICS);
        trackHub.setVisbility(SearchType.PRIVATE);

        boolean updateTrue = client.updateTrackHub(trackHub);
        Assert.assertTrue(updateTrue);
    }



    @Ignore
    @Test
    public void createTrackHub() throws Exception {

        PostTrackHub trackHub = new PostTrackHub();
        trackHub.setUrl("http://ftp.pride.ebi.ac.uk/pride/data/proteogenomics/latest/proteoannotator/trackhub/homo_sapiens/hub.txt");

        trackHub.setType(TrackType.PROTEOMICS);
        trackHub.setVisbility(SearchType.PRIVATE);

        boolean updateTrue = client.updateTrackHub(trackHub);
        Assert.assertTrue(updateTrue);

    }

}