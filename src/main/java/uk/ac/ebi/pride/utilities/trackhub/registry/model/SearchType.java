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
 * This class
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 27/07/2017.
 */
public enum SearchType {
    PUBLIC(1),
    PRIVATE(0);

    private final int value;

    SearchType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static SearchType findStringValue(String visibility) {
        if(visibility.equalsIgnoreCase("PUBLIC"))
            return PUBLIC;
        if(visibility.equalsIgnoreCase("PRIVATE"))
            return PRIVATE;
        return PRIVATE;
    }

    public static SearchType findIntValue(int visibility) {
        if(visibility == PUBLIC.value)
            return PUBLIC;
        return PRIVATE;
    }
}
