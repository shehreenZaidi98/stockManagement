package com.stockManagement.tickerData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class TickerDataController {
@Autowired
    TickerDataepository tickerDataepository;
@PostMapping("insertTicker")
    public String insertTicker(@RequestBody TickerData tickerData){
    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    tickerDataepository.insertTicker(sdf.format(date), tickerData.getComp_tittle(),tickerData.getDirection(),
            tickerData.getOrder_type(),tickerData.getEntry_price(),tickerData.getCalculated_stop_loss(),
            tickerData.getNumber_of_shares());
    return "save";
}
}
