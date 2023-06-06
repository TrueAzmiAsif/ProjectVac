package com.example.ProjectVac.Controller;

import com.example.ProjectVac.DTO.RequestDTO.UserRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.UserListResponseDTO;
import com.example.ProjectVac.DTO.ResponseDTO.UserResponseDTO;
import com.example.ProjectVac.Service.Implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl usc;
    @PostMapping("/add")
    public UserResponseDTO add(@RequestBody UserRequestDTO userDTO){
        return usc.add(userDTO);
    }
    @GetMapping("/findByMail")
    public UserResponseDTO findByMail(@RequestParam("email") String email){
        return usc.findByMail(email);
    }
    @PutMapping("/updateNameByPhone")
    public UserResponseDTO updateNameByPhone(@RequestParam("phone") int phone, @RequestParam("name") String name){
        return usc.updateNameByPhone(phone, name);
    }
    @GetMapping("/allUserWithoutDose")
    public UserListResponseDTO allUserWithoutDose(){
        return usc.allUserWithoutDose();
    }
    @GetMapping("/allUserWithoutDose2")
    public UserListResponseDTO allUserWithoutDose2(){
        return usc.allUserWithoutDose2();
    }
    @GetMapping("/allUserFullyVaccinated")
    public UserListResponseDTO allUserFullyVaccinated(){
        return usc.allUserFullyVaccinated();
    }
    @GetMapping("/maleNoDose")
    public UserListResponseDTO maleNoDose(){
        return usc.maleNoDose();
    }
    @GetMapping("femaleFullVaccinated")
    public UserListResponseDTO femaleFullVaccinated(){
        return usc.femaleFullVaccinated();
    }
}
