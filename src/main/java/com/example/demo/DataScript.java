package com.example.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.example.demo.entity.CommonAudit;
import com.example.demo.entity.ContactPerson;
import com.example.demo.entity.Grade;
import com.example.demo.entity.Item;
import com.example.demo.entity.Privilege;
import com.example.demo.entity.Project;
import com.example.demo.entity.Quotation;
import com.example.demo.entity.Requisition;
import com.example.demo.entity.RequisitionItem;
import com.example.demo.entity.Role;
import com.example.demo.entity.Structural;
import com.example.demo.entity.StudentM2M;
import com.example.demo.entity.SubjectM2M;
import com.example.demo.entity.Unit;
import com.example.demo.entity.User;
import com.example.demo.entity.Vendor;
import com.example.demo.entity.VendorRequisition;
import com.example.demo.entity.VendorRequisitionItem;
import com.example.demo.entity.VendorType;
import com.example.demo.service.ApproverService;
import com.example.demo.service.GradeService;
import com.example.demo.service.ItemService;
import com.example.demo.service.PrivilegeService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.QuotationService;
import com.example.demo.service.RequisitionItemService;
import com.example.demo.service.RequisitionService;
import com.example.demo.service.RoleService;
import com.example.demo.service.StudentM2MService;
import com.example.demo.service.SubjectM2MService;
import com.example.demo.service.UnitService;
import com.example.demo.service.UserService;
import com.example.demo.service.VendorRequisitionItemService;
import com.example.demo.service.VendorRequisitionService;
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
	private RequisitionService requisitionService;

	@Autowired
	private RequisitionItemService requisitionItemService;

	@Autowired
	private VendorRequisitionService vendorRequisitionService;

	@Autowired
	private VendorRequisitionItemService vendorRequisitionItemService;

	@Autowired
	private QuotationService quotationService;

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
		// getAllItem();
	}

	public void grade() {
		createGrade();
		updateGrade_Unit();
	}

	public void unit() {
		createUnit();
	}

	public void requisitionItem() {
		// createRequisitionItem();
	}

	public void requisition() {
		createRequisition_RequisitionItems();
		// getRequisition();

	}

	public void vendorRequisition() {
		createVendorRequisition();
	}

	public void vendorRequisitionItem() {
		createVendorRequisitionItem();
	}

	private CommonAudit getCreateCommonAudit() {
		final CommonAudit commonAudit = new CommonAudit();
		commonAudit.setCreatedBy("System");
		commonAudit.setCreatedAt(new Date());
		return commonAudit;
	}

	@Transactional
	private void createVendorRequisitionItem() {

		for (int i = 1; i <= 4; i++) {

			final Requisition requisition = requisitionService.findByName("Requisition" + i);
			if (requisition != null) {

				final List<RequisitionItem> requisitionItems = requisition.getRequisitionItems();
				List<VendorRequisition> VendorRequisitions = vendorRequisitionService
						.findByRequisitionId(requisition.getId());
				for (VendorRequisition vendorRequisition : VendorRequisitions) {

					for (RequisitionItem requisitionItem : requisitionItems) {

						final VendorRequisitionItem vendorRequisitionItem = new VendorRequisitionItem();
						vendorRequisitionItem.setRequisitionItemId(requisitionItem.getId());
						vendorRequisitionItem.setVendorId(vendorRequisition.getVendorId());
						vendorRequisitionItem.setAmount(new BigDecimal("1000"));
						VendorRequisitionItem vri = vendorRequisitionItemService.save(vendorRequisitionItem);
						System.out.println("Crearted VendorRequisitionItem : " + vri.getId());
					}

				}
			}

		}

	}

	private void createVendorRequisition() {

		final List<Vendor> vendors = vendorService.findAll();
		final List<Requisition> requisitions = requisitionService.findAll();

		for (Vendor vendor : vendors) {
			List<VendorRequisition> vendorRequisitions = new ArrayList<>();
			final Quotation quotation = new Quotation();
			quotation.setCommonAudit(getCreateCommonAudit());
			quotation.setNotifyToVendor(true);
			quotation.setReplyFromVendor(false);

			try {

				final String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

				quotation.setLastDateOfSubmission(new SimpleDateFormat("dd-MM-yyyy").parse(currentDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (Requisition requisition : requisitions) {

				VendorRequisition vendorRequisition = new VendorRequisition();
				vendorRequisition.setRequisitionId(requisition.getId());
				vendorRequisition.setVendorId(vendor.getId());
				vendorRequisition.setQuotation(quotation);
				vendorRequisitions.add(vendorRequisition);
			}
			quotation.setVendorRequisitions(vendorRequisitions);
			quotationService.save(quotation);
		}

	}

	@Transactional
	private void getRequisition() {
		Requisition requisition = requisitionService.findByName("Requisition1");
		System.out.println("****** BEFORE getRequisition >>> " + requisition);
		List<RequisitionItem> requisitionItems = (List<RequisitionItem>) requisition.getRequisitionItems();
		for (RequisitionItem requisitionItem : requisitionItems) {
			System.out.println("****** BEFORE requisitionItem >>> " + requisitionItem);
			long id = requisitionItem.getId();
			if (id % 2 == 1) {
				deleteRequisitionItem(requisitionItem);
			}

		}

		Requisition requisition2 = requisitionService.findByName("Requisition1");
		System.out.println("****** After getRequisition >>> " + requisition2);
		List<RequisitionItem> requisitionItems2 = (List<RequisitionItem>) requisition2.getRequisitionItems();
		for (RequisitionItem requisitionItem2 : requisitionItems2) {
			System.out.println("****** After requisitionItem >>> " + requisitionItem2);
		}

		final List<RequisitionItem> requisitionItems3 = new ArrayList<>();
		for (int i = 10; i <= 15; i++) {

			final Item item = itemService.findByName("Item" + i);
			System.out.println("******** createRequisitionItem : Item >  " + item);
			final Grade grade = gradeService.findByName("Grade" + i);
			System.out.println("******** createRequisitionItem : grade >  " + grade);
			final Unit unit = unitService.findByName("Unit" + 1);
			System.out.println("******** createRequisitionItem : unit >  " + unit);
			RequisitionItem requisitionItem = new RequisitionItem();
			requisitionItem.setItem(item);
			requisitionItem.setGrade(grade);
			requisitionItem.setUnit(unit);
			requisitionItem.setQuantity(100l);
			requisitionItem.setUsedFor("Testing" + i);
			requisitionItem.setCommonAudit(getCreateCommonAudit());
			requisitionItem.setRequisition(requisition2);
			requisitionItems3.add(requisitionItem);
		}

		requisition2.setRequisitionItems(requisitionItems3);

		Project p = projectService.findByName("Project1");
		requisition2.setProject(p);
		requisitionService.save(requisition2);

		Requisition requisition3 = requisitionService.findByName("Requisition1");
		System.out.println("****** LAST getRequisition >>> " + requisition3);
		final Project p3 = requisition3.getProject();
		System.out.println("****** LAST getRequisition Project >>> " + p3);
		System.out.println("****** LAST getRequisition Users >>> " + p3.getUsers());

	}

	@Transactional
	private void deleteRequisitionItem(RequisitionItem requisitionItem) {
		requisitionItemService.deleteRequisitionItem(requisitionItem);
	}

	@Transactional
	private void createRequisition_RequisitionItems() {

		for (int i = 1; i < 5; i++) {
			final Requisition requisition = new Requisition();
			requisition.setName("Requisition" + i);
			requisition.setDescription("Requisition" + i);
			requisition.setRemark("Test" + i);
			requisition.setRequestedBy("Harshad" + i);
			try {

				String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

				requisition.setExpectedDeliveryAt(new SimpleDateFormat("dd-MM-yyyy").parse(currentDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			final List<RequisitionItem> requisitionItems = new ArrayList<>();
			for (int j = 1; j <= 3; j++) {

				final Item item = itemService.findByName("Item" + j);

				final Grade grade = gradeService.findByName("Grade" + j);

				final Unit unit = unitService.findByName("Unit" + j);

				RequisitionItem requisitionItem = new RequisitionItem();
				requisitionItem.setItem(item);
				requisitionItem.setGrade(grade);
				requisitionItem.setUnit(unit);
				requisitionItem.setQuantity(100l);
				requisitionItem.setUsedFor("Testing" + j);
				requisitionItem.setCommonAudit(getCreateCommonAudit());
				requisitionItem.setRequisition(requisition);
				requisitionItems.add(requisitionItem);
			}

			requisition.setRequisitionItems(requisitionItems);

			final Project project = projectService.findByName("Project" + i);
			requisition.setProject(project);
			final Requisition r = requisitionService.save(requisition);
			System.out.println("******** Requisition Created Successfully : " + r.getName());

		}

	}

	@Transactional
	private void createRequisitionItem() {
		final Item item = itemService.findByName("Item1");
		System.out.println("******** createRequisitionItem : Item >  " + item);
		final Grade grade = gradeService.findByName("Grade1");
		System.out.println("******** createRequisitionItem : grade >  " + grade);
		final Unit unit = unitService.findByName("Unit1");
		System.out.println("******** createRequisitionItem : unit >  " + unit);
		RequisitionItem requisitionItem = new RequisitionItem();
		requisitionItem.setItem(item);
		requisitionItem.setGrade(grade);
		requisitionItem.setUnit(unit);
		requisitionItem.setQuantity(10l);
		requisitionItem.setUsedFor("Testing 1");
		requisitionItem.setCommonAudit(getCreateCommonAudit());
		RequisitionItem r = requisitionItemService.save(requisitionItem);
		System.out.println("******** createRequisitionItem : RequisitionItem >  " + r);

	}

	@Transactional
	private void getAllItem() {
		final List<Item> items = itemService.findAll();
		for (Item item : items) {

			System.out.println("***** Item : " + item);
			List<Grade> grades = (List<Grade>) item.getGrades();
			for (Grade grade : grades) {

				System.out.println("***** Gade : " + grade);
			}

		}

	}

	private void createItem() {
		for (int i = 1; i <= 10; i++) {

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
		for (int i = 1; i <= 10; i++) {

			Grade grade = new Grade();
			grade.setName("Grade" + i);
			grade.setDescription("Grade" + i);
			grade.setCommonAudit(getCreateCommonAudit());
			gradeService.save(grade);
		}
	}

	private void createUnit() {
		for (int i = 1; i <= 10; i++) {

			Unit unit = new Unit();
			unit.setName("Unit" + i);
			unit.setDescription("Unit" + i);
			unit.setCommonAudit(getCreateCommonAudit());
			unitService.save(unit);
		}
	}

	private void createVendor() {

		VendorType vendorType = vendorTypeService.findByName("Goods");
		for (int i = 1; i <= 5; i++) {

			Bank bank = new Bank();
			bank.setName("HDFC" + i);
			bank.setBranchName("Goregaaon" + i);
			bank.setAccountNo("1534879");
			bank.setIfscCode("HDFC40001" + i);
			bank.setMicrCode("25448");

			ContactPerson contactPerson = new ContactPerson();
			contactPerson.setName("Harshad" + i);
			contactPerson.setContactNo("681012131");
			contactPerson.setEmailId("harshad.gaikwad@gmail.com");

			Vendor vendor = new Vendor();
			vendor.setName("Vendor" + i);
			vendor.setDescription("vendor" + i);
			vendor.setGstNo("gst12345");
			vendor.setAddress("Mumbai" + i);

			vendor.setBank(bank);

			vendor.setContactPerson(contactPerson);
			vendor.setVendorType(vendorType);
			final CommonAudit commonAudit = new CommonAudit();
			commonAudit.setCreatedBy("System");
			commonAudit.setCreatedAt(new Date());
			vendor.setCommonAudit(commonAudit);
			Vendor v = vendorService.save(vendor);
			System.out.println("***** Vendor Created Successfully : " + v.getName());

		}
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

		for (int i = 1; i <= 10; i++) {

			final Project project = new Project();
			project.setName("Project" + i);
			project.setDescription("Project" + i + " Desc");
			project.setActive(true);
			try {

				String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

				project.setStartDate(new SimpleDateFormat("dd-MM-yyyy").parse(currentDate));
				project.setEndDate(new SimpleDateFormat("dd-MM-yyyy").parse(currentDate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			project.setAddress("Mumbai" + i);
			project.setRemark("Test" + i);
			project.setSubDivisionName("Goregaon" + i);

			final ContactPerson contactPerson = new ContactPerson();
			contactPerson.setName("Harshad" + i);
			contactPerson.setEmailId("harshad.gaikwad@gmail.com");
			contactPerson.setContactNo("9999999");
			project.setContactPerson(contactPerson);

			final Client client = new Client();
			client.setName("client_Harshad" + i);
			client.setEmailId("charshad.gaikwad@gmail.com");
			client.setContactNo("9999999");
			project.setClient(client);

			final Architect architect = new Architect();
			architect.setName("architect_Harshad" + i);
			architect.setEmailId("aharshad.gaikwad@gmail.com");
			architect.setContactNo("9999999");
			project.setArchitect(architect);

			final Structural structural = new Structural();
			structural.setName("structural_Harshad" + i);
			structural.setEmailId("sharshad.gaikwad@gmail.com");
			structural.setContactNo("9999999");
			project.setStructural(structural);

			final CommonAudit commonAudit = new CommonAudit();
			commonAudit.setCreatedBy("System");
			commonAudit.setCreatedAt(new Date());
			project.setCommonAudit(commonAudit);
			projectService.save(project);

		}
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
