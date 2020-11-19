package ro.student.mtapo.advertisy.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("")
    public String index() {
        return "redirect:announcements";
    }

    @GetMapping("login")
    public String loginPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("principal", authentication.getPrincipal());
        model.addAttribute("roles", authentication.getAuthorities());
        model.addAttribute("loginFragment", true);
        return "index";
    }

    @GetMapping("login_error")
    public String loginError(RedirectAttributes attributes) {
        attributes.addFlashAttribute("loginError", true);
        return "redirect:login";
    }
}