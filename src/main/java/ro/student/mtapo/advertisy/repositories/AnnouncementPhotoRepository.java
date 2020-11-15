package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.AnnouncementPhoto;

public interface AnnouncementPhotoRepository extends JpaRepository<AnnouncementPhoto, Integer> {
}
