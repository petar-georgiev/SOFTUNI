package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.entity.UserEntity;
import bg.softuni.mobilele.model.entity.UserRoleEntity;
import bg.softuni.mobilele.model.user.MobileleUserDetails;
import bg.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MobileleUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public MobileleUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
    //mapping our user representation (UserEntity)
    //to the user representation in the spring security world (User Details).
    //The only thing that spring will provide to us is the username.
    //The username wil come from the HTML login form.

    return userRepository.
        findByEmail(email).
        map(this::mapToUserDetails).
        orElseThrow(() -> new UsernameNotFoundException("User with email " + email    + " not found!"));
  }

  private UserDetails mapToUserDetails(UserEntity userEntity) {

    return new MobileleUserDetails(
        userEntity.getPassword(),
        userEntity.getEmail(),
        userEntity.getFirstName(),
        userEntity.getLastName(),
        userEntity.
            getUserRoles().
            stream().
            map(this::map).
            toList()
    );
  }

  private GrantedAuthority map(UserRoleEntity userRole) {
    //GrantedAuthority is the representation of a user role in the spring world.
    //SimpleGrantedAuthority is an implementation of GrantedAuthority
    //which spring provides for our convenience.
    //Our representation of role is UserRoleEntity.

    return new SimpleGrantedAuthority("ROLE_" +
        userRole.
            getUserRole().name());
  }
}
