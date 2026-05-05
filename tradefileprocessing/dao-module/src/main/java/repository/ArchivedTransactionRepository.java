package repository;

import entity.ArchivedTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivedTransactionRepository extends JpaRepository<ArchivedTransaction,Long> {
}
