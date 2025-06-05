package fr.codecake.airbnb_clone_back.user.mapper;

import fr.codecake.airbnb_clone_back.user.application.dto.ReadUserDTO;
import fr.codecake.airbnb_clone_back.user.domain.Authority;
import fr.codecake.airbnb_clone_back.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ReadUserDTO toReadUserDTO(User user);

    default String mapAuthoritiesToString(Authority authority) {
        return authority.getName();
    }
}
