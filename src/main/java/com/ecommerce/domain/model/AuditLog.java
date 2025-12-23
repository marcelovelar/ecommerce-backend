package com.ecommerce.domain.model;

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
@Table(name = "audit_logs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_name", nullable = false)
    private String tableName;

    @Column(nullable = false)
    private String operation;

    @Column(name = "changed_data", columnDefinition = "text") // Using text for jsonb compatibility for now
    private String changedData;

    @Column(name = "change_date", insertable = false, updatable = false)
    @org.hibernate.annotations.ColumnDefault("now()")
    @Builder.Default
    private ZonedDateTime changeDate = ZonedDateTime.now();
}
