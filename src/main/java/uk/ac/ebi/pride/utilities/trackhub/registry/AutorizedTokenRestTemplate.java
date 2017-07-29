package uk.ac.ebi.pride.utilities.trackhub.registry;

import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * This code is licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * ==Overview==
 * <p>
 * This class handle the authorized connection to RestTemplate.
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 28/07/2017.
 */
public class AutorizedTokenRestTemplate extends RestTemplate{

    private String token;
    private String username;
    private HttpHeaders headers;

    public AutorizedTokenRestTemplate(String token, String username){
        this.token = token;
        this.username = username;
        initHeaders();
    }

    public <T> T exchangeGET(String url, Class<T> responseType) throws RestClientException {
        return authorizedRestCall(this, url, responseType);
    }

    public <T> ResponseEntity<T> exchangePOST(String url, Object object, Class<T> responseType) throws  RestClientException{
        return authorizedPOSTRestCall(this, url, object, responseType);
    }

    private <T> ResponseEntity<T> authorizedPOSTRestCall(RestTemplate restTemplate, String url, Object object, Class<T> responseType) {
        HttpEntity<T> httpEntity = new HttpEntity(object, headers);
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseType);
        return response;
    }

    private <T> T authorizedRestCall(RestTemplate restTemplate, String url, Class<T> responseType) {
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), responseType);
        return response.getBody();
    }

    /**
     * Init Rest Headers for all the Query Calls.
     */
    private void initHeaders(){
        this.headers = new HttpHeaders();
        headers.set("Auth-Token", token);
        headers.set("User", username);
    }

}
