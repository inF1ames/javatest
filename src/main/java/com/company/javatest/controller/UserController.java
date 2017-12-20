package com.company.javatest.controller;

import com.company.javatest.converter.EntityDtoConverter;
import com.company.javatest.dao.UserDao;
import com.company.javatest.dao.entity.User;
import com.company.javatest.service.SecurityService;
import com.company.javatest.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String submitRegistration(@ModelAttribute("userForm") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userDao.add(EntityDtoConverter.convert(user));
        securityService.autoLogin(user.getUsername(), user.getPassword());

        return "redirect:/main";
    }
}
