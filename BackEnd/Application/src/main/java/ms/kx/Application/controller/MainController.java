package ms.kx.Application.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "")
@RestController
@RequestMapping("/app")
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
