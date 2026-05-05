package repository;

import entity.SuccessfulTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuccessfulTransactionRepository extends JpaRepository<SuccessfulTransaction,Long> {
}
