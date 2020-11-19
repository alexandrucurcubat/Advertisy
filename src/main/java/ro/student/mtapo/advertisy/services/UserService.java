package ro.student.mtapo.advertisy.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.student.mtapo.advertisy.models.Address;
import ro.student.mtapo.advertisy.models.County;
import ro.student.mtapo.advertisy.models.User;
import ro.student.mtapo.advertisy.repositories.AddressRepository;
import ro.student.mtapo.advertisy.repositories.CountyRepository;
import ro.student.mtapo.advertisy.repositories.RoleRepository;
import ro.student.mtapo.advertisy.repositories.UserRepository;
import ro.student.mtapo.advertisy.util.AccountDetails;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;
    AddressRepository addressRepository;
    CountyRepository countyRepository;
    RoleRepository roleRepository;
    PasswordEncoder encoder;

    public UserService(
            UserRepository userRepository,
            AddressRepository addressRepository,
            CountyRepository countyRepository,
            RoleRepository roleRepository,
            PasswordEncoder encoder
    ) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.countyRepository = countyRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public User createAccount(AccountDetails details) throws IOException {
        boolean userAlreadyExists = userRepository.existsUserByEmail(details.getEmail());
        if (userAlreadyExists) {
            return null;
        }
        User newUser = new User();
        newUser.setActive(true);
        newUser.setRole(roleRepository.getOne(1));
        newUser.setEmail(details.getEmail());
        newUser.setUsername(details.getUsername());
        newUser.setPhone(details.getPhone());
        newUser.setPassword(encoder.encode(details.getPassword()));
        if (!Objects.equals(details.getUserImage().getContentType(), "application/octet-stream")) {
            newUser.setImage(details.getUserImage().getBytes());
            newUser.setImageMimeType(details.getUserImage().getContentType());
        }
        Address address = new Address();
        County newUserCounty = getCountyById(details.getCountyId());
        address.setCounty(newUserCounty);
        address.setPlace(details.getPlace());
        address.setStreetAddress(details.getStreetAddress());
        address = addressRepository.save(address);
        newUser.setAddress(address);
        return userRepository.save(newUser);
    }

    public User updateAccount(AccountDetails details) throws IOException {
        User user = userRepository.findByEmail(details.getEmail());
        boolean isAuthenticated = encoder.matches(details.getPassword(), user.getPassword());
        if (!isAuthenticated) {
            return null;
        }
        user.setUsername(details.getUsername());
        user.setPhone(details.getPhone());
        if (!Objects.equals(details.getUserImage().getContentType(), "application/octet-stream")) {
            user.setImage(details.getUserImage().getBytes());
            user.setImageMimeType(details.getUserImage().getContentType());
        }
        Address address = user.getAddress();
        address.setCounty(getCountyById(details.getCountyId()));
        address.setPlace(details.getPlace());
        address.setStreetAddress(details.getStreetAddress());
        address = addressRepository.save(address);
        user.setAddress(address);
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }

    public County getCountyById(int countyId) {
        Optional<County> optionalCounty = countyRepository.findById(countyId);
        return optionalCounty.orElse(null);
    }

    public ResponseEntity<byte[]> getUserImage(int userId) {
        User user = getUserById(userId);
        if (user != null) {
            byte[] image = user.getImage();
            String mimeType = user.getImageMimeType();
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(mimeType));
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }
        return null;
    }
}
