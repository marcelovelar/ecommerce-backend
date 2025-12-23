package com.ecommerce.domain.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales_reports")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "report_date", insertable = false, updatable = false)
    @org.hibernate.annotations.ColumnDefault("now()")
    @Builder.Default
    private ZonedDateTime reportDate = ZonedDateTime.now();

    @Column(name = "total_sales", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalSales;

    @Column(name = "total_orders", nullable = false)
    private Integer totalOrders;
}
