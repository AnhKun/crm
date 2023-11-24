package vamk.uyen.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vamk.uyen.crm.entity.Role;
import vamk.uyen.crm.entity.User;
import vamk.uyen.crm.repository.RoleRepository;
import vamk.uyen.crm.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository; 

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User saveUser(User user) {
        Role userRole = user.getRole();
        System.out.println("User role: " + user.getRole());
        if (userRole == null || userRole.getId() == null) {
            return null;
        }

        Role existingRole = roleRepository.findById(userRole.getId()).orElse(null);
        
        if (existingRole == null) {
            return null; 
        }

        user.setRole(existingRole);

        return userRepository.save(user);
    }



    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
