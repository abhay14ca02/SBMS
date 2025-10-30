package com.rajabhay.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajabhay.entity.Address;
import com.rajabhay.entity.Employee;
import com.rajabhay.repo.AddressRepository;
import com.rajabhay.repo.EmployeeRepository;

@Service
public class EmployeeAdressService {

	private EmployeeRepository employeeRepo;

	private AddressRepository addressRepo;

	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Autowired
	public void setAddressRepository(AddressRepository addressRepo) {
		this.addressRepo = addressRepo;
	}

	public void saveData() {
		Employee employee = new Employee();
		employee.setEmpName("Jabil");
		employee.setEmpSalary(1000.00);

		Address addr1 = new Address();
		addr1.setCity("Hyd");
		addr1.setState("TG");
		addr1.setType("Present");

		Address addr2 = new Address();
		addr2.setCity("Banglore");
		addr2.setState("KA");
		addr2.setType("Permanent");

		// Set Addresses to Employee
		List<Address> addrList = Arrays.asList(addr1, addr2);
		employee.setAddress(addrList);

		// Set Employee to Addresses
		addr1.setEmployee(employee);
		addr2.setEmployee(employee);

		employeeRepo.save(employee);

	}

	public void deleteEmpployee() {
		employeeRepo.deleteById(2);
	}

	public void getAddress() {
		addressRepo.findById(5);
	}

	public void getEmployee() {
		Optional<Employee> byId = employeeRepo.findById(1);
		if (byId.isPresent()) {
			Employee employee = byId.get();
			System.out.println(employee);
		}
	}
}
