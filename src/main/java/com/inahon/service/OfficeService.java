package com.inahon.service;

import com.inahon.model.Office;
import com.inahon.repository.OfficeRepositoryImpl;

import java.util.List;

public class OfficeService {
    private OfficeRepositoryImpl officeRepository;
    public OfficeService(OfficeRepositoryImpl officeRepository) {
        this.officeRepository = officeRepository;
    }
    public void createOffice(Office office) {
        officeRepository.createOffice(office);
    }
    public Office getOfficeById(int officeId) {
        return officeRepository.getOfficeById(officeId);
    }
    public List<Office> getAllOffices() {
        return officeRepository.getAllOffices();
    }
    public void updateOffice(Office office) {
        officeRepository.updateOffice(office);
    }
    public void deleteOffice(int officeId) {
        officeRepository.deleteOffice(officeId);
    }
}
