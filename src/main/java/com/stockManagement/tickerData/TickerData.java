package com.stockManagement.tickerData;

import javax.persistence.*;

@Entity
@Table(name = "ticker_data")
public class TickerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String comp_tittle;
    private String direction;
    private String order_type;
    private String entry_price;
    private String calculated_stop_loss;
    private String number_of_shares;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComp_tittle() {
        return comp_tittle;
    }

    public void setComp_tittle(String comp_tittle) {
        this.comp_tittle = comp_tittle;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getEntry_price() {
        return entry_price;
    }

    public void setEntry_price(String entry_price) {
        this.entry_price = entry_price;
    }

    public String getCalculated_stop_loss() {
        return calculated_stop_loss;
    }

    public void setCalculated_stop_loss(String calculated_stop_loss) {
        this.calculated_stop_loss = calculated_stop_loss;
    }

    public String getNumber_of_shares() {
        return number_of_shares;
    }

    public void setNumber_of_shares(String number_of_shares) {
        this.number_of_shares = number_of_shares;
    }
}
