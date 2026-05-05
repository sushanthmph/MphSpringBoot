package services;

import entity.SuccessfulTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SuccessfulTransactionRepository;

import java.math.BigDecimal;

@Service
public class SaveTransactions {

    @Autowired
    private SuccessfulTransactionRepository successfulTransactionRepository;

    public void saveTransaction(String input) {

        try {

            String[] data = input.split(",");

            SuccessfulTransaction t = new SuccessfulTransaction();

            t.setTransactionId(data[0]);
            t.setFileHeaderDate(data[1]);
            t.setAccountNumber(data[2]);
            t.setTransactionType(Integer.parseInt(data[3]));
            t.setBatchLocation(data[4]);
            t.setBatchNumber(Integer.parseInt(data[5]));
            t.setUpdateBatchDate(Integer.parseInt(data[6]));
            t.setActionName(data[7]);
            t.setRelatedFileKey(Integer.parseInt(data[8]));
            t.setDoNotReportFlag(data[9]);
            t.setOwningPortfolio(Integer.parseInt(data[10]));
            t.setPosterInitials(data[11]);
            t.setTransactionSubtype(Integer.parseInt(data[12]));
            t.setCashEffect(new BigDecimal(data[13]));
            t.setOldBalance(new BigDecimal(data[14]));
            t.setNewBalance(new BigDecimal(data[15]));

            successfulTransactionRepository.save(t);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}