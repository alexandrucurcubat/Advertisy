package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
}
