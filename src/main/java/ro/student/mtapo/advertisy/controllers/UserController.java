package ro.student.mtapo.advertisy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.student.mtapo.advertisy.services.CountyService;
import ro.student.mtapo.advertisy.services.UserService;
import ro.student.mtapo.advertisy.util.AccountDetails;

import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    UserService userService;
    CountyService countyService;

    public UserController(UserService userService, CountyService countyService) {
        this.userService = userService;
        this.countyService = countyService;
    }

    @GetMapping("account")
    public String getUserAccountPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", userService.getUserByEmail((String) authentication.getPrincipal()));
        model.addAttribute("accountFragment", true);
        model.addAttribute("counties", countyService.getAllCounties());
        return "index";
    }

    @GetMapping("image/{id}")
    public ResponseEntity<byte[]> getUserImage(@PathVariable int id) {
        return userService.getUserImage(id);
    }

    @PostMapping("update")
    public String updateAccount(
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String passwordConfirmation,
            @RequestParam String countyId,
            @RequestParam String place,
            @RequestParam String streetAddress,
            @RequestParam MultipartFile userImage,
            RedirectAttributes redirectAttributes
    ) throws IOException {
        if (password.equals(passwordConfirmation)) {
            AccountDetails details = new AccountDetails();
            details.setEmail(email);
            details.setUsername(username);
            details.setPhone(phone);
            details.setPassword(password);
            details.setCountyId(Integer.parseInt(countyId));
            details.setPlace(place);
            details.setStreetAddress(streetAddress);
            details.setUserImage(userImage);
            if (userService.updateAccount(details) != null) {
                redirectAttributes.addFlashAttribute("accountUpdated", true);
                return "redirect:/user/account";
            }
            redirectAttributes.addFlashAttribute("passwordError", true);
        } else {
            redirectAttributes.addFlashAttribute("passwordMatchError", true);
        }
        return "redirect:/user/account";
    }
}
