package com.mphasis.tfp.mapping;

import com.mphasis.tfp.dto.ErrorResponseDTO;
import com.mphasis.tfp.dto.FileLoadMetaDataResponse;
import com.mphasis.tfp.dto.UploadResponseDTO;
import com.mphasis.tfp.entity.FailedTransaction;
import com.mphasis.tfp.entity.TransactionMetadata;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Centralized mapper for all entity-to-DTO conversions
 */
@Component
public class ServiceMapper {

    // ==================== TRANSACTION METADATA MAPPINGS ====================

    public FileLoadMetaDataResponse toFileLoadMetaDataResponse(TransactionMetadata metadata) {
        if (metadata == null) {
            return null;
        }

        return new FileLoadMetaDataResponse(
                metadata.getFileId(),
                metadata.getFilename(),
                metadata.getUploadTime(),
                metadata.getTotalRecords(),
                metadata.getSuccessCount(),
                metadata.getErrorCount(),
                metadata.getStatus()
        );
    }

    public List<FileLoadMetaDataResponse> toFileLoadMetaDataResponseList(List<TransactionMetadata> metadataList) {
        if (metadataList == null) {
            return null;
        }

        return metadataList.stream()
                .map(this::toFileLoadMetaDataResponse)
                .collect(Collectors.toList());
    }

    public UploadResponseDTO toUploadResponseDTO(TransactionMetadata metadata, String message) {
        if (metadata == null) {
            return null;
        }

        return new UploadResponseDTO(
                metadata.getFileId(),
                metadata.getFilename(),
                metadata.getStatus(),
                message
        );
    }

    // ==================== FAILED TRANSACTION MAPPINGS ====================

    public ErrorResponseDTO toErrorResponseDTO(FailedTransaction failedTransaction) {
        if (failedTransaction == null) {
            return null;
        }

        ErrorResponseDTO dto = new ErrorResponseDTO();
        dto.setErrorId(failedTransaction.getErrorId());
        dto.setTransactionId(failedTransaction.getTransactionId());
        dto.setAccountNumber(failedTransaction.getAccountNumber());
        dto.setErrorField(failedTransaction.getErrorField());
        dto.setErrorMessage(failedTransaction.getErrorMessage());
        dto.setStatus(failedTransaction.getStatus());
        dto.setFileId(failedTransaction.getFileLoadId() != null ?
                failedTransaction.getFileLoadId().toString() : null);
        dto.setTimestamp(failedTransaction.getCreatedTime());

        return dto;
    }

    public List<ErrorResponseDTO> toErrorResponseDTOList(List<FailedTransaction> failedTransactions) {
        if (failedTransactions == null) {
            return null;
        }

        return failedTransactions.stream()
                .map(this::toErrorResponseDTO)
                .collect(Collectors.toList());
    }
}