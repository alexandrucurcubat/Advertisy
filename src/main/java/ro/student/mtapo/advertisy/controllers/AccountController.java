package ro.student.mtapo.advertisy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.student.mtapo.advertisy.services.CountyService;

@Controller
@RequestMapping("account")
public class AccountController {

    CountyService countyService;

    public AccountController(CountyService countyService) {
        this.countyService = countyService;
    }

    @GetMapping("create")
    public String createAccountPage(Model model) {
        model.addAttribute("createAccountFragment", true);
        model.addAttribute("counties", countyService.getAllCounties());
        return "index";
    }
}
