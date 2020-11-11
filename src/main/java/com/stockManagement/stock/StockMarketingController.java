package com.stockManagement.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StockMarketingController {
@Autowired
    StockMarketingRepository stockMarketingRepository;
@PostMapping("/insertStock")
        public String insertStock(@RequestBody StockMarketing stockMarketing) {

    Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    List<StockMarketing>getDetails=stockMarketingRepository.getDate(stockMarketing.getCompany_code(),sdf.format(date));
        String message="Unsuccessful";
        System.out.println(sdf.format(date));
        if(getDetails.size()>0){
            int update=stockMarketingRepository.updateStock(stockMarketing.getAverage_volume(),
                    stockMarketing.getEarning_date(),stockMarketing.getAtr(),stockMarketing.getDirection(),
                    stockMarketing.getMultiplier(),stockMarketing.getEntry_price(),stockMarketing.getStop_loss(),
                    stockMarketing.getOrder_type(),stockMarketing.getCompany_code(),sdf.format(date));
            if (update > 0) {
                message = "updated";
            }
        }else {
            int insert = stockMarketingRepository.insertStock(stockMarketing.getCompany_code(),
                    stockMarketing.getAverage_volume(),stockMarketing.getEarning_date(),
                    stockMarketing.getAtr(),stockMarketing.getDirection(),stockMarketing.getMultiplier(),
                    stockMarketing.getEntry_price(),stockMarketing.getStop_loss(),stockMarketing.getOrder_type(),
                    sdf.format(date));

            if (insert > 0) {
                message = "inserted";
            }
        }
    return message;
}

    @GetMapping("/getLatestData")
    public Map<String, List<StockMarketing>> getLatestData(@RequestParam("date")String date){
    /*Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");*/
    List<StockMarketing>getDetails=stockMarketingRepository.getDate(date);


        HashMap<String, List<StockMarketing>> hMap = new HashMap<>();
        hMap.put("sData", getDetails);
        return hMap;

    }

}
