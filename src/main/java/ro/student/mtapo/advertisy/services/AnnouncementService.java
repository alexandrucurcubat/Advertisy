package ro.student.mtapo.advertisy.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ro.student.mtapo.advertisy.models.*;
import ro.student.mtapo.advertisy.repositories.*;
import ro.student.mtapo.advertisy.util.AnnouncementDetails;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnnouncementService {

    AnnouncementRepository announcementRepository;
    AnnouncementCategoryRepository announcementCategoryRepository;
    CurrencyRepository currencyRepository;
    AnnouncementReportRepository announcementReportRepository;
    AnnouncementUnbanRequestRepository announcementUnbanRequestRepository;

    public AnnouncementService(
            AnnouncementRepository announcementRepository,
            AnnouncementCategoryRepository announcementCategoryRepository,
            CurrencyRepository currencyRepository,
            AnnouncementReportRepository announcementReportRepository,
            AnnouncementUnbanRequestRepository announcementUnbanRequestRepository
    ) {
        this.announcementRepository = announcementRepository;
        this.announcementCategoryRepository = announcementCategoryRepository;
        this.currencyRepository = currencyRepository;
        this.announcementReportRepository = announcementReportRepository;
        this.announcementUnbanRequestRepository = announcementUnbanRequestRepository;
    }

    public List<Announcement> getVisibleAndActiveAnnouncements() {
        return announcementRepository.findByIsActiveTrueAndIsVisibleTrue();
    }

    public Announcement getAnnouncementById(int announcementId) {
        Optional<Announcement> optionalAnnouncement = announcementRepository.findById(announcementId);
        return optionalAnnouncement.orElse(null);
    }

    public List<AnnouncementCategory> getAnnouncementCategories() {
        return announcementCategoryRepository.findAll();
    }

    public AnnouncementCategory getAnnouncementCategoryByAnnouncementId(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        if (announcement != null) {
            return announcement.getCategory();
        }
        return null;
    }

    public AnnouncementCategory getAnnouncementCategoryById(int categoryId) {
        Optional<AnnouncementCategory> optionalAnnouncementCategory = announcementCategoryRepository.findById(categoryId);
        return optionalAnnouncementCategory.orElse(null);
    }

    public List<Announcement> getAnnouncementsByCategoryId(int categoryId) {
        return announcementRepository.findByCategory_Id(categoryId);
    }

    public List<Announcement> getAnnouncementsByUserId(int userId) {
        return announcementRepository.findByUser_Id(userId);
    }

    public ResponseEntity<byte[]> getAnnouncementImage(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        if (announcement != null) {
            byte[] image = announcement.getImage();
            String mimeType = announcement.getImageMimeType();
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(mimeType));
            return new ResponseEntity<>(image, headers, HttpStatus.OK);
        }
        return null;
    }

    public List<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(int currencyId) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(currencyId);
        return optionalCurrency.orElse(null);
    }

    public Announcement updateAnnouncement(AnnouncementDetails details) throws IOException {
        Announcement announcement = getAnnouncementById(details.getAnnouncementId());
        if (announcement != null) {
            announcement.setCategory(getAnnouncementCategoryById(details.getCategoryId()));
            announcement.setTitle(details.getTitle());
            announcement.setShortDescription(details.getShortDescription());
            announcement.setLongDescription(details.getLongDescription());
            announcement.setPrice(details.getPrice());
            announcement.setCurrency(getCurrencyById(details.getCurrencyId()));
            if (!Objects.equals(details.getAnnouncementImage().getContentType(), "application/octet-stream")) {
                announcement.setImage(details.getAnnouncementImage().getBytes());
                announcement.setImageMimeType(details.getAnnouncementImage().getContentType());
            }
            return announcementRepository.save(announcement);
        }
        return null;
    }

    public void deleteAnnouncement(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        if (announcement != null)
            announcementRepository.delete(announcement);
    }

    public void hideAnnouncement(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        if (announcement != null) {
            announcement.setIsVisible(false);
            announcementRepository.save(announcement);
        }
    }

    public void showAnnouncement(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        if (announcement != null) {
            announcement.setIsVisible(true);
            announcementRepository.save(announcement);
        }
    }

    public Announcement createAnnouncement(AnnouncementDetails details, User user) throws IOException {
        Announcement announcement = new Announcement();
        announcement.setUser(user);
        announcement.setCategory(getAnnouncementCategoryById(details.getCategoryId()));
        announcement.setTitle(details.getTitle());
        announcement.setShortDescription(details.getShortDescription());
        announcement.setLongDescription(details.getLongDescription());
        announcement.setPrice(details.getPrice());
        announcement.setCurrency(getCurrencyById(details.getCurrencyId()));
        if (!Objects.equals(details.getAnnouncementImage().getContentType(), "application/octet-stream")) {
            announcement.setImage(details.getAnnouncementImage().getBytes());
            announcement.setImageMimeType(details.getAnnouncementImage().getContentType());
        }
        announcement.setViews(0);
        announcement.setIsActive(true);
        announcement.setIsVisible(true);
        return announcementRepository.save(announcement);
    }

    public void incrementViewCount(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        announcement.setViews(announcement.getViews() + 1);
        announcementRepository.save(announcement);
    }

    public List<Announcement> searchAnnouncements(String queryString) {
        return announcementRepository.findAllByTitleContaining(queryString);
    }

    public AnnouncementReport reportAnnouncement(AnnouncementDetails details) {
        AnnouncementReport report = new AnnouncementReport();
        Announcement announcement = getAnnouncementById(details.getAnnouncementId());
        report.setAnnouncement(announcement);
        report.setMessage(details.getMessage());
        return announcementReportRepository.save(report);
    }

    public AnnouncementUnbanRequest unbanAnnouncementRequest(AnnouncementDetails details) {
        AnnouncementUnbanRequest unbanRequest = new AnnouncementUnbanRequest();
        Announcement announcement = getAnnouncementById(details.getAnnouncementId());
        unbanRequest.setAnnouncement(announcement);
        unbanRequest.setMessage(details.getMessage());
        return announcementUnbanRequestRepository.save(unbanRequest);
    }

    public List<AnnouncementReport> getAnnouncementReports() {
        return announcementReportRepository.findAllByOrderByReportDateDesc();
    }

    public List<AnnouncementUnbanRequest> getAnnouncementUnbanRequests() {
        return announcementUnbanRequestRepository.findAllByOrderByRequestDateDesc();
    }

    public void activateAnnouncement(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        announcement.setIsActive(true);
        announcementRepository.save(announcement);
    }

    public void deactivateAnnouncement(int announcementId) {
        Announcement announcement = getAnnouncementById(announcementId);
        announcement.setIsActive(false);
        announcementRepository.save(announcement);
    }

    public void deleteAnnouncementReport(int reportId) {
        Optional<AnnouncementReport> optionalReport = announcementReportRepository.findById(reportId);
        optionalReport.ifPresent(announcementReport -> announcementReportRepository.delete(announcementReport));
    }

    public void deleteAnnouncementUnbanRequest(int unbanRequestId) {
        Optional<AnnouncementUnbanRequest> optionalUnbanRequest = announcementUnbanRequestRepository.findById(unbanRequestId);
        optionalUnbanRequest.ifPresent(announcementReport -> announcementUnbanRequestRepository.delete(announcementReport));
    }
}
