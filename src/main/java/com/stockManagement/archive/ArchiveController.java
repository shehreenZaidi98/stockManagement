package com.stockManagement.archive;

import com.stockManagement.stock.StockMarketing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ArchiveController {
@Autowired
    ArchiveRepository archiveRepository;
@RequestMapping(value = {"/insertArchive"},method = RequestMethod.POST)
public String insertArchive(@RequestBody Archive archive) {

    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    List<Archive> getDetails = archiveRepository.getData(archive.getCompany_code(), sdf.format(date));
    String message = "Unsuccessful";
    System.out.println(sdf.format(date));
    if (getDetails.size() > 0) {
        int update = archiveRepository.updateArchive(archive.getAverage_volume(),
                archive.getEarning_date(), archive.getAtr(), archive.getDirection(),
                archive.getMultiplier(), archive.getEntry_price(), archive.getStop_loss(),
                archive.getOrder_type(), archive.getType(), archive.getCompany_code(), sdf.format(date));
        if (update > 0) {
            message = "updated";
        }
    } else {
        int insert = archiveRepository.insertArchive(archive.getCompany_code(),
                archive.getAverage_volume(), archive.getEarning_date(),
                archive.getAtr(), archive.getDirection(), archive.getMultiplier(),
                archive.getEntry_price(), archive.getStop_loss(), archive.getOrder_type(),
                sdf.format(date), archive.getType());

        if (insert > 0) {
            message = "inserted";
        }
    }
    return message;
}
    @RequestMapping(value = {"/getLatestDate"},method = RequestMethod.GET)
    public Map<String, List<Archive>> getLatestData(@RequestParam("date")String date,
                                                           @RequestParam("to")String to){
    /*Date date=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");*/
        List<Archive>getDetails=archiveRepository.getDate(date,to);


        HashMap<String, List<Archive>> hMap = new HashMap<>();
        hMap.put("sData", getDetails);
        return hMap;

    }
}
