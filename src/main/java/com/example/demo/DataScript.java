package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Approver;
import com.example.demo.entity.Architect;
import com.example.demo.entity.Bank;
import com.example.demo.entity.Client;
import com.example.demo.entity.ContactPerson;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Item;
import com.example.demo.entity.Privilege;
import com.example.demo.entity.Project;
import com.example.demo.entity.RequisitionItem;
import com.example.demo.entity.Role;
import com.example.demo.entity.Structural;
import com.example.demo.entity.StudentM2M;
import com.example.demo.entity.SubjectM2M;
import com.example.demo.entity.Unit;
import com.example.demo.entity.User;
import com.example.demo.entity.Vendor;
import com.example.demo.entity.VendorType;
import com.example.demo.repository.CommonAudit;
import com.example.demo.service.ApproverService;
import com.example.demo.service.GradeService;
import com.example.demo.service.ItemService;
import com.example.demo.service.PrivilegeService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.RequisitionItemService;
import com.example.demo.service.RoleService;
import com.example.demo.service.StudentM2MService;
import com.example.demo.service.SubjectM2MService;
import com.example.demo.service.UnitService;
import com.example.demo.service.UserService;
import com.example.demo.service.VendorService;
import com.example.demo.service.VendorTypeService;

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

	@Autowired
	private StudentM2MService studentM2MService;

	@Autowired
	private SubjectM2MService subjectM2MService;

	@Autowired
	private VendorTypeService vendorTypeService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private GradeService gradeService;

	@Autowired
	private UnitService unitService;
	
	@Autowired
	private RequisitionItemService requisitionItemService;

	public void project() {
		createProject();
	}

	public void vendorType() {
		createVendorType();
	}

	public void vendor() {
		createVendor();
	}

	public void item() {
		createItem();
		updateItem_Grade();
		getAllItem();
	}

	public void grade() {
		createGrade();
		updateGrade_Unit();
	}

	public void unit() {
		createUnit();
	}
	
	public void requisitionItem()
	{
		createRequisitionItem();
	}

	private CommonAudit getCreateCommonAudit() {
		final CommonAudit commonAudit = new CommonAudit();
		commonAudit.setCreatedBy("System");
		commonAudit.setCreatedAt(new Date());
		return commonAudit;
	}

	@Transactional
	private void createRequisitionItem()
	{
		final Item item =itemService.findByName("Item1");
		System.out.println("******** createRequisitionItem : Item >  "+item);
		final Grade grade =gradeService.findByName("Grade1");
		System.out.println("******** createRequisitionItem : grade >  "+grade);
		final Unit unit =unitService.findByName("Unit1");
		System.out.println("******** createRequisitionItem : unit >  "+unit);
		RequisitionItem requisitionItem = new RequisitionItem();
		requisitionItem.setItem(item);
		requisitionItem.setGrade(grade);
		requisitionItem.setUnit(unit);
		requisitionItem.setQuantity(10l);
		requisitionItem.setUsedFor("Testing 1");
		requisitionItem.setCommonAudit(getCreateCommonAudit());
		RequisitionItem r = requisitionItemService.save(requisitionItem );
		System.out.println("******** createRequisitionItem : RequisitionItem >  "+r);
		
	}
	
	@Transactional
	private void getAllItem() {
		final List<Item> items = itemService.findAll();
		for (Item item : items) {

			
			System.out.println("***** Item : "+item);
		}

	}

	private void createItem() {
		for (int i = 1; i <= 5; i++) {

			Item item = new Item();
			item.setName("Item" + i);
			item.setDescription("Item" + i);
			item.setCommonAudit(getCreateCommonAudit());
			itemService.save(item);
		}
	}

	@Transactional
	private void updateItem_Grade() {

		final List<Item> items = itemService.findAll();
		final List<Grade> grades = gradeService.findAll();

		for (Item item : items) {

			item.setGrades(grades);
			itemService.save(item);
		}

	}

	@Transactional
	private void updateGrade_Unit() {

		final List<Grade> grades = gradeService.findAll();
		final List<Unit> units = unitService.findAll();

		for (Grade grade : grades) {

			grade.setUnits(units);
			gradeService.save(grade);
		}

	}

	private void createGrade() {
		for (int i = 1; i <= 5; i++) {

			Grade grade = new Grade();
			grade.setName("Grade" + i);
			grade.setDescription("Grade" + i);
			grade.setCommonAudit(getCreateCommonAudit());
			gradeService.save(grade);
		}
	}

	private void createUnit() {
		for (int i = 1; i <= 5; i++) {

			Unit unit = new Unit();
			unit.setName("Unit" + i);
			unit.setDescription("Unit" + i);
			unit.setCommonAudit(getCreateCommonAudit());
			unitService.save(unit);
		}
	}

	private void createVendor() {
		List<VendorType> vendorTypes = vendorTypeService.findAll();

		Bank bank1 = new Bank();
		bank1.setName("HDFC");
		bank1.setBranchName("Goregaaon");
		bank1.setAccountNo("1534879");
		bank1.setIfscCode("HDFC40001");
		bank1.setMicrCode("25448");

		ContactPerson contactPerson1 = new ContactPerson();
		contactPerson1.setName("Harshad");
		contactPerson1.setContactNo("681012131");
		contactPerson1.setEmailId("harshad.gaikwad@gmail.com");

		Vendor vendor1 = new Vendor();
		vendor1.setName("Vendor1");
		vendor1.setDescription("vendor1");
		vendor1.setGstNo("gst12345");
		vendor1.setAddress("Mumbai");

		vendor1.setBank(bank1);

		vendor1.setContactPerson(contactPerson1);
		vendor1.setVendorTypes(vendorTypes);
		final CommonAudit commonAudit = new CommonAudit();
		commonAudit.setCreatedBy("System");
		commonAudit.setCreatedAt(new Date());
		vendor1.setCommonAudit(commonAudit);
		vendorService.save(vendor1);
	}

	private void createVendorType() {

		final CommonAudit commonAudit = new CommonAudit();
		commonAudit.setCreatedBy("System");
		commonAudit.setCreatedAt(new Date());

		VendorType vendorType1 = new VendorType();
		vendorType1.setName("Goods");
		vendorType1.setDescription("Goods");

		vendorType1.setCommonAudit(commonAudit);
		vendorTypeService.save(vendorType1);

		VendorType vendorType2 = new VendorType();
		vendorType2.setName("Services");
		vendorType2.setDescription("Services");
		vendorType2.setCommonAudit(commonAudit);
		vendorTypeService.save(vendorType2);
	}

	public void createProject() {

		final Project project = new Project();
		project.setName("Project1");
		project.setDescription("Project1 Desc");
		try {

			String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

			project.setStartDate(new SimpleDateFormat("dd-MM-yyyy").parse(currentDate));
			project.setEndDate(new SimpleDateFormat("dd-MM-yyyy").parse(currentDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		project.setAddress("Mumbai");
		project.setRemark("Test");
		project.setSubDivisionName("Goregaon");

		final ContactPerson contactPerson = new ContactPerson();
		contactPerson.setName("Harshad");
		contactPerson.setEmailId("harshad.gaikwad@gmail.com");
		contactPerson.setContactNo("9999999");
		project.setContactPerson(contactPerson);

		final Client client = new Client();
		client.setName("client_Harshad");
		client.setEmailId("charshad.gaikwad@gmail.com");
		client.setContactNo("9999999");
		project.setClient(client);

		final Architect architect = new Architect();
		architect.setName("architect_Harshad");
		architect.setEmailId("aharshad.gaikwad@gmail.com");
		architect.setContactNo("9999999");
		project.setArchitect(architect);

		final Structural structural = new Structural();
		structural.setName("structural_Harshad");
		structural.setEmailId("sharshad.gaikwad@gmail.com");
		structural.setContactNo("9999999");
		project.setStructural(structural);

		final CommonAudit commonAudit = new CommonAudit();
		commonAudit.setCreatedBy("System");
		commonAudit.setCreatedAt(new Date());
		project.setCommonAudit(commonAudit);
		projectService.save(project);
	}

	public void createStudent() {

		StudentM2M studentM2M = studentM2MService.findById(1l);
		System.out.println("Student " + studentM2M);
		System.out.println("Student " + studentM2M.getSubjectM2Ms());

		SubjectM2M subjectM2M = subjectM2MService.findById(1l);
		System.out.println("subjectM2M " + subjectM2M);
		System.out.println("subjectM2M " + subjectM2M.getStudentM2Ms());

	}

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

	@Transactional
	public void createUser() {

		final List<Role> roles = roleService.findAll();
		final List<Project> projects = projectService.findAll();
		final User user1 = new User();
		user1.setUserName("harshad.gaikwad");
		user1.setFirstName("Harshad");
		user1.setLastName("Gaikwad");
		user1.setEmail("harshad.gaikwad@gmail.com");
		user1.setEnabled(true);
		user1.setPassword("password");
		user1.setTokenExpired(false);
		user1.setRoles(roles);
		user1.setProjects(projects);
		final User u1 = userService.save(user1);
		System.out.println("User Created " + u1);

		/*
		 * final Role role2 = roleService.findByName("ROLE_USER"); final User user2 =
		 * new User(); user2.setUserName("pranshu.srivastav");
		 * user2.setFirstName("Pranshu"); user2.setLastName("Shrivastav");
		 * user2.setEmail("pranshu.shrivastav@gmail.com"); user2.setEnabled(true);
		 * user2.setPassword("password"); user2.setTokenExpired(false);
		 * user2.setRoles(Arrays.asList(role2)); final User u2 =
		 * userService.save(user2); System.out.println("User Created " + u2);
		 */

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
		user2.setApprovers(Arrays.asList(a2, a3));
		final User u2 = userService.save(user2);
		System.out.println("User Updated " + u2);

	}

	public void getUser() {
		final User user1 = userService.findByUserName("harshad.gaikwad");
		System.out.println("User : " + user1);
		final Collection<Approver> approvers = user1.getApprovers();
		for (Approver approver : approvers) {
			System.out.println("User approver : " + approver);
		}

		final Collection<Role> roles = user1.getRoles();
		for (Role role : roles) {
			System.out.println("User role : " + role);
		}
	}

}
