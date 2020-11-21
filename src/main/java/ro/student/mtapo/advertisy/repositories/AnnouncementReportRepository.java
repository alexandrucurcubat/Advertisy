package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.AnnouncementReport;

import java.util.List;

public interface AnnouncementReportRepository extends JpaRepository<AnnouncementReport, Integer> {
    List<AnnouncementReport> findAllByOrderByReportDateDesc();
}
