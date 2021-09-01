package com.josimas.projectone.vet;

import com.josimas.projectone.model.Person;
import lombok.*;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.util.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> specialities = new HashSet<>();

    protected Set<Speciality> getSpecialtiesInternal(){
        if (this.specialities == null){
            this.specialities = new HashSet<>();
        }

        return this.specialities;
    }

    protected void setSpecialtiesInternal(Set<Speciality> specialities){
        this.specialities = specialities;
    }

    public int getNrOfSpecialties(){
        return getSpecialtiesInternal().size();
    }

    public void addSpecialty(Speciality speciality){
        getSpecialtiesInternal().add(speciality);
    }
}
