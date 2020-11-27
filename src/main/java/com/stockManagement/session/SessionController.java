package com.stockManagement.session;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class SessionController {
    @Autowired
    SessionRepository sessionRepository;
    @PostMapping("/insertSession")
    public String insertSession(@RequestBody Session session){
        sessionRepository.insertSession(session.getEmail(),session.getPassword(),session.getIp_add(),session.getDate());
        return "save";

    }
    @GetMapping("getSession")
    public String loginData(@RequestParam ("email")String email
            ,@RequestParam("password") String password ,@RequestParam ("ip_add") String ip_add) throws MqttException {

        List<Session>list=sessionRepository.sessionData(email, password, ip_add);
        String message="Not Login";
        if(list.size()>0){
            message="login";
        }else{
            Subscriber subscriber=new Subscriber();
            MqttMessage message1 = new MqttMessage("expire".getBytes());

            subscriber.client.publish("session",message1);

            sessionRepository.sessionData(email,password,"expire");
        }
        return message;
        }
    }



