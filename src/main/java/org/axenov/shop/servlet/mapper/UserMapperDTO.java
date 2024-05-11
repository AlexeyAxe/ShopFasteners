package org.axenov.shop.servlet.mapper;

import org.axenov.shop.servlet.dto.UserDTO;
import org.axenov.shop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperDTO {
    UserMapperDTO INSTANCE = Mappers.getMapper(UserMapperDTO.class);

    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);

}
