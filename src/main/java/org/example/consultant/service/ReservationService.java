package org.example.consultant.service;

import org.example.consultant.mapper.ReservationMapper;
import org.example.consultant.pojo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationMapper reservationMapper;

    public void insert(Reservation  reservation){
        reservationMapper.insert(reservation);
    }

    public Reservation selectByPhone(String phone){
        return reservationMapper.selectByPhone(phone);
    }
}
