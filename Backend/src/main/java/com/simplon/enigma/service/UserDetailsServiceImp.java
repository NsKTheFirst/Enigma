package com.simplon.enigma.service;
import com.simplon.enigma.model.Person;
import com.simplon.enigma.model.Role;
import com.simplon.enigma.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository repo;
    protected UserDetailsServiceImp(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("load user by user name "+ username);
        Person person = repo.findByUsername(username);
        if (person == null){
            System.out.println("je pa trouve ce con la");
            throw new UsernameNotFoundException("with username: " + username);
        }
        return buildUser(person);
    }

    private User buildUser(Person person){
        String password = person.getPassword();
        Collection<? extends GrantedAuthority> authorities = buildAuthoroties(person.getRole());
        User userToReturn = new User(
                person.getUsername(),
                person.getPassword(),
                authorities
        );
        return userToReturn;
    }

    private Collection<GrantedAuthority> buildAuthoroties(Role role){
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        authorities.add(authority);
        return authorities;
    }
}
