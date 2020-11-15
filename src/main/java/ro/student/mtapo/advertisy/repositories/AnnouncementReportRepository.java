package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.AnnouncementReport;

public interface AnnouncementReportRepository extends JpaRepository<AnnouncementReport, Integer> {
}
