package com.stockManagement.user;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String average_volume;
    private String market_cap;
    private String earning_date;
    private String price_to_book;
    private String art_data;
    private String quote_source_name;
    private String market_price;
    private String market_change;
    private String change_per;
    private String company_code;
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAverage_volume() {
        return average_volume;
    }

    public void setAverage_volume(String average_volume) {
        this.average_volume = average_volume;
    }

    public String getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(String market_cap) {
        this.market_cap = market_cap;
    }

    public String getEarning_date() {
        return earning_date;
    }

    public void setEarning_date(String earning_date) {
        this.earning_date = earning_date;
    }

    public String getPrice_to_book() {
        return price_to_book;
    }

    public void setPrice_to_book(String price_to_book) {
        this.price_to_book = price_to_book;
    }

    public String getArt_data() {
        return art_data;
    }

    public void setArt_data(String art_data) {
        this.art_data = art_data;
    }

    public String getQuote_source_name() {
        return quote_source_name;
    }

    public void setQuote_source_name(String quote_source_name) {
        this.quote_source_name = quote_source_name;
    }

    public String getMarket_price() {
        return market_price;
    }

    public void setMarket_price(String market_price) {
        this.market_price = market_price;
    }

    public String getMarket_change() {
        return market_change;
    }

    public void setMarket_change(String market_change) {
        this.market_change = market_change;
    }

    public String getChange_per() {
        return change_per;
    }

    public void setChange_per(String change_per) {
        this.change_per = change_per;
    }

    public String getCompany_code() {
        return company_code;
    }

    public void setCompany_code(String company_code) {
        this.company_code = company_code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return company_code.equals(user.company_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company_code);
    }
}
