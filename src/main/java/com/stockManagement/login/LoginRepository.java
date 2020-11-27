package com.stockManagement.login;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface LoginRepository extends CrudRepository<Login,Long> {
    @Modifying
    @Query(value = "insert into login_data(first_name,last_name,email,password," +
            "contact_no,dob,gender,ip_add,status,validity,date)Values" +
            "(?1,?2,?3,?4,?5,?6,?7,?8,?9,0,'')",nativeQuery = true)
    @Transactional
    int insertStockLogin(String first_name,String last_name,String email,String password,String contact_no,String dob,
                    String gender,String ip_add,String status);

    @Modifying
    @Query(value = "update login_data set status=?1,date=?2,validity=?3 where email=?4 and password=?5",nativeQuery = true)
    @Transactional
    int updateStockLogin(String status,String date,int validity,String email,String password);


    @Query("select r from Login r where email=?1 and password=?2 and status=?3  ")
    List<Login> loginData(String email,String password,String Status);

    @Query("select r from Login r where email=?1 ")
    List<Login> loginMail(String email);

}
