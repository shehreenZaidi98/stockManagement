package com.stockManagement.chart;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface ChartRepository extends CrudRepository<Chart,Long> {
    @Modifying
    @Query(value = "insert into chart_data(time_stamp,close,open,low,high,company_code,date)Values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    @Transactional
    int insertChart(String time_stamp,String close,String open,String low,String high,String company_code,String date);

    @Query("select p from Chart p where company_code=?1 and date=?2")
    List<Chart>getChart(String company_code,String date );

}
