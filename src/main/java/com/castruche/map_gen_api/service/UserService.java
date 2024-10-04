package com.castruche.map_gen_api.service;

import com.castruche.map_gen_api.dao.UserRepository;
import com.castruche.map_gen_api.dto.user.UserDto;
import com.castruche.map_gen_api.entity.User;
import com.castruche.map_gen_api.formatter.UserFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, UserDto>{

    private static final Logger logger = LogManager.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserFormatter userFormatter;


    public UserService(UserRepository userRepository, UserFormatter userFormatter) {
        super(userRepository, userFormatter);
        this.userRepository = userRepository;
        this.userFormatter = userFormatter;
    }

}
