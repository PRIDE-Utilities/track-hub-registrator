package uk.ac.ebi.pride.utilities.trackhub.registry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

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
 * Created by ypriverol (ypriverol@gmail.com) on 28/07/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostTrackHub {


    @JsonProperty("url")
    String url;

    @JsonProperty("type")
    TrackType type;

    @JsonProperty("assembly")
    Map<String, String> assemblies;

    @JsonProperty("public")
    SearchType visbility;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TrackType getType() {
        return type;
    }

    public void setType(TrackType type) {
        this.type = type;
    }

    public Map<String, String> getAssemblies() {
        return assemblies;
    }

    public void setAssemblies(Map<String, String> assemblies) {
        this.assemblies = assemblies;
    }

    public SearchType getVisbility() {
        return visbility;
    }

    public void setVisbility(SearchType visbility) {
        this.visbility = visbility;
    }
}
