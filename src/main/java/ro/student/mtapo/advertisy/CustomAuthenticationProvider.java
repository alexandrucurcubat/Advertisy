package ro.student.mtapo.advertisy;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ro.student.mtapo.advertisy.models.User;
import ro.student.mtapo.advertisy.repositories.UserRepository;

import java.util.Collections;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    UserRepository userRepository;
    PasswordEncoder encoder;

    public CustomAuthenticationProvider(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (userRepository.existsUserByEmail(username)) {
            User user = userRepository.findByEmail(username);
            if (encoder.matches(password, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(
                        username,
                        password,
                        Collections.singletonList(new SimpleGrantedAuthority(user.getRole().getName()))
                );
            }
            throw new BadCredentialsException("Invalid credentials.");
        }
        throw new BadCredentialsException("Invalid credentials.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
