package vamk.uyen.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import vamk.uyen.crm.entity.Role;
import vamk.uyen.crm.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository repo;
	
	public Iterable<Role> getRoles(){
		return repo.findAll();
	}

	
	public Role getRole(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public Role saveRole(Role role) {
		return repo.save(role);
	}
	
	public void deleteRole(Integer id) {
		repo.deleteById(id);
	}
}
