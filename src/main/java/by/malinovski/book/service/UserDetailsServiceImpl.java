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

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


//    https://www.baeldung.com/registration-with-spring-mvc-and-spring-security

    @Autowired
    private IUserService userService;

    public UserDetailsServiceImpl() {
    }

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

    //example from spring tutorial
    @Autowired
    private UserDao userRepository;
    //
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: "+ email);
        }


      /*  boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        List list = java.util.Arrays.asList(user.getRole().toString());
        return  new org.springframework.security.core.userdetails.User
                (user.getEmail(),
                        user.getPassword().toLowerCase(), enabled, accountNonExpired,
                        credentialsNonExpired, accountNonLocked,
                        getAuthorities(list));
        */
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


    }

    private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }


}

