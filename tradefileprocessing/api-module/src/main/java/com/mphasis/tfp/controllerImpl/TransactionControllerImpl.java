package com.mphasis.tfp.controllerimpl;

import com.mphasis.tfp.controller.TransactionController;
import com.mphasis.tfp.dto.ApiResponseDTO;
import com.mphasis.tfp.dto.FileLoadMetaDataResponse;
import com.mphasis.tfp.dto.UploadResponseDTO;
import com.mphasis.tfp.services.IFileUpload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TransactionControllerImpl implements TransactionController {

    private final IFileUpload fileUploadService;

    @Override
    public ApiResponseDTO<UploadResponseDTO> uploadFile(MultipartFile file) {
        log.info("API: Received file upload request: {}", file != null ? file.getOriginalFilename() : "null");
        UploadResponseDTO response = fileUploadService.uploadFile(file);
        return ApiResponseDTO.success(response, "File uploaded successfully and processing started");
    }

    @Override
    public ApiResponseDTO<FileLoadMetaDataResponse> getFileStatus(Long fileId) {
        log.info("API: Received request to get file status for fileId: {}", fileId);
        FileLoadMetaDataResponse response = fileUploadService.getFileStatus(fileId);
        return ApiResponseDTO.success(response, "File status retrieved successfully");
    }

    @Override
    public ApiResponseDTO<List<FileLoadMetaDataResponse>> searchFiles(
            Long fileId, String fileName, LocalDate uploadDateFrom, LocalDate uploadDateTo, String status) {

        log.info("API: Received search request - fileId: {}, fileName: {}, from: {}, to: {}, status: {}",
                fileId, fileName, uploadDateFrom, uploadDateTo, status);

        List<FileLoadMetaDataResponse> response = fileUploadService.searchFiles(
                fileId, fileName, uploadDateFrom, uploadDateTo, status);

        String message = response.isEmpty() ? "No files found matching the criteria" : "Found " + response.size() + " file(s)";
        return ApiResponseDTO.success(response, message);
    }
}