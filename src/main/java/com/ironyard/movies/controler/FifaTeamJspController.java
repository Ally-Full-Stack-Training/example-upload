package com.ironyard.movies.controler;

import com.ironyard.movies.dto.FifaTeam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Created by jasonskipper on 10/27/16.
 */
@Controller
public class FifaTeamJspController {


    @RequestMapping(value = "/fifa/teams", method = RequestMethod.GET)
    public String list(@RequestParam(value = "filter", required = false) String filter,
                                   Map<String, Object> model){
        RestTemplate restTemplate = new RestTemplate();
        FifaTeam[] teams = restTemplate.getForObject("http://worldcup.sfg.io/teams/", FifaTeam[].class);
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

        model.put("teams", filteredList);
        return "team_list";
    }

}
