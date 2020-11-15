package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.AnnouncementUnbanRequest;

public interface AnnouncementUnbanRequestRepository extends JpaRepository<AnnouncementUnbanRequest, Integer> {
}
