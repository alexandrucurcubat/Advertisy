package ro.student.mtapo.advertisy.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "user_photo")
public class UserPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "photo")
    byte[] photo;

    @Column(name = "mime_type")
    String mimeType;

    public UserPhoto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        return "UserPhoto{" +
                "id=" + id +
                ", user=" + user +
                ", photo=" + Arrays.toString(photo) +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}
