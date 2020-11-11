package com.stockManagement.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface UserRepository extends CrudRepository<User , Long> {
    @Modifying
    @Query(value = "insert into user_table(average_volume,market_cap,earning_date,price_to_book,art_data," +
            "quote_source_name,market_price,market_change,change_per,company_code,date)Values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    @Transactional
    int insertUser(String average_volume,String market_cap,String earning_date,String price_to_book,String art_data,
                   String quote_source_name,String market_price,String market_change,String change_per,String company_code,String date);


    @Query("select p from User p where company_code=?1 and date=?2")
    List<User>getUser(String company_code, String date);

    @Query("select p from User p where date=?1")
    List<User>getDate(String date);
    @Query("select p from User p ")
    Set<User>getAllData();
}
