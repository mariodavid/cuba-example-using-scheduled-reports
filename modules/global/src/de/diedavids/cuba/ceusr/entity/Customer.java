package de.diedavids.cuba.ceusr.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "CEUSR_CUSTOMER")
@Entity(name = "ceusr_Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = 3656417700058056755L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "TOTAL_TURNOVER")
    protected BigDecimal totalTurnover;

    public BigDecimal getTotalTurnover() {
        return totalTurnover;
    }

    public void setTotalTurnover(BigDecimal totalTurnover) {
        this.totalTurnover = totalTurnover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}