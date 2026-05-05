package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="transaction_metadata")
public class TransactionMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String filename;
    private LocalDateTime uploadTime;
    private Integer totalRecords;
    private Integer successCount;
    private Integer errorCount;
    private String status;
}
