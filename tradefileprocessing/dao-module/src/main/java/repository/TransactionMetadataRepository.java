package repository;

import entity.TransactionMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionMetadataRepository extends JpaRepository<TransactionMetadata,Long>{
}
