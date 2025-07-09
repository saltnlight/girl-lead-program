package com.girllead.book_shop.service;

import com.girllead.book_shop.models.dtos.BookByStaffDto;
import com.girllead.book_shop.models.dtos.StaffDto;

import java.util.List;

public interface StaffService {
    List<StaffDto> getStaff();
    StaffDto hireStaff(StaffDto staffDto);
    String fireStaff(Long id);
    BookByStaffDto getBookByStaff(Long staffId);
}
