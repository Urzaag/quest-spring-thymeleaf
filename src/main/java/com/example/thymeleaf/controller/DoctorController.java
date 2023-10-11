package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DoctorController {

    @GetMapping("/")
    public String index(Model model) {

        List<String> doctorsNames = new ArrayList<>();

        doctorsNames.add("William Hartnell");
        doctorsNames.add("Patrick Troughton");
        doctorsNames.add("Jon Pertwee");
        doctorsNames.add("Tom Baker");
        doctorsNames.add("Peter Davison");
        doctorsNames.add("Colin Baker");
        doctorsNames.add("Sylvester McCoy");
        doctorsNames.add("Paul McGann");
        doctorsNames.add("Christopher Eccleston");
        doctorsNames.add("David Tennant");
        doctorsNames.add("Matt Smith");
        doctorsNames.add("Peter Capaldi");
        doctorsNames.add("Jodie Whittaker");

        Map<Integer, Doctor> doctors = new HashMap<>();

        for (int i = 0; i < doctorsNames.size(); i++) {
            doctors.put(i, new Doctor(i + 1, doctorsNames.get(i)));
        }

        model.addAttribute("doctors", doctors);

        return "index";
    }

    @GetMapping("/doctor/")
    public String doctor(@RequestParam(required=false, defaultValue="0") int number,
                         @RequestParam(required=false, defaultValue="John Smith") String name,
                         Model model) {

        model.addAttribute("number", number);
        model.addAttribute("name", name);

        return "doctor";
    }
}
