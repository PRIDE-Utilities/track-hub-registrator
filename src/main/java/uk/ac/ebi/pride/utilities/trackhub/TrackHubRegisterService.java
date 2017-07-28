package uk.ac.ebi.pride.utilities.trackhub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.Assembly;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.SearchType;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.TrackType;

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
 * This class register a trackhub into ensembl using the corresponding URL and
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 27/07/2017.
 */
public class TrackHubRegisterService {

    public static final Logger logger = LoggerFactory.getLogger(TrackHubRegisterService.class);

    private String authToken;
    private String url;
    private TrackType postType;
    private SearchType searchType;
    private List<Assembly> assemblies;



    /**
     * Constructor with all the necessary parameters.
     * @param url The URL of the trackhub, HTTP preferred over FTP.
     * @param postType The -omics type of the track hub.
     * @param searchType Should the track hub be visible in Registry search results or not.
     * @param assemblies The assemblies present on the track hub.
     */
    public TrackHubRegisterService(String url, TrackType postType, SearchType searchType,
                                   List<Assembly> assemblies) {
        this.url = url;
        this.postType = postType;
        this.searchType = searchType;
        this.assemblies = assemblies;
    }

//    /**
//     * This method logs into the Registry using the supplied credentials. Generates auth token.
//     *
//     * @throws IOException Exception when reading/writing JSON to Registry.
//     * @throws JSONException Exception when reading/writing JSON to Registry.
//     * @throws HttpException Exception when reading/writing JSON to Registry.
//     */
//    public void login() throws IOException, JSONException, HttpException {
//        System.setProperty("jsse.enableSNIExtension", "false");
//        logger.info("Attempting to log into the registry.");
//        CredentialsProvider credsProvider = new BasicCredentialsProvider();
//        credsProvider.setCredentials(
//                new AuthScope(server.replaceFirst("https://", ""), AuthScope.ANY_PORT),
//                new UsernamePasswordCredentials(user, password));
//        try (CloseableHttpClient httpclient = HttpClients.custom()
//                .setDefaultCredentialsProvider(credsProvider)
//                .build()) {
//            HttpGet httpget = new HttpGet(server + "/api/login");
//            logger.info("Executing request " + httpget.getRequestLine());
//            CloseableHttpResponse response = httpclient.execute(httpget);
//            HttpEntity entity = response.getEntity();
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                try (InputStream inputStream = entity.getContent()) {
//                    StringWriter writer = new StringWriter();
//                    IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8);
//                    JSONObject myObject = new JSONObject(writer.toString());
//                    myObject.get("auth_token");
//                    this.authToken = myObject.getString("auth_token");
//                    logger.info("Successfully obtained auth token.");
//                }
//            } else {
//                logger.error("Error when logging in, status code: " + response.getStatusLine().getStatusCode());
//                logger.error("Reason: " + response.getStatusLine().getReasonPhrase());
//                throw new HttpException(response.getStatusLine().getReasonPhrase());
//            }
//
//        }
//    }

    /**
     * This method logs out of the Registry, using the auth token generated after Login().
     * @throws IOException Exception when reading/writing JSON to Registry.
     * @throws HttpException Exception when reading/writing JSON to Registry.
     */
    /*public void logout() throws IOException, HttpException {
        logger.info("Attempting to log out");
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            HttpGet httpget = new HttpGet(server + "/api/logout");
            httpget.setHeader("user", user);
            httpget.setHeader("Auth-Token", authToken);
            CloseableHttpResponse response = httpclient.execute(httpget);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                logger.info("Successfully logged out.");
            } else {
                logger.error("Error when logging out, status code: " + response.getStatusLine().getStatusCode());
                logger.error("Reason: " + response.getStatusLine().getReasonPhrase());
                throw new HttpException(response.getStatusLine().getReasonPhrase());
            }
        }
    }*/

    /**
     * This method posts the trackh hub to the Registry, using the auth token generated after Login().
     * @throws IOException Exception when reading/writing JSON to Registry.
     * @throws JSONException Exception when reading/writing JSON to Registry.
     * @throws HttpException Exception when reading/writing JSON to Registry.
     */
    /*public void postTrackhub() throws IOException, JSONException, HttpException {
        logger.info("Attempting to post track hub.");
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build()) {
            HttpPost httppost = new HttpPost(server + "/api/trackhub");
            httppost.setHeader("User", user);
            httppost.setHeader("Auth-Token", authToken);
            JSONObject json = new JSONObject();
            json.put("url", url);
            json.put("type", postType);
            json.put("public", searchType.getValue());
            JSONObject jsonAssemblies = new JSONObject();
            if (assemblies.size()>0) {
                assemblies.forEach(assembly -> {
                    try {
                        jsonAssemblies.put(assembly.name(), assembly.getINSDC());
                    } catch (JSONException e) {
                        logger.error("Problem when adding assemblies. " + e);
                    }
                });
                json.put("assembliesNames", jsonAssemblies);
            } else {
                logger.error("Unable to read assemblies.");
            }
            StringEntity stringEntity = new StringEntity(json.toString());
            stringEntity.setContentType("application/json");
            httppost.setEntity(stringEntity);
            Arrays.stream(httppost.getAllHeaders()).forEach(header -> logger.info( header.getName() + " : " + header.getValue()));
            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_CREATED) {
                logger.info("Successfully posted track hub to registry.");
                logger.debug("ReasonPhrase: " + response.getStatusLine().getReasonPhrase());
                logger.debug("Content: " + IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8));  // direct link to Genome Browser
            } else {
                logger.error("Error when posting track hub to registry, status code: " + response.getStatusLine().getStatusCode());
                logger.error("ReasonPhrase: " + response.getStatusLine().getReasonPhrase());
                logger.error("Content: " + IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8));
                throw new HttpException(response.getStatusLine().getReasonPhrase());
            }
        }
    }
*/

}
