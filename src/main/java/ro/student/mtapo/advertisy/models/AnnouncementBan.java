package ro.student.mtapo.advertisy.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcement_ban")
public class AnnouncementBan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    Announcement announcement;

    @Column(name = "message")
    String message;

    @Column(name = "ban_date")
    Date banDate;

    public AnnouncementBan() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getBanDate() {
        return banDate;
    }

    public void setBanDate(Date reportDate) {
        this.banDate = reportDate;
    }

    @Override
    public String toString() {
        return "AnnouncementBan{" +
                "id=" + id +
                ", announcement=" + announcement +
                ", message='" + message + '\'' +
                ", banDate=" + banDate +
                '}';
    }
}
