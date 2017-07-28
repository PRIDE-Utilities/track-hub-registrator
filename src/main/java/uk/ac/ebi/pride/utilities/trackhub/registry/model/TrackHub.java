package uk.ac.ebi.pride.utilities.trackhub.registry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
 * This class
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 28/07/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackHub {

    @JsonProperty("name")
    String name;

    @JsonProperty("shortLabel")
    String shortLabel;

    @JsonProperty("logLabel")
    String longLabel;

    @JsonProperty("url")
    String url;

    @JsonProperty("trackdbs")
    List<TrackDB> trackDBs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortLabel() {
        return shortLabel;
    }

    public void setShortLabel(String shortLabel) {
        this.shortLabel = shortLabel;
    }

    public String getLongLabel() {
        return longLabel;
    }

    public void setLongLabel(String longLabel) {
        this.longLabel = longLabel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TrackDB> getTrackDBs() {
        return trackDBs;
    }

    public void setTrackDBs(List<TrackDB> trackDBs) {
        this.trackDBs = trackDBs;
    }

    @Override
    public String toString() {
        return "TrackHub{" +
                "name='" + name + '\'' +
                ", shortLabel='" + shortLabel + '\'' +
                ", longLabel='" + longLabel + '\'' +
                ", url='" + url + '\'' +
                ", trackDBs=" + trackDBs +
                '}';
    }
}
