package com.vivek.app.restapi.Controller;

import com.vivek.app.restapi.Models.User;
import com.vivek.app.restapi.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String getPage(){
        return "Hello World";
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody  User user){
        userRepo.save(user);
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody  User user){
        User updateUser = userRepo.findById(id).get();
        updateUser.setAge(user.getAge());
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setOccupation(user.getOccupation());
        userRepo.save(updateUser);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted";
    }


}
