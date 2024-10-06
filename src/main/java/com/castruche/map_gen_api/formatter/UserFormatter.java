package com.castruche.map_gen_api.formatter;

import com.castruche.map_gen_api.dto.user.UserDto;
import com.castruche.map_gen_api.dto.util.ConnectedUserDto;
import com.castruche.map_gen_api.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFormatter implements IFormatter<User, UserDto, UserDto>{

    @Override
    public UserDto entityToDto(User entity) {
        if(entity == null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setUsername(entity.getUsername());
        userDto.setEmail(entity.getEmail());
        userDto.setFirstName(entity.getFirstName());
        userDto.setLastName(entity.getLastName());
        userDto.setMailVerified(entity.isMailVerified());
        return userDto;
    }

    @Override
    public UserDto entityToLightDto(User user) {
        return null;
    }

    @Override
    public User dtoToEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        return user;
    }

    @Override
    public List entityToLightDto(List list) {
        return IFormatter.super.entityToLightDto(list);
    }

    @Override
    public List<UserDto> entityToDto(List list) {
        return IFormatter.super.entityToDto(list);
    }

    public ConnectedUserDto entityToConnectedUserDto(User entity) {
        if(entity == null){
            return null;
        }
        ConnectedUserDto dto = new ConnectedUserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        return dto;
    }
}
