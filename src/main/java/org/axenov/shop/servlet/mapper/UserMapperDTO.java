package org.axenov.shop.servlet.mapper;

import ch.qos.logback.core.joran.spi.DefaultClass;
import org.axenov.shop.servlet.dto.UserDTO;
import org.axenov.shop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface UserMapperDTO {

    UserDTO toUserDTO(User user);

   User toUser(UserDTO userDTO);

}
