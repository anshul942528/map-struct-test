package com.ansh.mapper;

import com.ansh.dto.AddressDTO;
import com.ansh.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/*
 * Explicit Mapping
 * */
@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mappings({
            @Mapping(source = "address_line", target = "address"),
            @Mapping(source = "city_name", target = "city"),
            @Mapping(source = "dist_name", target = "dist"),
            @Mapping(source = "state_name", target = "state"),
            @Mapping(source = "pin_code", target = "zip_code")
    })
    Address addressDTOToAddress(AddressDTO dto);

    @Mappings({
            @Mapping(source = "address", target = "address_line"),
            @Mapping(source = "city", target = "city_name"),
            @Mapping(source = "dist", target = "dist_name"),
            @Mapping(target = "state_name", source = "state"),
            @Mapping(target = "pin_code", source = "zip_code")
    })
    AddressDTO addressToAddressDTO(Address address);

    List<AddressDTO> addressToAddressDTO(List<Address> address);
}
