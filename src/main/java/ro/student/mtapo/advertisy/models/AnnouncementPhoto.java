package ro.student.mtapo.advertisy.models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "announcement_photo")
public class AnnouncementPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    Announcement announcement;

    @Column(name = "photo")
    byte[] photo;

    @Column(name = "mime_type")
    String mimeType;

    public AnnouncementPhoto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
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
        return "AnnouncementPhoto{" +
                "id=" + id +
                ", announcement=" + announcement +
                ", photo=" + Arrays.toString(photo) +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}
