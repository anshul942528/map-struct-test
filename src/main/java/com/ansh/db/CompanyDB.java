package com.ansh.db;

import com.ansh.model.Address;
import com.ansh.model.Employee;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CompanyDB {

    private Map<Integer, Employee> employeeTable;

    private Map<Integer, List<Address>> addressTable;

    public CompanyDB(){
        employeeTable = new HashMap<>();
        addressTable = new HashMap<>();
    }

    public Employee getEmployee(int empId) {
        if(!employeeTable.containsKey(empId))
            return null;
        return employeeTable.get(empId);
    }

    public boolean addEmployee(Employee employee) {
        if(employeeTable.containsKey(employee.getEmp_id()))
            return false;
        employeeTable.put(employee.getEmp_id(), employee);
        return true;
    }

    public List<Address> getAddress(int empId) {
        if(!employeeTable.containsKey(empId))
            return null;
        if(!addressTable.containsKey(empId))
            return new ArrayList<>();
        return addressTable.get(empId);
    }

    public boolean addAddress(int empId, Address address) {
        if(!employeeTable.containsKey(empId))
            return false;
        if(addressTable.containsKey(empId)){
            addressTable.get(empId).add(address);
        } else {
            List<Address> list = new ArrayList<>();
            list.add(address);
            addressTable.put(empId, list);
        }
        return true;
    }
}
