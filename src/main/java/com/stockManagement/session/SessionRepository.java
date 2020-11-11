package com.stockManagement.session;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface SessionRepository extends CrudRepository<Session,Long> {
    @Modifying
    @Query(value = "insert into section_table(email,password,ip_add,date)Values(?1,?2,?3,?4)",nativeQuery = true)
    @Transactional
    int insertSession(String email,String password,String ip_add,String date);

    @Query("select r from Session r where email=?1 and password=?2 and ip_add=?3")
    List<Session>sessionData(String email, String password,String ip_add);


}
