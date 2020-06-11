package com.ansh.mapper;

import com.ansh.dto.LuckyNumberDTO;
import com.ansh.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Random;

@Mapper
public interface LuckyNumberMapper {

    LuckyNumberMapper INSTANCE = Mappers.getMapper(LuckyNumberMapper.class);

    @Mappings({
            @Mapping(source = "emp_id", target = "id"),
            @Mapping(source = "emp_name", target = "name"),
            @Mapping(source = "emp_id", target = "luckyNumber", qualifiedByName = "lucky_number")
    })
    LuckyNumberDTO employeeToLuckyNumber(Employee employee);

    @Named("lucky_number")
    default int luckyNumber(int emp_id) {
        Random random = new Random();
        return random.ints(0, 11).findAny().getAsInt();
    }
}
