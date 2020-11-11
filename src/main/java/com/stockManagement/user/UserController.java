package com.stockManagement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/insertUser")
    public String insertUser(@RequestBody User user){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<User>getUser=userRepository.getUser(user.getCompany_code(),sdf.format(date));
        String message = "Unsuccessful";
        if (getUser.size() > 0) {
            message = "already exist";
        }else {
        int insert =userRepository.insertUser(user.getAverage_volume(),user.getMarket_cap(),user.getEarning_date(),user.getPrice_to_book(),
                user.getArt_data(),user.getQuote_source_name(),user.getMarket_price(),user.getMarket_change(),
                user.getChange_per(),user.getCompany_code(), sdf.format(date));
            if (insert > 0) {
                message = "Successful";
            }
        }

        return message;
    }

    @GetMapping("/getDate")
    public  Map<String,List<User>>getDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<User>getDate=userRepository.getDate(sdf.format(cal.getTime()));

        HashMap<String,List<User>>hMap=new HashMap<>();
        hMap.put("date",getDate);

        return hMap;

    }

    @GetMapping("/getDuplicate")
    public  Map<String,Set<User>>getAllData(){
        Set<User> tempSet = new HashSet<>();
        Set<User> duplicatedList = userRepository.getAllData();

    HashMap<String,Set<User>>hMap=new HashMap<>();
    hMap.put("dp",duplicatedList);
    return  hMap;
    }

}
