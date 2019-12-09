package mx.com.proyecti;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import mx.com.proyecti.dto.EmployeeFullnameDTO;
import mx.com.proyecti.entity.Employee;
import mx.com.proyecti.manager.EmployeeManager;

@WebService
public class EmployeeSoap {
	
	EmployeeManager manager = new EmployeeManager();
	
	public EmployeeSoap() {
		
	}
	
	@WebMethod
	public Integer create(
			@WebParam(name="firstName") String firstName, 
			@WebParam(name="lastName") String lastName, 
			@WebParam(name="birthDate") Date birthdate, 
			@WebParam(name="salary") double salary) {
		manager.setup();
		Integer id = manager.create(firstName, lastName, birthdate, salary);
		manager.exit();
		return id;
	}
	
	/*@WebMethod
	public Employee read(int id) {
		//Cuerpo de la operación
	}*/
	
	@WebMethod
	public EmployeeFullnameDTO readFullname(@WebParam(name="id") int id) {
		manager.setup();
		Employee employee = manager.read(id);
		EmployeeFullnameDTO employeeFullName = new EmployeeFullnameDTO();
		employeeFullName.setId(employee.getId());
		employeeFullName.setFullName(employee.getFirstName() + " " + employee.getLastName());
		
		manager.exit();
		return employeeFullName;
	}
}
