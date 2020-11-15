package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.AnnouncementCategory;

public interface AnnouncementCategoryRepository extends JpaRepository<AnnouncementCategory, Integer> {
}
