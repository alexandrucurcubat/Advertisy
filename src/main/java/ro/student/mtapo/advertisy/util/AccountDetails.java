package ro.student.mtapo.advertisy.util;

import org.springframework.web.multipart.MultipartFile;

public class AccountDetails {
    String email;
    String username;
    String phone;
    String password;
    int countyId;
    String place;
    String streetAddress;
    MultipartFile userImage;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountyId() {
        return countyId;
    }

    public void setCountyId(int countyId) {
        this.countyId = countyId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public MultipartFile getUserImage() {
        return userImage;
    }

    public void setUserImage(MultipartFile userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", countyId=" + countyId +
                ", place='" + place + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", userImage=" + userImage +
                '}';
    }
}
