package tech.dirickx.littlearithmetics.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.services.reposervices.PersonService;
import tech.dirickx.littlearithmetics.services.reposervices.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/person")
public class PersonController {

    private PersonService personService;
    private UserService userService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/update")
    public String manageAccount(Model model, Principal principal){
        User user = userService.findUserByName(principal.getName());
        model.addAttribute("person", user.getPerson());
        return "person/updatePerson";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String updatePerson(Person person, Model model){
        personService.save(person);
        model.addAttribute("firstName", person.getFirstName());
        model.addAttribute("familyName", person.getFamilyName());
        return "quiz/welcome";
    }



}
