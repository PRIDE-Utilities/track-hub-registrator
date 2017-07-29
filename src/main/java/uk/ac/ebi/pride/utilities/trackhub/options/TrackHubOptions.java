package uk.ac.ebi.pride.utilities.trackhub.options;

import org.apache.commons.cli.Options;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.TrackHub;

/**
 * This code is licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * ==Overview==
 * <p>
 * This class contains the options for the commandline tool.
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 28/07/2017.
 */

public class TrackHubOptions extends Options {

    public enum TrackHubOption{

        URL       ("url"            , "url", "URL of the public TrackHub in (e.g. \n http://ftp.pride.ebi.ac.uk/pride/data/proteogenomics/latest/proteoannotator/trackhub/homo_sapiens/hub.txt)"),
        TRACK_TYPE("track_type"     , "track_type", "Type of track: Proteomics, Genomics, Transcriptomics"),
        VISIBILITY("visibility"     , "visibility", "Visibility of the track, it can be public or private"),
        ASSEMBLY  ("assembly"       , "assembly", "Map of key-value pairs assembly (e.g. -assembly hg38=GCA_000001405.15 ricCom1=GCA_000151685.2)"),
        USER      ("user"           , "user", "User of the ENSEMBL TrackHub Registry"),
        PASSWORD  ("password"       , "password", "Password to access ENSEMBL TrackHub Registry"),
        FILE_INPUT("parameters"     , "parameters", "JSON file input with all the parameters");

        private String name;
        private String cmd;
        private String message;

        TrackHubOption(String name, String cmd, String message) {
            this.name = name;
            this.cmd  = cmd;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCmd() {
            return cmd;
        }

        public void setCmd(String cmd) {
            this.cmd = cmd;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public TrackHubOptions(){
        super();
        addOption(TrackHubOption.URL.getCmd(),true,  TrackHubOption.URL.getMessage());
        addOption(TrackHubOption.TRACK_TYPE.getCmd(),true, TrackHubOption.TRACK_TYPE.getMessage());
        addOption(TrackHubOption.VISIBILITY.getCmd(), true, TrackHubOption.VISIBILITY.getMessage());
        addOption(TrackHubOption.ASSEMBLY.getCmd(), true, TrackHubOption.ASSEMBLY.getMessage());
        addOption(TrackHubOption.FILE_INPUT.getCmd(), true, TrackHubOption.FILE_INPUT.getMessage());
        addOption(TrackHubOption.PASSWORD.getCmd(), true, TrackHubOption.PASSWORD.getMessage());
        addOption(TrackHubOption.USER.getCmd(), true, TrackHubOption.USER.getMessage());
    }



}
