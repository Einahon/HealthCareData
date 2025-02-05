package com.inahon.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "Offices")
@Data
@NoArgsConstructor
@ToString(exclude = "doctor")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OfficeID")
    private int officeId;

    @Column(name = "Location")
    private String location;

    @Column(name = "Phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DoctorID", nullable = true)
    Doctor doctor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return officeId == office.officeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(officeId);
    }
}
