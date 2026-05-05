package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name="failed_transaction")
public class FailedTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long errorId;
    private Long fileLoadId;
    private String transactionId;
    private String accountNumber;
    private Integer recordNumber;
    private String errorField;
    private String errorMessage;
    private String status;
    private LocalDateTime createdTime;

}
