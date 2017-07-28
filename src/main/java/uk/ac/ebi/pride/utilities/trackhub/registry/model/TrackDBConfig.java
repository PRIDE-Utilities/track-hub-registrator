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
public class TrackDBConfig {

    @JsonProperty("owner")
    String owner;

    @JsonProperty("source")
    TrackSource source;

    @JsonProperty("hub")
    TrackHub trackhub;

    @JsonProperty("species")
    Species species;

    @JsonProperty("assembly")
    Assembly assembly;

    @JsonProperty("configuration")
    Configuration configuration;

    public TrackDBConfig(String owner, TrackSource source, TrackHub trackhub, Species species, Assembly assembly, Configuration configuration) {
        this.owner = owner;
        this.source = source;
        this.trackhub = trackhub;
        this.species = species;
        this.assembly = assembly;
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "TrackDBConfig{" +
                "owner='" + owner + '\'' +
                ", source=" + source +
                ", trackhub=" + trackhub +
                ", species=" + species +
                ", assembly=" + assembly +
                ", configuration=" + configuration +
                '}';
    }
}
