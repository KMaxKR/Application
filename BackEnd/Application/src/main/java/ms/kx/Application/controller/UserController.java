package ms.kx.Application.controller;

import ms.kx.Application.entity.User;
import ms.kx.Application.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String user(Model model){
        User user = new User();
        model.addAttribute("addUser", user);
        return "user";
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> list = userService.findAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<User>> findUser(@PathVariable("id") Long user_id){
        Optional<User> user = userService.findUserById(user_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long user_id){
        userService.deleteUserById(user_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
