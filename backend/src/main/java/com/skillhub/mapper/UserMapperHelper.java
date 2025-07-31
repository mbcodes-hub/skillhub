package com.skillhub.mapper;

import com.skillhub.domain.User;
import com.skillhub.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapperHelper {

    private final UserRepository userRepository;

    public UserMapperHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User mapUserIdToUser(Long userId) {
        if (userId == null) return null;
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
}