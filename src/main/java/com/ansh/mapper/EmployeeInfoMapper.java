package com.ansh.mapper;

import com.ansh.dto.EmployeeInfoDTO;
import com.ansh.model.Address;
import com.ansh.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/*
* Multi source Mapping
* */
@Mapper
public interface EmployeeInfoMapper {

    EmployeeInfoMapper INSTANCE = Mappers.getMapper(EmployeeInfoMapper.class);

    @Mappings({
            @Mapping(source = "employee.emp_id", target = "id"),
            @Mapping(source = "employee.emp_name", target = "name"),
            @Mapping(source = "employee.department", target = "department"),
            @Mapping(source = "address.address", target = "address"),
            @Mapping(source = "address.city", target = "city"),
            @Mapping(source = "address.state", target = "state"),
            @Mapping(source = "address.zip_code", target = "zipCode")
    })
    EmployeeInfoDTO mapToEmployeeInfoDTO(Employee employee, Address address);
}
