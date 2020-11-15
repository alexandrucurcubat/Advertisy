package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.AnnouncementBan;

public interface AnnouncementBanRepository extends JpaRepository<AnnouncementBan, Integer> {
}
