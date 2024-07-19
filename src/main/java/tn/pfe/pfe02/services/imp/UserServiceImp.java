package tn.pfe.pfe02.services.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.pfe.pfe02.entities.User;
import tn.pfe.pfe02.generic.IGenericServiceImp;
import tn.pfe.pfe02.repositories.IUserRepository;
import tn.pfe.pfe02.services.IUserService;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp extends IGenericServiceImp<User,Integer> implements IUserService {
    private final IUserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }







}
