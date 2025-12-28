package com.ecommerce.infrastructure.listener;

import com.ecommerce.domain.model.AuditLog;
import com.ecommerce.domain.repository.AuditLogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Table;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuditListener {

    private final AuditLogRepository auditLogRepository;
    private final ObjectMapper objectMapper;

    // Use Lazy injection to avoid circular dependencies with EntityManager
    public AuditListener(@Lazy AuditLogRepository auditLogRepository, ObjectMapper objectMapper) {
        this.auditLogRepository = auditLogRepository;
        this.objectMapper = objectMapper;
    }

    @PostPersist
    public void afterPersist(Object entity) {
        saveAuditLog(entity, "INSERT");
    }

    @PostUpdate
    public void afterUpdate(Object entity) {
        saveAuditLog(entity, "UPDATE");
    }

    @PostRemove
    public void afterRemove(Object entity) {
        saveAuditLog(entity, "DELETE");
    }

    private void saveAuditLog(Object entity, String operation) {
        try {
            String tableName = entity.getClass().getAnnotation(Table.class).name();
            String changedData = objectMapper.writeValueAsString(entity);

            AuditLog auditLog = AuditLog.builder()
                    .tableName(tableName)
                    .operation(operation)
                    .changedData(changedData)
                    .build();

            auditLogRepository.save(auditLog);
        } catch (JsonProcessingException e) {
            log.error("Error serializing entity for audit log", e);
        } catch (Exception e) {
            log.error("Error saving audit log", e);
        }
    }
}
