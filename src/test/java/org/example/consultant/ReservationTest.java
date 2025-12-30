package org.example.consultant;

import org.example.consultant.pojo.Reservation;
import org.example.consultant.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ReservationTest {
    @Autowired
    private ReservationService reservationService;
    @Test
    void addReservation(){
        reservationService.insert(new Reservation(null,
                "张三",
                "男",
                "12345678901",
                LocalDateTime.now(),
                "北京",
                100));
    }
    @Test
    void selectByPhone(){
        Reservation reservation = reservationService.selectByPhone("12345678901");
        System.out.println(reservation);
    }
}
