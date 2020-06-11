package com.ansh.controller;

import com.ansh.dto.AddressDTO;
import com.ansh.dto.EmployeeDTO;
import com.ansh.dto.response.ResponseDTO;
import com.ansh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/implicit/mapping/{emp_id}")
    public ResponseDTO getEmployee(@PathVariable("emp_id") int empId) {
        return employeeService.getEmployee(empId);
    }

    @PostMapping(value = "/implicit/mapping")
    public ResponseDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping(value = "/explicit/mapping/{emp_id}")
    public ResponseDTO getAddress(@PathVariable("emp_id") int empId) {
        return employeeService.getAddress(empId);
    }

    @PostMapping(value = "/explicit/mapping/{emp_id}")
    public ResponseDTO addAddress(@PathVariable("emp_id") int empId, @RequestBody AddressDTO addressDTO) {
        return employeeService.addAddress(empId, addressDTO);
    }

    @GetMapping(value = "multi/source/mapping/{emp_id}")
    public ResponseDTO getEmployeeInfo(@PathVariable("emp_id") int empId) {
        return employeeService.getEmployeeInfo(empId);
    }

    @GetMapping(value = "custom/method/mapping/{emp_id}")
    public ResponseDTO getEmployeeLuckyNumber(@PathVariable("emp_id") int empId) {
        return employeeService.getEmployeeLuckyNumber(empId);
    }
}
