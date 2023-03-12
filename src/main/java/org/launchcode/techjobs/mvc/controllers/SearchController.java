package org.launchcode.techjobs.mvc.controllers;

import org.launchcode.techjobs.mvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.launchcode.techjobs.mvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
@PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        if(searchTerm =="all"||(searchTerm=="")){
           ArrayList jobs = JobData.findAll();
            model.addAttribute("jobs",JobData.findAll());

        }else {

ArrayList jobs =JobData.findByColumnAndValue(searchType,searchTerm);
model.addAttribute("jobs",JobData.findByColumnAndValue(searchType,searchTerm));

        }


    model.addAttribute("columns", columnChoices);
        return "search";

}
}
