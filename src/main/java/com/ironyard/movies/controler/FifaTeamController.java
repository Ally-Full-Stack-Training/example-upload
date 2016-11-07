package com.ironyard.movies.controler;

import com.ironyard.movies.data.Movie;
import com.ironyard.movies.dto.FifaTeam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jasonskipper on 10/26/16.
 */
@RestController
public class FifaTeamController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/service/fifateams", method = RequestMethod.GET)
    public Iterable<FifaTeam> list(@RequestParam(value = "filter", required = false)String filter){
        log.debug("Request to list teams started.");
        RestTemplate restTemplate = new RestTemplate();
        FifaTeam[] teams = restTemplate.getForObject("http://worldcup.sfg.io/teams/", FifaTeam[].class);
        log.info(teams.toString());
        log.debug("Fectch team complete.");
        List<FifaTeam> foundAllList = Arrays.asList(teams);
        List<FifaTeam> filteredList = new ArrayList<>();

        // only return teams that start with parameter name
        if(filter != null){
            // filter the list
            for(FifaTeam aTeam: foundAllList){
                if(aTeam.getCountry().startsWith(filter)){
                    filteredList.add(aTeam);
                }
            }
        }else{
            // just return all
            filteredList = foundAllList;
        }
        return filteredList;
    }

}
