package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
@Table(name="successful_transaction")
public class SuccessfulTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionId;
    private String fileHeaderDate;
    private String accountNumber;
    private Integer transactionType;
    private String batchLocation;
    private Integer batchNumber;
    private Integer updateBatchDate;
    private String actionName;
    private Integer relatedFileKey;
    private String doNotReportFlag;
    private Integer owningPortfolio;
    private String posterInitials;
    private Integer transactionSubtype;
    private BigDecimal cashEffect;
    private BigDecimal oldBalance;
    private BigDecimal newBalance;

}
