package ro.student.mtapo.advertisy.util;

import org.springframework.web.multipart.MultipartFile;

public class AnnouncementDetails {
    int announcementId;
    int categoryId;
    String title;
    String shortDescription;
    String longDescription;
    double price;
    int currencyId;
    MultipartFile announcementImage;

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public MultipartFile getAnnouncementImage() {
        return announcementImage;
    }

    public void setAnnouncementImage(MultipartFile announcementImage) {
        this.announcementImage = announcementImage;
    }

    @Override
    public String toString() {
        return "AnnouncementDetails{" +
                "announcementId=" + announcementId +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", price=" + price +
                ", currencyId=" + currencyId +
                '}';
    }
}
