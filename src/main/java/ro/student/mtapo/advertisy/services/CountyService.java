package ro.student.mtapo.advertisy.services;

import org.springframework.stereotype.Service;
import ro.student.mtapo.advertisy.models.County;
import ro.student.mtapo.advertisy.repositories.CountyRepository;

import java.util.List;

@Service
public class CountyService {

    CountyRepository countyRepository;

    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public List<County> getAllCounties() {
        return countyRepository.findAll();
    }
}
