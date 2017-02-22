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
        //TODO: load ID from db or from somewhere else
        if (username.equals("")) {
            return new User(username, "",
                    AuthorityUtils
                            .commaSeparatedStringToAuthorityList("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
    }

}
