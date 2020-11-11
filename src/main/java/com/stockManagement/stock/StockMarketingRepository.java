package com.stockManagement.stock;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StockMarketingRepository extends CrudRepository<StockMarketing,Long> {
    @Modifying
    @Query(value = "insert into stock_management(company_code,average_volume,earning_date,atr,direction," +
            "multiplier,entry_price,stop_loss,order_type,date)" +
            "Values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    @Transactional
    int insertStock(String company_code,String average_volume,String earning_date,String atr,
                    String direction,String multiplier,String entryPrice,String stopLoss,
                    String orderType,String date);

    @Modifying
    @Query(value = "update stock_management set average_volume=?1,earning_date=?2,atr=?3,direction=?4,multiplier=?5," +
            "entry_price=?6,stop_loss=?7,order_type=?8 where company_code=?9 and date=?10",nativeQuery = true)
    @Transactional
    int updateStock(String average_volume,String earning_date,String atr,String direction,
            String multiplier,String entry_price,String stop_loss,String orderType,
            String company_code,String date);


    @Query("select l from StockMarketing l where company_code=?1 and date=?2")
    List<StockMarketing> getDate(String company_code,String date );

@Query("select l from StockMarketing l where date=?1 ")
    List<StockMarketing> getDate(String date );





}
