package br.com.mleitejunior.mongodbcrud.controller;

import br.com.mleitejunior.mongodbcrud.entity.User;
import br.com.mleitejunior.mongodbcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/list")
    public List<User> getUser() {
        return userService.getUsers();
    }

    @PutMapping("/update/{user_id}")
    public User updateUser(@RequestBody User user, @PathVariable("user_id") BigInteger id) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{user_id}")
    public String deleteUser(@PathVariable("user_id") BigInteger id) {
        userService.deleteUser(id);
        return "Deleted sucessfully";
    }

}
