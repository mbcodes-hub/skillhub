package com.skillhub.service;

import com.skillhub.domain.User;
import com.skillhub.dto.UserCreateDto;
import com.skillhub.dto.UserDetailsDto;
import com.skillhub.dto.UserDto;
import com.skillhub.mapper.UserMapper;
import com.skillhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDetailsDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDetailsDto)
                .orElse(null);
    }

    public UserDto createUser(UserCreateDto userCreateDto) {
        User user = userMapper.toEntity(userCreateDto);
        user.setRole("USER");
        return userMapper.toDto(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
