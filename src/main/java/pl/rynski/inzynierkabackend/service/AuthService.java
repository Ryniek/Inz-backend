package pl.rynski.inzynierkabackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.rynski.inzynierkabackend.dao.dto.request.UserDto;
import pl.rynski.inzynierkabackend.dao.model.User;
import pl.rynski.inzynierkabackend.dao.model.UserRole;
import pl.rynski.inzynierkabackend.exception.ResourceAlreadyExistsException;
import pl.rynski.inzynierkabackend.repository.UserRepository;
import pl.rynski.inzynierkabackend.repository.UserRoleRepository;
import pl.rynski.inzynierkabackend.utils.DateUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserDto userDto) {
        Optional<User> potentialUser = userRepository.findByEmail(userDto.getEmail());
        if(potentialUser.isPresent()) throw new ResourceAlreadyExistsException("Użytkownik", userDto.getEmail());

        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRegisterTime(DateUtils.getCurrentDateTime());

        UserRole userRole = userRoleRepository.findByName("USER");
        user.setUserRole(userRole);
        userRepository.save(user);
    }
}
