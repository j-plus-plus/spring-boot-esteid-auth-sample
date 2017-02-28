package sample.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String username) {

        if (username.length() == 11 && username.matches("[0-9]+"))
            return new User(username, "", AuthorityUtils.NO_AUTHORITIES);
        else
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
    }

}
