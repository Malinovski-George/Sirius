package by.malinovski.book.service;

import by.malinovski.book.dao.UserDao;
import by.malinovski.book.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  //    https://www.baeldung.com/registration-with-spring-mvc-and-spring-security

  @Autowired private IUserService userService;

  public UserDetailsServiceImpl() {}

  public UserDetailsServiceImpl(IUserService userService) {
    this.userService = userService;
  }

  /* @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

      User user = userService.getUserByEmail(email);
      String mail = "user error";
      String password = "password error";

      Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
      if (user != null) {
          String role = user.getRole().toString();
          grantedAuthorities.add(new SimpleGrantedAuthority(role));
          mail = user.getEmail();
          password = user.getPassword();

      }
      return new org.springframework.security.core.userdetails.User(mail, password, grantedAuthorities);
  }*/

  @Autowired private UserDao userRepository;

  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    User user = userRepository.getUserByEmail(email);
    if (user == null) {
      throw new UsernameNotFoundException("No user found with username: " + email);
    }

    String mail = "user error";
    String password = "password error";
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    if (user != null) {
      String role = user.getRole().toString();
      grantedAuthorities.add(new SimpleGrantedAuthority(role));
      mail = user.getEmail();
      password = user.getPassword();
    }
    return new org.springframework.security.core.userdetails.User(
        mail, password, grantedAuthorities);
  }

  private static List<GrantedAuthority> getAuthorities(List<String> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (String role : roles) {
      authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
  }
}
