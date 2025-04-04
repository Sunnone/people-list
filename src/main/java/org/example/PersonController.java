package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping
    public String getAllPeople(Model model) {
        List<Person> people = personDAO.getAllPeople();
        System.out.println("DEBUG: People count = " + people.size());
        model.addAttribute("people", people);
        return "people/list";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable long id, Model model) {
        Person person = personDAO.getById(id);
        model.addAttribute("person", person);
        return "people/view";
    }

    @PostMapping
    public String addPerson(@ModelAttribute Person person) {
        personDAO.addPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/")
    public String redirectToPeople() {
        return "redirect:/people";
    }
}