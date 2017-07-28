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
@JsonIgnoreProperties(ignoreUnknown = true
)
public class ConfigurationValue {

    @JsonProperty("priority")
    String priority;

    @JsonProperty("compositeTrack")
    String compositeTrack;

    @JsonProperty("visibility")
    String visibility;

    @JsonProperty("track")
    String rack;

    @JsonProperty("shortLabel")
    String shortLabelConf;

    public ConfigurationValue() {
    }

    public ConfigurationValue(String priority, String compositeTrack, String visibility, String rack, String shortLabelConf) {
        this.priority = priority;
        this.compositeTrack = compositeTrack;
        this.visibility = visibility;
        this.rack = rack;
        this.shortLabelConf = shortLabelConf;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCompositeTrack() {
        return compositeTrack;
    }

    public void setCompositeTrack(String compositeTrack) {
        this.compositeTrack = compositeTrack;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        this.rack = rack;
    }

    public String getShortLabelConf() {
        return shortLabelConf;
    }

    public void setShortLabelConf(String shortLabelConf) {
        this.shortLabelConf = shortLabelConf;
    }

    @Override
    public String toString() {
        return "ConfigurationValue{" +
                "priority='" + priority + '\'' +
                ", compositeTrack='" + compositeTrack + '\'' +
                ", visibility='" + visibility + '\'' +
                ", rack='" + rack + '\'' +
                ", shortLabelConf='" + shortLabelConf + '\'' +
                '}';
    }
}
