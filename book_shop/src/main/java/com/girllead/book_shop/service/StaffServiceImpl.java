package com.girllead.book_shop.service;

import com.girllead.book_shop.models.dtos.BookByStaffDto;
import com.girllead.book_shop.models.dtos.StaffDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Override
    public List<StaffDto> getStaff() {
        return List.of();
    }

    @Override
    public StaffDto hireStaff(StaffDto staffDto) {
        return null;
    }

    @Override
    public String fireStaff(Long id) {
        return "";
    }

    @Override
    public BookByStaffDto getBookByStaff(Long staffId) {
        return null;
    }
}
