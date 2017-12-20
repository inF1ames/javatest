package com.company.javatest.controller;

import com.company.javatest.model.WeekendCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MainController {

    @Autowired
    private WeekendCounter weekendCounter;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMain() {
        return "main";
    }

    @RequestMapping(value = "/getWeekend", method = RequestMethod.GET)
    public String getWeekend(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                             @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                             Model model) {

        if (startDate == null || endDate == null) {
            model.addAttribute("error", "Выберите дату");
            return "main";
        }

        int amountOfWeekends = weekendCounter.getAmountOfWeekends(startDate, endDate);
        model.addAttribute("amountOfWeekends", amountOfWeekends);
        return "main";
    }
}
