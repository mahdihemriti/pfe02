package tn.pfe.pfe02.services.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.pfe.pfe02.dto.request.SignInRequest;
import tn.pfe.pfe02.dto.request.SignUpRequest;
import tn.pfe.pfe02.dto.response.JwtAuthenticationResponse;
import tn.pfe.pfe02.entities.Role;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.repositories.IUserRepository;
import tn.pfe.pfe02.services.IAuthenticationService;
import tn.pfe.pfe02.services.IJwtService;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthenticationServiceImp implements IAuthenticationService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final IJwtService jwtService;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .dateOfBirth(request.getDateOfBirth())
                .phoneNumber(request.getPhoneNumber())
                .resume(request.getResume())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CANDIDATE).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).expiresIn(jwtService.getExpirationTime()).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).expiresIn(jwtService.getExpirationTime()).build();
    }
}
