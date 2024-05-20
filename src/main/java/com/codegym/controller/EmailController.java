package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("email", emailService.displayAll());
        return "/list";
    }

    @GetMapping("/edit")
    public ModelAndView showFormList(@RequestParam int id) {
        ModelAndView modelAndView = new ModelAndView("/form");
        Email email = emailService.findById(id);
        modelAndView.addObject("email", email);
        modelAndView.addObject("languageList", emailService.languageList());
        modelAndView.addObject("pageSizeList", emailService.pageSizeList());
        return modelAndView;

    }

    @PostMapping("/save")
    public String saveUpdate(@ModelAttribute Email email, RedirectAttributes attributes) {
        emailService.edit(email);
        attributes.addFlashAttribute("message", "Update success");
        return "redirect:/email/";
    }
}
