package org.example.consultant.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.example.consultant.pojo.Reservation;
import org.example.consultant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReservationTool {
    @Autowired
    private ReservationService reservationService;

    @Tool("添加志愿指导服务预约")
    public void addReservation(
            @P("考生姓名") String name,
            @P("考生性别")String gender,
            @P("考生电话")String phone,
            @P("考生联系时间")LocalDateTime communicationTime,
            @P("考生省份")String province,
            @P("考生预估分数")Integer estimatedScore
    ){
        reservationService.insert(new Reservation(null,
                name,
                gender,
                phone,
                communicationTime,
                province,
                estimatedScore)
        );
    }

    @Tool("根据手机号查询志愿指导服务预约")
    public Reservation selectByPhone(@P("手机号")String phone){
        return reservationService.selectByPhone(phone);
    }
}
