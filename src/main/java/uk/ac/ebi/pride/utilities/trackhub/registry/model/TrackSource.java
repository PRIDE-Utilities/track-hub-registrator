package uk.ac.ebi.pride.utilities.trackhub.registry.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
public class TrackSource {

    @JsonProperty("checksum")
    String checksum;

    @JsonProperty("url")
    String url;

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TrackSource{" +
                "checksum='" + checksum + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
