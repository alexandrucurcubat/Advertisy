package ro.student.mtapo.advertisy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.student.mtapo.advertisy.services.AnnouncementService;

@Controller
@RequestMapping("")
public class HomeController {

    AnnouncementService announcementService;

    public HomeController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("")
    public String index() {
        return "redirect:announcements";
    }

    @GetMapping("announcements")
    public String announcements(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("principal", authentication.getPrincipal());
        model.addAttribute("roles", authentication.getAuthorities());
        model.addAttribute("homeFragment", true);
        model.addAttribute("showAnnouncements", true);
        model.addAttribute("announcements", announcementService.getAnnouncements());
        model.addAttribute("categories", announcementService.getAnnouncementCategories());
        model.addAttribute("activeCategory", "all");
        return "index";
    }

    @GetMapping("announcements/{announcementId}")
    public String announcement(@PathVariable int announcementId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("principal", authentication.getPrincipal());
        model.addAttribute("roles", authentication.getAuthorities());
        model.addAttribute("homeFragment", true);
        model.addAttribute("showAnnouncementDetails", true);
        model.addAttribute("announcement", announcementService.getAnnouncementById(announcementId));
        model.addAttribute("categories", announcementService.getAnnouncementCategories());
        model.addAttribute("activeCategory", announcementService.getAnnouncementCategoryByAnnouncementId(announcementId).getId());
        return "index";
    }

    @GetMapping("announcements/category/{categoryId}")
    public String announcementsByCategory(@PathVariable int categoryId, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("principal", authentication.getPrincipal());
        model.addAttribute("roles", authentication.getAuthorities());
        model.addAttribute("homeFragment", true);
        model.addAttribute("showAnnouncements", true);
        model.addAttribute("announcements", announcementService.getAnnouncementsByCategoryId(categoryId));
        model.addAttribute("categories", announcementService.getAnnouncementCategories());
        model.addAttribute("activeCategory", categoryId);
        return "index";
    }

    @GetMapping("image/{announcementId}")
    public ResponseEntity<byte[]> announcementImage(@PathVariable int announcementId) {
        return announcementService.getAnnouncementImage(announcementId);
    }

    @GetMapping("login")
    public String loginForm(Model model) {
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