package ro.student.mtapo.advertisy.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcement_unban_request")
public class AnnouncementUnbanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    Announcement announcement;

    @Column(name = "message")
    String message;

    @Column(name = "request_date")
    Date requestDate;

    public AnnouncementUnbanRequest() {
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

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date reportDate) {
        this.requestDate = reportDate;
    }

    @Override
    public String toString() {
        return "AnnouncementUnbanRequest{" +
                "id=" + id +
                ", announcement=" + announcement +
                ", message='" + message + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }
}
