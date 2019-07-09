package fr.formation.students.services;

import fr.formation.students.dtos.UserCreateDto;
import fr.formation.students.dtos.UserUpdateDto;
import fr.formation.students.dtos.UserViewDto;
import fr.formation.students.entities.Person;
import fr.formation.students.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;

    private final PersonRepository personRepository;

    public UserServiceImpl(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private static ModelMapper getModelMapperInstance() {
        return new ModelMapper();
    }

    @Override
    public void createUser(UserCreateDto userDto) {
        Person personToSave = getModelMapperInstance().map(userDto, Person.class);
        //System.out.println("person to save in user service "+personToSave.toString());
        String newPass = passwordEncoder.encode(userDto.getUserAccount().getPassword());
        personToSave.getUserAccount().setPassword(newPass);
        //if (isValid(userDto.getUserAccount().getUsername(),))
        personRepository.save(personToSave);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(UserUpdateDto dto) {
        Person person = personRepository.findById(dto.getId()).get();
        person.setBirthDate(dto.getBirthDate());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        personRepository.save(person);
    }

    @Override
    public Page<UserViewDto> findAll(Integer size, Integer page) {
        Pageable pageable = PageRequest.of(page, size);
        return personRepository.findAllAsDto(pageable);
    }


    public void updateUser(UserUpdateDto userUp) {
        Person person = personRepository.findById(userUp.getId()).get();
        getModelMapperInstance().map(userUp, person);
        personRepository.save(person);
    }

}

