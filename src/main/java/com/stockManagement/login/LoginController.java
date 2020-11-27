package com.stockManagement.login;

import com.stockManagement.session.Session;
import com.stockManagement.session.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    SessionRepository sessionRepository;
    @PostMapping("/insertStockLogin")
    public String insertLogin(@RequestBody Login login){
        String message="UnSuccessful";
        List<Login> checkMail=loginRepository.loginMail(login.getEmail());
        Login login1=new Login();
        login1.setStatus("Pending");
        if(checkMail.size()>0){
            message="Already exist";
        }else {
            int insert = loginRepository.insertStockLogin(login.getFirst_name(), login.getLast_name(), login.getEmail(),
                    login.getPassword(), login.getContact_no(), login.getDob(), login.getGender(),
                    login.getIp_add(), "Pending");
            if (insert > 0) {
                message = "inserted";
            }
        }
        return message;
    }
    @GetMapping("/login")
    public String loginData(@RequestParam ("email")String email
            ,@RequestParam("password") String password ,@RequestParam ("ip_add") String ip_add){
            Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy:MM:dd");

        String message="Not Login";

        ArrayList<Login>list=(ArrayList<Login>)loginRepository.loginData(email,password,"active");
        if(list.size()>0){
            ArrayList<Session>list1=(ArrayList<Session>)sessionRepository.sessionData(email,password,ip_add);
            if(list1.size()>0){
                sessionRepository.insertSession(email,password,ip_add,sdf.format(date));
            }
            message="Login";
        }
        return message;
    }

    @PostMapping("updateStock")
    public String loginData(@RequestBody Login login){
        Date date=new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy:MM:dd");

        String message="Not Updated";

        int update=loginRepository.updateStockLogin("active", sdf.format(date), login.getValidity(),
                login.getEmail(),login.getPassword());
        if(update>0){
            message="Updated";
        }
        return message;

    }

}
