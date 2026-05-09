package com.mphasis.tfp.repository;

import com.mphasis.tfp.entity.SuccessfulTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuccessfulTransactionRepository extends JpaRepository<SuccessfulTransaction, Long> {

    List<SuccessfulTransaction> findByFileLoadId(Long fileLoadId);

    List<SuccessfulTransaction> findByTransactionId(String transactionId);

    List<SuccessfulTransaction> findByAccountNumber(String accountNumber);

    @Query("SELECT COUNT(s) FROM SuccessfulTransaction s WHERE s.fileLoadId = :fileLoadId")
    Integer countByFileLoadId(@Param("fileLoadId") Long fileLoadId);

    void deleteByFileLoadId(Long fileLoadId);
}