package uk.ac.ebi.pride.utilities.trackhub.registry;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.*;

import java.io.PrintStream;
import java.util.List;

/**
 * This code is licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * ==Overview==
 * <p>
 *
 * The ENSEMBL TrackHu Client contains all the methods that are needed to interact with the ENSEMBL TrackHub Registry, including
 * functions to Login, query all registries for an specific user, create a trackHub and Update it.
 *
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 27/07/2017.
 */
public class TrackHubRegistryClient {

    private static final Logger logger = LoggerFactory.getLogger(TrackHubRegistryClient.class);

    private AuthorizedTokenRestTemplate restTemplate;

    private final TrackHubRegistryProd trackHubRegistryProd;

    public TrackHubRegistryClient(TrackHubRegistryProd config) {
        System.setProperty("jsse.enableSNIExtension", "false");
        this.trackHubRegistryProd = config;
        initAutorizedTokenRestTemplate();
    }

    private void initAutorizedTokenRestTemplate() {
        String url = trackHubRegistryProd.getProtocol() + "://" + trackHubRegistryProd.getHostName() + "/api/login";
        RestTemplate passwordRest = new RestTemplate();
        ResponseEntity<Token> response = passwordRest.exchange(url, HttpMethod.GET, new HttpEntity<>(getHeaders()), Token.class);
        String token = response.getBody().getAuth_token();


        logger.debug("INFO | SUCCESS | The Trackhub client has been connected successfully to the ENSMEBL TranckHub service !!!");
        logger.debug(token);

        restTemplate = new AuthorizedTokenRestTemplate(token, trackHubRegistryProd.getUser());
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + getBase64Credentials());
        return headers;
    }

    private String getBase64Credentials(){
        String plainCreds = trackHubRegistryProd.getUser() + ":" + trackHubRegistryProd.getPassword();
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        return new String(base64CredsBytes);
    }

    /**
     * This function retrieve all the trackhubs public in ENSEMBL Trackhub for an specific user.
     * @return List of ENSEMBL TrackHubs.
     */
    public List<TrackHub> getAllTrackHubs(){
        String url = trackHubRegistryProd.getProtocol() + "://" + trackHubRegistryProd.getHostName() + "/api/trackhub";
        List<TrackHub> response = restTemplate.exchangeGET(url, List.class);
        logger.debug("INFO | SUCCESS | Number of TrackHubs: " + response.size());
        return response;
    }

    /**
     * This function publish a trackhub in the ENSEMBL trackHub registry. An example of an url can be found here:
     * http://ftp.pride.ebi.ac.uk/pride/data/proteogenomics/latest/proteoannotator/trackhub/homo_sapiens/hub.txt
     *
     * @param url the url of the public hub.txt
     * @return if the hub has been update successfully, the following command return true.
     */
    public boolean updateTrackHub(String url){
        URL trackURL = new URL(url);
        String urlCall = trackHubRegistryProd.getProtocol() + "://" + trackHubRegistryProd.getHostName() + "/api/trackhub";
        ResponseEntity response = restTemplate.exchangePOST(urlCall, trackURL, List.class);
        logger.debug(response.toString());
        return  response.getStatusCode().value() == 201 && ((List<TrackDBConfig>)response.getBody()).size() == 1;
    }

    /**
     * This method update/create a new TrackHub from a TrackHub Post object that contains the url
     * to the hub.txt, the type of the trackhub, the assemblies, the type of the search type. The
     * @param trackHub PostTrackHub
     * @param outputFile File to output the result of the push to ensembl
     * @return if the trackhub has been added successfully return true.
     */
    public boolean updateTrackHub(PostTrackHub trackHub, PrintStream outputFile){
        String urlCall = trackHubRegistryProd.getProtocol() + "://" + trackHubRegistryProd.getHostName() + "/api/trackhub";
        ResponseEntity response = restTemplate.exchangePOST(urlCall, trackHub, List.class);
        logger.debug(response.toString());
        outputFile.println(response);
        outputFile.flush();
        return  response.getStatusCode().value() == 201 && ((List<TrackDBConfig>)response.getBody()).size() == 1;
    }

    /**
     * This method update/create a new TrackHub from a TrackHub Post object that contains the url
     * to the hub.txt, the type of the trackhub, the assemblies, the type of the search type. The
     * @param trackHub PostTrackHub
     * @return if the trackhub has been added successfully return true.
     */
    public boolean updateTrackHub(PostTrackHub trackHub){
        String urlCall = trackHubRegistryProd.getProtocol() + "://" + trackHubRegistryProd.getHostName() + "/api/trackhub";
        ResponseEntity response = restTemplate.exchangePOST(urlCall, trackHub, List.class);
        logger.debug(response.toString());
        return  response.getStatusCode().value() == 201 && ((List<TrackDBConfig>)response.getBody()).size() == 1;
    }

}
