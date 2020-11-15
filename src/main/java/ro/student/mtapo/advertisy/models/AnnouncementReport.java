package ro.student.mtapo.advertisy.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcement_report")
public class AnnouncementReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "announcement_id")
    Announcement announcement;

    @Column(name = "message")
    String message;

    @Column(name = "report_date")
    Date reportDate;

    public AnnouncementReport() {
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

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "AnnouncementReport{" +
                "id=" + id +
                ", announcement=" + announcement +
                ", message='" + message + '\'' +
                ", reportDate=" + reportDate +
                '}';
    }
}
