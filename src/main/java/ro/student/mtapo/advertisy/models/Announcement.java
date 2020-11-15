package ro.student.mtapo.advertisy.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "announcement")
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    AnnouncementCategory category;

    @Column(name = "title")
    String title;

    @Column(name = "short_description")
    String shortDescription;

    @Column(name = "long_description")
    String longDescription;

    @Column(name = "price")
    double price;

    @Column(name = "views")
    int views;

    @Column(name = "is_active")
    boolean isActive;

    @Column(name = "is_visible")
    boolean isVisible;

    @Column(name = "publication_date")
    Date publicationDate;

    public Announcement() {
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

    public AnnouncementCategory getCategory() {
        return category;
    }

    public void setCategory(AnnouncementCategory announcementCategory) {
        this.category = announcementCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", user=" + user +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", price=" + price +
                ", views=" + views +
                ", isActive=" + isActive +
                ", isVisible=" + isVisible +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
