package com.example.ProjectVac.Service.Implementation;

import com.example.ProjectVac.DTO.RequestDTO.UserRequestDTO;
import com.example.ProjectVac.DTO.ResponseDTO.UserListResponseDTO;
import com.example.ProjectVac.DTO.ResponseDTO.UserResponseDTO;
import com.example.ProjectVac.Enum.Gender;
import com.example.ProjectVac.Model.User;
import com.example.ProjectVac.Repository.UserRepository;
import com.example.ProjectVac.Service.UserService;
import com.example.ProjectVac.Transformer.DTOtoEntity.UserRequestDTOtoUser;
import com.example.ProjectVac.Transformer.EntityToDTO.UserToListuserDTO;
import com.example.ProjectVac.Transformer.EntityToDTO.EntityToUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;
    public UserResponseDTO add(UserRequestDTO userDTO){
        User temp= userRepo.save(UserRequestDTOtoUser.userRequestDTOtoUser(userDTO));
        return EntityToUserDTO.userToDTO(temp,"Has been successfully added.");
    }
    public UserResponseDTO findByMail(String email){
        User usfound=userRepo.findByEmail(email);
        return EntityToUserDTO.userToDTO(usfound,usfound.getName()+" is the name of the person having that email address.");
    }
    public UserResponseDTO updateNameByPhone(int phone,String name){
        User toBeChanged=userRepo.findByPhone(phone);
        String prevName= toBeChanged.getName();
        toBeChanged.setName(name);
        userRepo.save(toBeChanged);
        return EntityToUserDTO.userToDTO(toBeChanged,prevName+" Has been changed to name: "+name);
    }
    public UserListResponseDTO allUserWithoutDose(){
        List<String> respName=new ArrayList<>();
        for(User x: userRepo.findByDose1TakenAndDose2Taken(false,false)){
            respName.add(x.getName());
        }
        return UserToListuserDTO.userToListuserDTO(respName,"These are the people who have not taken even a single dose.");
    }
    public UserListResponseDTO allUserWithoutDose2(){
        List<String> respName=new ArrayList<>();
        for(User x: userRepo.findByDose1TakenAndDose2Taken(true,false)){
            respName.add(x.getName());
        }
        return UserToListuserDTO.userToListuserDTO(respName,"These are the people who have not taken second dose.");

    }
    public UserListResponseDTO allUserFullyVaccinated(){
        List<String> respName=new ArrayList<>();
        for(User x: userRepo.findByDose1TakenAndDose2Taken(true,true)){
            respName.add(x.getName());
        }
        return UserToListuserDTO.userToListuserDTO(respName,"These are the people who are fully vaccinated");

    }
    public UserListResponseDTO maleNoDose(){
        List<String> respName=new ArrayList<>();
        for(User x: userRepo.findByDose1TakenAndDose2Taken(false,false)){
            if(x.getGender()== Gender.MALE)
                respName.add(x.getName());
        }
        return UserToListuserDTO.userToListuserDTO(respName,"List of un-vaccinated males.");

    }
    public UserListResponseDTO femaleFullVaccinated(){
        List<String> respName=new ArrayList<>();
        for(User x: userRepo.findByDose1TakenAndDose2Taken(true,true)){
            if(x.getGender()== Gender.FEMALE)
                respName.add(x.getName());
        }
        return UserToListuserDTO.userToListuserDTO(respName,"List of fully vaccinated females.");

    }
}
