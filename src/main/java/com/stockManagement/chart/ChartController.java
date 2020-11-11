package com.stockManagement.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class ChartController {
    @Autowired
    ChartRepository chartRepository;
    @PostMapping("/insertChart")
    public String insertChart(@RequestBody Chart chart){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Chart> getChart=chartRepository.getChart(chart.getCompany_code(),sdf.format(date));
        String message = "Unsuccessful";
        if(getChart.size()>0){
            message="already exist";

        }else{
            int insert= chartRepository.insertChart(chart.getTime_stamp(),chart.getClose(),chart.getOpen(),chart.getLow(),chart.getHigh(),
                chart.getCompany_code(),sdf.format(date));
            if(insert>0){
                message="inserted";
            }
        }
         return message;
}
}
