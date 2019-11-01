package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Approver;
import com.example.demo.entity.Privilege;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.ApproverService;
import com.example.demo.service.PrivilegeService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Component
public class DataScript {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PrivilegeService privilegeService;

	@Autowired
	private ApproverService approverService;

	public void createPrivilege() {
		final Privilege privilege1 = new Privilege();
		privilege1.setName("WRITE_PRIVILEGE");
		privilege1.setDescription("Wite Privilege");
		final Privilege p1 = privilegeService.save(privilege1);
		System.out.println("Privilege Created " + p1.getName());

		final Privilege privilege2 = new Privilege();
		privilege2.setName("READ_PRIVILEGE");
		privilege2.setDescription("READ Privilege");
		final Privilege p2 = privilegeService.save(privilege2);
		System.out.println("Privilege Created " + p2.getName());

		final Privilege privilege3 = new Privilege();
		privilege3.setName("APPROVE_PRIVILEGE");
		privilege3.setDescription("APPROVE Privilege");
		final Privilege p3 = privilegeService.save(privilege3);
		System.out.println("Privilege Created " + p3.getName());

		final Privilege privilege4 = new Privilege();
		privilege4.setName("REJECT_PRIVILEGE");
		privilege4.setDescription("APPROVE Privilege");
		final Privilege p4 = privilegeService.save(privilege4);
		System.out.println("Privilege Created " + p4.getName());

	}

	public void createRole() {
		final Privilege privileges1 = privilegeService.findByName("READ_PRIVILEGE");

		final Role role1 = new Role();
		role1.setName("ROLE_USER");
		role1.setDescription("user role");
		role1.setPriviliges(Arrays.asList(privileges1));
		final Role r1 = roleService.save(role1);
		System.out.println("Role Created " + r1);

		final Privilege privileges2 = privilegeService.findByName("WRITE_PRIVILEGE");

		final Role role2 = new Role();
		role2.setName("ROLE_ADMIN");
		role2.setDescription("user admin");
		role2.setPriviliges(Arrays.asList(privileges2));
		final Role r2 = roleService.save(role2);
		System.out.println("Role Created " + r2);

		final List<Privilege> privileges3 = privilegeService.findAll();
		final Role role3 = new Role();
		role3.setName("ROLE_SUPER");
		role3.setDescription("user super");
		role3.setPriviliges(privileges3);
		final Role r3 = roleService.save(role3);
		System.out.println("Role Created " + r3);
		
		
	}

	public void createApprover() {

		final Approver approver0 = new Approver();
		approver0.setUserName("harshad.gaikwad");
		approver0.setLevel(0l);
		final Approver a0 = approverService.save(approver0);
		System.out.println("Approver Created " + a0);
		
		final Approver approver1 = new Approver();
		approver1.setUserName("harshad.gaikwad");
		approver1.setLevel(1l);
		final Approver a1 = approverService.save(approver1);
		System.out.println("Approver Created " + a1);
		
		
		final Approver approver4 = new Approver();
		approver4.setUserName("harshad.gaikwad");
		approver4.setLevel(2l);
		final Approver a4 = approverService.save(approver4);
		System.out.println("Approver Created " + a4);

		final Approver approver2 = new Approver();
		approver2.setUserName("pranshu.srivastav");
		approver2.setLevel(0l);
		final Approver a2 = approverService.save(approver2);
		System.out.println("Approver Created " + a2);

	}

	public void createUser() {

		final List<Role> roles = roleService.findAll();
		final User user1 = new User();
		user1.setUserName("harshad.gaikwad");
		user1.setFirstName("Harshad");
		user1.setLastName("Gaikwad");
		user1.setEmail("harshad.gaikwad@gmail.com");
		user1.setEnabled(true);
		user1.setPassword("password");
		user1.setTokenExpired(false);
		user1.setRoles(roles);
		final User u1 = userService.save(user1);
		System.out.println("User Created " + u1);

		final Role role2 = roleService.findByName("ROLE_USER");
		final User user2 = new User();
		user2.setUserName("pranshu.srivastav");
		user2.setFirstName("Pranshu");
		user2.setLastName("Shrivastav");
		user2.setEmail("pranshu.shrivastav@gmail.com");
		user2.setEnabled(true);
		user2.setPassword("password");
		user2.setTokenExpired(false);
		user2.setRoles(Arrays.asList(role2));
		final User u2 = userService.save(user2);
		System.out.println("User Created " + u2);
	

	}

	public void updateUser() {

		final Role role1 = roleService.findByName("ROLE_ADMIN");
		final User user1 = userService.findByUserName("harshad.gaikwad");
		final Approver a1 = approverService.findByUserNameAndLevel("harshad.gaikwad", 0l);

		user1.setRoles(Arrays.asList(role1));
		user1.setApprovers(Arrays.asList(a1));
		final User u1 = userService.save(user1);
		System.out.println("User Updated " + u1);
		
		
		final Approver a2 = approverService.findByUserNameAndLevel("harshad.gaikwad", 1l);
		final Approver a3 = approverService.findByUserNameAndLevel("pranshu.srivastav", 0l);
		final User user2 = userService.findByUserName("pranshu.srivastav");
		user2.setApprovers(Arrays.asList(a2,a3));
		final User u2 = userService.save(user2);
		System.out.println("User Updated " + u2);

	}
	
	
	public void getUser()
	{
		final User user1 = userService.findByUserName("harshad.gaikwad");
		System.out.println("User : "+user1);
		final Collection<Approver> approvers= user1.getApprovers();
		for (Approver approver : approvers) {
			System.out.println("User approver : "+approver);
		}
		
		final Collection<Role> roles= user1.getRoles();
		for (Role role : roles) {
			System.out.println("User role : "+role);
		}
	}

}
