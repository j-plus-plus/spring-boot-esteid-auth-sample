package sample.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    /**
     * In this method one should check that user with the given ID exists in the database.
     * For sample purposes we only check that the ID is of size 11 and contains only digits.
     *
     * @param id that is read from X.509 certificate
     * @return {@link User} representing the person who authenticated with certificate (it can be accessed in controller)
     */
    public UserDetails loadUserByUsername(String id) {

        // Check that is legal identification code. In production check that user with such ID exists in database.
        if (id.length() == 11 && id.matches("[0-9]+")) {
            // return new user with username as id, "" as password and without any roles.
            return new User(id, "", AuthorityUtils.NO_AUTHORITIES);
        } else {
            throw new UsernameNotFoundException(String.format("Invalid Estonian identification code: %s", id));
        }
    }
}
