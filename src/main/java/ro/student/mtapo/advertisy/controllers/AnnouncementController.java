package ro.student.mtapo.advertisy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.student.mtapo.advertisy.services.AnnouncementService;

@Controller
@RequestMapping("announcements")
public class AnnouncementController {

    AnnouncementService announcementService;

    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("")
    public String getAnnouncements(Model model) {
        model.addAttribute("announcementsFragment", true);
        model.addAttribute("showAnnouncements", true);
        model.addAttribute("announcements", announcementService.getAnnouncements());
        model.addAttribute("categories", announcementService.getAnnouncementCategories());
        model.addAttribute("activeCategory", "all");
        return "index";
    }

    @GetMapping("/{announcementId}")
    public String getAnnouncement(@PathVariable int announcementId, Model model) {
        model.addAttribute("announcementsFragment", true);
        model.addAttribute("showAnnouncementDetails", true);
        model.addAttribute("announcement", announcementService.getAnnouncementById(announcementId));
        model.addAttribute("categories", announcementService.getAnnouncementCategories());
        model.addAttribute("activeCategory", announcementService.getAnnouncementCategoryByAnnouncementId(announcementId).getId());
        return "index";
    }

    @GetMapping("category/{categoryId}")
    public String getAnnouncementsByCategory(@PathVariable int categoryId, Model model) {
        model.addAttribute("announcementsFragment", true);
        model.addAttribute("showAnnouncements", true);
        model.addAttribute("announcements", announcementService.getAnnouncementsByCategoryId(categoryId));
        model.addAttribute("categories", announcementService.getAnnouncementCategories());
        model.addAttribute("activeCategory", categoryId);
        return "index";
    }

    @GetMapping("image/{announcementId}")
    public ResponseEntity<byte[]> getAnnouncementImage(@PathVariable int announcementId) {
        return announcementService.getAnnouncementImage(announcementId);
    }
}
