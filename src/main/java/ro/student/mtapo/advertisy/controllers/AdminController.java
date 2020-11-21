package ro.student.mtapo.advertisy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.student.mtapo.advertisy.services.AnnouncementService;
import ro.student.mtapo.advertisy.services.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

    UserService userService;
    AnnouncementService announcementService;

    public AdminController(UserService userService, AnnouncementService announcementService) {
        this.userService = userService;
        this.announcementService = announcementService;
    }

    @GetMapping("users")
    public String admin(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("adminUsers", true);
        model.addAttribute("adminFragment", true);
        return "index";
    }

    @PostMapping("user/ban")
    public String banUser(@RequestParam String userId) {
        userService.deactivateUser(Integer.parseInt(userId));
        return "redirect:/admin/users";
    }

    @PostMapping("user/unban")
    public String unbanUser(@RequestParam String userId) {
        userService.activateUser(Integer.parseInt(userId));
        return "redirect:/admin/users";
    }

    @PostMapping("users/search")
    public String searchUsers(@RequestParam String queryString, Model model) {
        model.addAttribute("users", userService.searchUsers(queryString));
        model.addAttribute("adminUsers", true);
        model.addAttribute("adminFragment", true);
        return "index";
    }

    @GetMapping("reports")
    public String getAnnouncementReports(Model model) {
        model.addAttribute("reports", announcementService.getAnnouncementReports());
        model.addAttribute("adminReports", true);
        model.addAttribute("adminFragment", true);
        return "index";
    }

    @GetMapping("unban_requests")
    public String getAnnouncementUnbanRequests(Model model) {
        model.addAttribute("unbanRequests", announcementService.getAnnouncementUnbanRequests());
        model.addAttribute("adminUnbanRequests", true);
        model.addAttribute("adminFragment", true);
        return "index";
    }

    @GetMapping("report/delete/{reportId}")
    public String deleteReport(@PathVariable int reportId) {
        announcementService.deleteAnnouncementReport(reportId);
        return "redirect:/admin/reports";
    }

    @GetMapping("unban_request/delete/{unbanRequestId}")
    public String deleteUnbanRequest(@PathVariable int unbanRequestId) {
        announcementService.deleteAnnouncementUnbanRequest(unbanRequestId);
        return "redirect:/admin/unban_requests";
    }

    @GetMapping("announcement/ban/{announcementId}/{origin}")
    public String banAnnouncement(@PathVariable int announcementId, @PathVariable String origin) {
        announcementService.deactivateAnnouncement(announcementId);
        if (origin.equals("adminReports")) {
            return "redirect:/admin/reports";
        } else if (origin.equals("adminUnbanRequests")) {
            return "redirect:/admin/unban_requests";
        }
        return "redirect:/admin/users";
    }

    @GetMapping("announcement/unban/{announcementId}/{origin}")
    public String unbanAnnouncement(@PathVariable int announcementId, @PathVariable String origin) {
        announcementService.activateAnnouncement(announcementId);
        if (origin.equals("adminReports")) {
            return "redirect:/admin/reports";
        } else if (origin.equals("adminUnbanRequests")) {
            return "redirect:/admin/unban_requests";
        }
        return "redirect:/admin/users";
    }
}
