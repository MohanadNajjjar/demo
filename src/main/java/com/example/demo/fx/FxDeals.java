package com.example.demo.fx;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table
@Setter
@Getter
@ToString
public class FxDeals {

    @Id
    Integer dealId;

    @NotNull
    String fromCurrCode;

    @NotNull
    String toCurrCode;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    Timestamp dealTime;

    @NotNull
    BigDecimal dealAmount;
}
