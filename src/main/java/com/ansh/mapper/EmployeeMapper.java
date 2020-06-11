package com.ansh.mapper;

import com.ansh.dto.EmployeeDTO;
import com.ansh.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/*
 * Implicit Mapping
 * */
@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee employeeDTOToEmployee(EmployeeDTO dto);

    EmployeeDTO employeeToEmployeeDTO(Employee employee);
}
