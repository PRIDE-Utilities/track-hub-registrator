package uk.ac.ebi.pride.utilities.trackhub.registry;

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
public class TrackHubRegistryProd {

    private String hostName;

    private String protocol;

    private String user;

    private String password;

    public TrackHubRegistryProd(String hostName, String protocol, String user, String password) {
        this.hostName = hostName;
        this.protocol = protocol;
        this.user = user;
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TrackHubRegistryProd{" +
                "hostName='" + hostName + '\'' +
                ", protocol='" + protocol + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
