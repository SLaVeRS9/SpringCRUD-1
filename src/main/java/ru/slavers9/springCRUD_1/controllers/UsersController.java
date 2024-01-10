package ru.slavers9.springCRUD_1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.slavers9.springCRUD_1.models.UserModel;
import ru.slavers9.springCRUD_1.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/user";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") @Valid UserModel user, BindingResult bindingResult, @PathVariable("id") Long id) {
        if(bindingResult.hasErrors()) {
            return "users/edit";
        }
        userService.editUser(user, id);
        return "redirect:{id}";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @GetMapping("/add")
    public String addUserFormShow(@ModelAttribute("user") UserModel user) {
        return "users/add";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") @Valid UserModel user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "users/add";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
