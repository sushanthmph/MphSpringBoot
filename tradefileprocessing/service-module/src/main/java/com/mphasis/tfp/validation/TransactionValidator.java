package com.mphasis.tfp.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class TransactionValidator {

    @Value("${app.transaction.field.transaction-id-index}")
    private int transactionIdIndex;

    @Value("${app.transaction.field.account-number-index}")
    private int accountNumberIndex;

    @Value("${app.transaction.field.transaction-type-index}")
    private int transactionTypeIndex;

    @Value("${app.transaction.field.batch-number-index}")
    private int batchNumberIndex;

    @Value("${app.transaction.field.cash-effect-index}")
    private int cashEffectIndex;

    @Value("${app.transaction.field.old-balance-index}")
    private int oldBalanceIndex;

    @Value("${app.transaction.field.new-balance-index}")
    private int newBalanceIndex;

    @Value("${app.validation.account-number-pattern}")
    private String accountNumberPattern;

    public List<String> validate(String[] fields, int lineNumber) {
        List<String> errors = new ArrayList<>();

        log.debug("Line {}: Starting validation for {} fields", lineNumber, fields != null ? fields.length : 0);

        if (fields == null || fields.length < 16) {
            String error = String.format("Insufficient fields. Expected 16 fields but found %d",
                    fields != null ? fields.length : 0);
            errors.add(error);
            log.error("Line {}: {}", lineNumber, error);
            return errors;
        }

        String transactionId = getField(fields, transactionIdIndex);
        if (!isValid(fields, transactionIdIndex)) {
            String error = "Transaction ID is required";
            errors.add(error);
            log.error("Line {}: {} - Value: '{}'", lineNumber, error, transactionId);
        }

        String accountNumber = getField(fields, accountNumberIndex);
        if (!isValid(fields, accountNumberIndex)) {
            String error = "Account Number is required";
            errors.add(error);
            log.error("Line {}: {} - Value: '{}'", lineNumber, error, accountNumber);
        } else if (!isValidAccountNumber(accountNumber)) {
            String error = String.format("Invalid Account Number format. Must be alphanumeric (5-20 chars). Got: '%s'",
                    accountNumber);
            errors.add(error);
            log.error("Line {}: {}", lineNumber, error);
        }

        String transactionType = getField(fields, transactionTypeIndex);
        if (isValid(fields, transactionTypeIndex)) {
            if (!isValidInteger(transactionType)) {
                String error = String.format("Transaction Type must be a valid integer. Got: '%s'",
                        transactionType);
                errors.add(error);
                log.error("Line {}: {}", lineNumber, error);
            }
        }

        String batchNumber = getField(fields, batchNumberIndex);
        if (isValid(fields, batchNumberIndex)) {
            if (!isValidInteger(batchNumber)) {
                String error = String.format("Batch Number must be a valid integer. Got: '%s'",
                        batchNumber);
                errors.add(error);
                log.error("Line {}: {}", lineNumber, error);
            }
        }

        String cashEffect = getField(fields, cashEffectIndex);
        if (isValid(fields, cashEffectIndex)) {
            if (!isValidDecimal(cashEffect)) {
                String error = String.format("Cash Effect must be a valid decimal. Got: '%s'",
                        cashEffect);
                errors.add(error);
                log.error("Line {}: {}", lineNumber, error);
            }
        }

        String oldBalance = getField(fields, oldBalanceIndex);
        if (isValid(fields, oldBalanceIndex)) {
            if (!isValidDecimal(oldBalance)) {
                String error = String.format("Old Balance must be a valid decimal. Got: '%s'",
                        oldBalance);
                errors.add(error);
                log.error("Line {}: {}", lineNumber, error);
            }
        }

        String newBalance = getField(fields, newBalanceIndex);
        if (isValid(fields, newBalanceIndex)) {
            if (!isValidDecimal(newBalance)) {
                String error = String.format("New Balance must be a valid decimal. Got: '%s'",
                        newBalance);
                errors.add(error);
                log.error("Line {}: {}", lineNumber, error);
            }
        }

        // Business validation
        if (isValid(fields, oldBalanceIndex) &&
                isValid(fields, cashEffectIndex) &&
                isValid(fields, newBalanceIndex)) {

            if (isValidDecimal(oldBalance) &&
                    isValidDecimal(cashEffect) &&
                    isValidDecimal(newBalance)) {

                BigDecimal oldBal = new BigDecimal(oldBalance);
                BigDecimal cashEff = new BigDecimal(cashEffect);
                BigDecimal newBal = new BigDecimal(newBalance);
                BigDecimal calculated = oldBal.add(cashEff);

                if (calculated.compareTo(newBal) != 0) {
                    String error = String.format(
                            "Balance mismatch: Old Balance (%s) + Cash Effect (%s) = %s, but New Balance is %s",
                            oldBalance, cashEffect, calculated, newBalance);
                    errors.add(error);
                    log.error("Line {}: {}", lineNumber, error);
                }
            }
        }

        if (errors.isEmpty()) {
            log.debug("Line {}: All validations passed successfully", lineNumber);
        }

        return errors;
    }

    private boolean isValid(String[] fields, int index) {
        try {
            String value = fields[index];
            return value != null && !value.trim().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    private String getField(String[] fields, int index) {
        try {
            return fields != null && index < fields.length ? fields[index] : null;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean isValidInteger(String value) {
        try {
            Integer.parseInt(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidDecimal(String value) {
        try {
            new BigDecimal(value.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isValidAccountNumber(String accountNumber) {
        return accountNumber != null && accountNumber.matches(accountNumberPattern);
    }
}