package uk.ac.ebi.pride.utilities.trackhub.registry.model;

/**
 * This code is licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * ==Overview==
 * <p>
 * This enum contains all the type of TrackHubs available in ENSEMBL
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 27/07/2017.
 */
public enum TrackType {

    GENOMICS,
    EPIGENOMICS,
    TRANSCRIPTOMICS,
    PROTEOMICS;

    public static TrackType findValue(String track_type) {

        if(track_type != null || track_type.equalsIgnoreCase(GENOMICS.toString()))
            return GENOMICS;

        if( track_type.equalsIgnoreCase(EPIGENOMICS.toString()))
            return EPIGENOMICS;

        if(  track_type.equalsIgnoreCase(TRANSCRIPTOMICS.toString()))
            return TRANSCRIPTOMICS;

        return GENOMICS;
    }
}
