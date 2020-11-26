package com.stockManagement.archive;

import com.stockManagement.stock.StockMarketing;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArchiveRepository extends CrudRepository<Archive,String> {
    @Modifying
    @Query(value = "insert into archive_data(company_code,average_volume,earning_date,atr,direction," +
            "multiplier,entry_price,stop_loss,order_type,date,type)" +
            "Values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,11)",nativeQuery = true)
    @Transactional
    int insertArchive(String company_code,String average_volume,String earning_date,String atr,
                    String direction,String multiplier,String entryPrice,String stopLoss,
                    String orderType,String date,String type);


    @Modifying
    @Query(value = "update archive_data set average_volume=?1,earning_date=?2,atr=?3,direction=?4,multiplier=?5," +
            "entry_price=?6,stop_loss=?7,order_type=?8,type=?9 where company_code=?10 and date=?11",nativeQuery = true)
    @Transactional
    int updateArchive(String average_volume,String earning_date,String atr,String direction,
                    String multiplier,String entry_price,String stop_loss,String orderType,
                    String type,String company_code,String date);

    @Query("select l from Archive l where company_code=?1 and date=?2")
    List<Archive> getData(String company_code, String date );

    @Query("select l from Archive l where date between ?1 and ?2")
    List<Archive> getDate(String date,String to);


}
