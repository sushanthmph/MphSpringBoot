package repository;

import entity.FailedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FailedTransactionRepository extends JpaRepository<FailedTransaction,Long>{

}
