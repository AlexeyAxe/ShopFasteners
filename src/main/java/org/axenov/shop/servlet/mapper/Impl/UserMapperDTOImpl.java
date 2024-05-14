package org.axenov.shop.servlet.mapper.Impl;

import org.axenov.shop.model.Order;
import org.axenov.shop.model.User;
import org.axenov.shop.servlet.dto.OrderDTO;
import org.axenov.shop.servlet.dto.UserDTO;
import org.axenov.shop.servlet.mapper.UserMapperDTO;

public class UserMapperDTOImpl implements UserMapperDTO {
    @Override
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO=new UserDTO();
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setIdUser(user.getIdUser());
        return userDTO;
    }

    @Override
    public User toUser(UserDTO userDTO) {
        User user=new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setIdUser(userDTO.getIdUser());
        return user;
    }
}
