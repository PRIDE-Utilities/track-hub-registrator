package uk.ac.ebi.pride.utilities.trackhub;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uk.ac.ebi.pride.utilities.trackhub.options.TrackHubOptions;
import uk.ac.ebi.pride.utilities.trackhub.registry.TrackHubRegistryClient;
import uk.ac.ebi.pride.utilities.trackhub.registry.TrackHubRegistryProd;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.PostTrackHub;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.SearchType;
import uk.ac.ebi.pride.utilities.trackhub.registry.model.TrackType;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
 * This class register a trackhub into ensembl using the corresponding URL and
 * <p>
 * Created by ypriverol (ypriverol@gmail.com) on 27/07/2017.
 */
public class TrackHubRegisterService {

    public static final Logger logger = LoggerFactory.getLogger(TrackHubRegisterService.class);


    public static void main(String[] args){

        TrackHubOptions options = new TrackHubOptions();
        CommandLineParser parser = new DefaultParser();

        PostTrackHub track = null;
        TrackHubRegistryClient client;
        String user = null;
        String password = null;


        try {

            CommandLine cmd = parser.parse(options, args);

            if(cmd.hasOption(TrackHubOptions.TrackHubOption.USER.getCmd()))
                user = cmd.getOptionValue(TrackHubOptions.TrackHubOption.USER.getCmd());

            if(cmd.hasOption(TrackHubOptions.TrackHubOption.PASSWORD.getCmd()))
                password = cmd.getOptionValue(TrackHubOptions.TrackHubOption.PASSWORD.getCmd());



            if(cmd.hasOption(TrackHubOptions.TrackHubOption.FILE_INPUT.getCmd())){
                String inputName = cmd.getOptionValue(TrackHubOptions.TrackHubOption.FILE_INPUT.getCmd());
                track = readParameters(inputName);

            }else if(cmd.hasOption(TrackHubOptions.TrackHubOption.URL.getCmd())){
                String url = cmd.getOptionValue(TrackHubOptions.TrackHubOption.URL.getCmd());

                String[] assembly = null;
                if(cmd.hasOption(TrackHubOptions.TrackHubOption.ASSEMBLY.getCmd()))
                    assembly = cmd.getOptionValues(TrackHubOptions.TrackHubOption.ASSEMBLY.getCmd());

                String visibility = null;
                if(cmd.hasOption(TrackHubOptions.TrackHubOption.VISIBILITY.getCmd()))
                    visibility = cmd.getOptionValue(TrackHubOptions.TrackHubOption.VISIBILITY.getCmd());

                String track_type = null;
                if(cmd.hasOption(TrackHubOptions.TrackHubOption.TRACK_TYPE.getCmd()))
                    track_type = cmd.getOptionValue(TrackHubOptions.TrackHubOption.TRACK_TYPE.getCmd());

                track = parseTrackHub(url, assembly, visibility, track_type);

            }else{
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp( "ant", options );
            }

            if(track != null){
                ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
                TrackHubRegistryProd trackHubWsProd = (TrackHubRegistryProd) ctx.getBean("trackHubRegistryProd");

                if(user != null)
                    trackHubWsProd.setUser(user);
                if(password != null)
                    trackHubWsProd.setPassword(password);

                client = new TrackHubRegistryClient(trackHubWsProd);
                boolean status = client.updateTrackHub(track);
                if(status)
                    logger.info("The TrackHub has been added to the registry.");
            }


        } catch (ParseException | IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private static PostTrackHub parseTrackHub(String url, String[] assembly, String visibility, String track_type) {
        PostTrackHub track = new PostTrackHub();
        if(url != null)
            track.setUrl(url);
        if(visibility.equalsIgnoreCase("PUBLIC") || visibility.equalsIgnoreCase("PRIVATE"))
            track.setVisbility(SearchType.findStringValue(visibility));
        else
            track.setVisbility(SearchType.findIntValue(new Integer(visibility)));
        track.setType(TrackType.findValue(track_type));

        Map<String, String> assemblies = new HashMap<>();
        if(assembly != null && assembly.length > 0 ){
            for(String assemblyEntry: assembly)
                if(assemblyEntry.split("=").length == 2)
                    assemblies.put(assemblyEntry.split("=")[0], assemblyEntry.split("=")[1]);
        }
        track.setAssemblies(assemblies);
        return track;

    }

    private static PostTrackHub readParameters(String inputName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return ((PostTrackHub)objectMapper.readValue(new File(inputName), PostTrackHub.class));
    }


}
