package com.ecommerce.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "warehouses")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false) // No BaseEntity extended in SQL, but good practice to allow extension if
                                      // needed. However, SQL didn't have created_at/updated_at. Let's stick to simple
                                      // entity or check if I should extend BaseEntity. SQL text didn't have audit
                                      // columns for warehouse. I will NOT extend BaseEntity to match SQL strictly
                                      // unless I decide otherwise. The plan didn't explicitly say I WOULDN'T, but for
                                      // consistency with others I might. Wait, Review had review_date. Warehouse has
                                      // nothing. I'll stick to POJO for now to match SQL, or maybe just add it for
                                      // consistency? Mentions in plan: "updatedAt (managed by BaseEntity if possible,
                                      // or explicit)". Warehouse SQL: id, name, location.
// Actually, for a real app, BaseEntity is good. But user gave specific SQL.
// I will just map the SQL fields.
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;
}
