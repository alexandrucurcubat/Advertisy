package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.AnnouncementUnbanRequest;

import java.util.List;

public interface AnnouncementUnbanRequestRepository extends JpaRepository<AnnouncementUnbanRequest, Integer> {
    List<AnnouncementUnbanRequest> findAllByOrderByRequestDateDesc();
}
