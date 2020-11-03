package ro.student.mtapo.advertisy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
public class MainController {

    private final Logger logger = Logger.getLogger(this.getClass().toString());

    /**
     * Main page.
     *
     * @param
     * @return index.html
     */
    @GetMapping(path = "/home")
    public String welcomePage() {

        return "index";
    }

    /**
     * Under construction page.
     *
     * @return under_construction.html
     */
    @GetMapping(path = "")
    public String underConstructionPage() {

        return "under_construction";
    }
}
