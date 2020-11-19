package ro.student.mtapo.advertisy.models;

import javax.persistence.*;
import java.util.Arrays;
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

    @Column(name = "image")
    byte[] image;

    @Column(name = "image_mime_type")
    String imageMimeType;

    @Column(name = "price")
    double price;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    Currency currency;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageMimeType() {
        return imageMimeType;
    }

    public void setImageMimeType(String imageMimeType) {
        this.imageMimeType = imageMimeType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean visible) {
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
                ", imageMimeType='" + imageMimeType + '\'' +
                ", price=" + price +
                ", currency=" + currency +
                ", views=" + views +
                ", isActive=" + isActive +
                ", isVisible=" + isVisible +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
