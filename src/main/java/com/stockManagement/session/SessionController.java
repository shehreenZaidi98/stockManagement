package com.stockManagement.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
