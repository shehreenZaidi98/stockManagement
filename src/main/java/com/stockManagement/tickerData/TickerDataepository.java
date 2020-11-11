package com.stockManagement.tickerData;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TickerDataepository extends CrudRepository<TickerData,Long> {
    @Modifying
    @Query(value = "insert into ticker_data(date,comp_tittle,direction,order_type,entry_price," +
            "calculated_stop_loss,number_of_shares)Values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    @Transactional
    int insertTicker(String date,String comp_tittle,String direction,String order_type,String entry_price,
                     String calculated_stop_loss,String number_of_shares);
}
