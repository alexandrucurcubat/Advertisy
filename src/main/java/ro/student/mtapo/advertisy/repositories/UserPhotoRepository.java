package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.UserPhoto;

public interface UserPhotoRepository extends JpaRepository<UserPhoto, Integer> {
}
