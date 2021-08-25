package com.josimas.projectone.services.map;

import com.josimas.projectone.services.SpecialtyService;
import com.josimas.projectone.vet.Speciality;
import com.josimas.projectone.vet.Specialty;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Speciality save(Speciality specialty) {
        return super.save(specialty);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
