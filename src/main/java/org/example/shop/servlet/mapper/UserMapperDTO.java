package org.example.shop.servlet.mapper;

import org.example.shop.model.User;
import org.example.shop.servlet.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperDTO {
    UserMapperDTO INSTANCE = Mappers.getMapper(UserMapperDTO.class);

    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);

}
