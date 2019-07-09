package com.simplon.enigma.service;

import fr.formation.students.entities.Person;
import fr.formation.students.entities.UserAccount;
import fr.formation.students.enumeration.Role;
import fr.formation.students.repository.PersonRepository;
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

    private final PersonRepository repo;
    protected UserDetailsServiceImp(PersonRepository repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("load user by user name "+ username);
        Person person = repo.findByUserAccountUsername(username);
        if (person == null){
            throw new UsernameNotFoundException("with username: " + username);
        }
        return buildUser(person);
    }

    private User buildUser(Person person){
        UserAccount userAccount = person.getUserAccount();
        String password = userAccount.getPassword();
        Collection<? extends GrantedAuthority> authorities = buildAuthoroties(userAccount.getRole());
        User userToReturn = new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getEnabled(),
                userAccount.isAccountNonExpired(),
                userAccount.isCredentialsNonExpired(),
                userAccount.isAccountNonLocked(),
                authorities
        );
        //System.out.println("user builer ______-----------"+ userToReturn.toString());
        return userToReturn;
    }

    private Collection<GrantedAuthority> buildAuthoroties(Role role){
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role.name());
        authorities.add(authority);
        return authorities;
    }
}
