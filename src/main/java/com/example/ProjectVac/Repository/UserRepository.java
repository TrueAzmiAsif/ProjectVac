package com.example.ProjectVac.Repository;

import com.example.ProjectVac.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
    public User findByPhone(int phone);
    public List<User> findByDose1TakenAndDose2Taken(boolean dose1Taken, boolean dose2Taken);
}
