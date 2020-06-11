package com.ansh.service;

import com.ansh.db.CompanyDB;
import com.ansh.dto.AddressDTO;
import com.ansh.dto.EmployeeDTO;
import com.ansh.dto.EmployeeInfoDTO;
import com.ansh.dto.LuckyNumberDTO;
import com.ansh.dto.response.ResponseDTO;
import com.ansh.mapper.AddressMapper;
import com.ansh.mapper.EmployeeInfoMapper;
import com.ansh.mapper.EmployeeMapper;
import com.ansh.mapper.LuckyNumberMapper;
import com.ansh.model.Address;
import com.ansh.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private CompanyDB companyDB;

    public ResponseDTO getEmployee(int empId) {
        ResponseDTO responseDTO = new ResponseDTO();
        Employee employee = companyDB.getEmployee(empId);
        if(employee == null){
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Employee does not exists");
            return responseDTO;
        }
        EmployeeDTO employeeDTO = EmployeeMapper.INSTANCE.employeeToEmployeeDTO(employee);
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("Employee detail");
        responseDTO.setResult(employeeDTO);
        return responseDTO;
    }

    public ResponseDTO addEmployee(EmployeeDTO employeeDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        Employee employee = EmployeeMapper.INSTANCE.employeeDTOToEmployee(employeeDTO);
        if(!companyDB.addEmployee(employee)){
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Employee already exists");
            return responseDTO;
        }
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("Employee added successfully");
        responseDTO.setResult(employeeDTO);
        return responseDTO;
    }

    public ResponseDTO getAddress(int empId){
        ResponseDTO responseDTO = new ResponseDTO();
        List<Address> addresses = companyDB.getAddress(empId);
        if(addresses == null) {
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Employee does not exists");
            return responseDTO;
        } else if(addresses.isEmpty()) {
            responseDTO.setStatus("SUCCESS");
            responseDTO.setMessage("Address does not exists, for this employee");
            return responseDTO;
        }
        List<AddressDTO> list = AddressMapper.INSTANCE.addressToAddressDTO(addresses);
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("Address detail");
        responseDTO.setResult(list);
        return responseDTO;
    }

    public ResponseDTO addAddress(int empId, AddressDTO addressDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        Address address = AddressMapper.INSTANCE.addressDTOToAddress(addressDTO);
        if(!companyDB.addAddress(empId, address)){
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Employee does not exists");
            return responseDTO;
        }
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("Address added successfully");
        responseDTO.setResult(addressDTO);
        return responseDTO;
    }

    public ResponseDTO getEmployeeInfo(int empId) {
        ResponseDTO responseDTO = new ResponseDTO();
        Employee employee = companyDB.getEmployee(empId);
        if(employee == null){
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Employee does not exists");
            return responseDTO;
        }
        List<Address> addresses = companyDB.getAddress(empId);
        if(addresses.isEmpty()) {
            responseDTO.setStatus("SUCCESS");
            responseDTO.setMessage("Address does not exists, for this employee");
            return responseDTO;
        }
        EmployeeInfoDTO employeeInfoDTO = EmployeeInfoMapper.INSTANCE.mapToEmployeeInfoDTO(employee, addresses.get(0));
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("Employee Information");
        responseDTO.setResult(employeeInfoDTO);
        return responseDTO;
    }

    public ResponseDTO getEmployeeLuckyNumber(int empId) {
        ResponseDTO responseDTO = new ResponseDTO();
        Employee employee = companyDB.getEmployee(empId);
        if(employee == null){
            responseDTO.setStatus("FAILURE");
            responseDTO.setMessage("Employee does not exists");
            return responseDTO;
        }
        LuckyNumberDTO luckyNumberDTO = LuckyNumberMapper.INSTANCE.employeeToLuckyNumber(employee);
        responseDTO.setStatus("SUCCESS");
        responseDTO.setMessage("Employee Information");
        responseDTO.setResult(luckyNumberDTO);
        return responseDTO;
    }
}
