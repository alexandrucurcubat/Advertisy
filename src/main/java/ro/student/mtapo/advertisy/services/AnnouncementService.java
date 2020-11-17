package ro.student.mtapo.advertisy.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.student.mtapo.advertisy.models.Announcement;
import ro.student.mtapo.advertisy.models.AnnouncementCategory;
import ro.student.mtapo.advertisy.repositories.AnnouncementCategoryRepository;
import ro.student.mtapo.advertisy.repositories.AnnouncementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {

    AnnouncementRepository announcementRepository;
    AnnouncementCategoryRepository announcementCategoryRepository;

    public AnnouncementService(AnnouncementRepository announcementRepository, AnnouncementCategoryRepository announcementCategoryRepository) {
        this.announcementRepository = announcementRepository;
        this.announcementCategoryRepository = announcementCategoryRepository;
    }

    public List<Announcement> getAnnouncements() {
        return announcementRepository.findAll();
    }

    public Announcement getAnnouncementById(int id) {
        Optional<Announcement> optionalAnnouncement = announcementRepository.findById(id);
        return optionalAnnouncement.orElse(null);
    }

    public List<AnnouncementCategory> getAnnouncementCategories() {
        return announcementCategoryRepository.findAll();
    }

    public AnnouncementCategory getAnnouncementCategoryByAnnouncementId(int id) {
        Announcement announcement = getAnnouncementById(id);
        if (announcement != null) {
            return announcement.getCategory();
        }
        return null;
    }

    public List<Announcement> getAnnouncementsByCategoryId(int id) {
        return announcementRepository.findByCategory_Id(id);
    }

    public ResponseEntity<byte[]> getAnnouncementImage(int id) {
        Announcement announcement = getAnnouncementById(id);
        if (announcement != null) {
            byte[] image = announcement.getImage();
            String mimeType = announcement.getImageMimeType();
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(mimeType));
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }
        return null;
    }

}
