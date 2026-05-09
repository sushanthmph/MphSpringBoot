package com.mphasis.tfp.repository;

import com.mphasis.tfp.entity.TransactionMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionMetadataRepository extends JpaRepository<TransactionMetadata, Long>,
        JpaSpecificationExecutor<TransactionMetadata> {

    Optional<TransactionMetadata> findByFilename(String filename);

    List<TransactionMetadata> findByStatus(String status);

    @Query("SELECT t FROM TransactionMetadata t WHERE " +
            "(:fileId IS NULL OR t.fileId = :fileId) AND " +
            "(:filename IS NULL OR LOWER(t.filename) LIKE LOWER(CONCAT('%', :filename, '%'))) AND " +
            "(:startDate IS NULL OR t.uploadTime >= :startDate) AND " +
            "(:endDate IS NULL OR t.uploadTime <= :endDate) AND " +
            "(:status IS NULL OR t.status = :status)")
    List<TransactionMetadata> searchFiles(
            @Param("fileId") Long fileId,
            @Param("filename") String filename,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("status") String status);
}