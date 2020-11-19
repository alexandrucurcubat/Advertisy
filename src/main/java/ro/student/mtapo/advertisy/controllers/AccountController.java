package ro.student.mtapo.advertisy.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ro.student.mtapo.advertisy.services.UserService;
import ro.student.mtapo.advertisy.util.AccountDetails;

import java.io.IOException;

@Controller
@RequestMapping("account")
public class AccountController {

    UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("create")
    public String createAccountForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("principal", authentication.getPrincipal());
        model.addAttribute("createAccountFragment", true);
        model.addAttribute("counties", userService.getAllCounties());
        return "index";
    }

    @PostMapping("create")
    public String createAccount(
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
            if (userService.createAccount(details) != null) {
                redirectAttributes.addFlashAttribute("accountCreated", true);
                return "redirect:/login";
            }
            redirectAttributes.addFlashAttribute("emailExistsError", true);
        } else {
            redirectAttributes.addFlashAttribute("passwordMatchError", true);
        }
        return "redirect:/account/create";
    }
}
