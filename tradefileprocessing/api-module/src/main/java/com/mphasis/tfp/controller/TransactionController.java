package com.mphasis.tfp.controller;

import com.mphasis.tfp.dto.ApiResponseDTO;
import com.mphasis.tfp.dto.FileLoadMetaDataResponse;
import com.mphasis.tfp.dto.UploadResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Transaction File Processing", description = "APIs for uploading and managing transaction files")
@RequestMapping("/Files")
public interface TransactionController {

    @Operation(summary = "Upload transaction file", description = "Upload a TXT/CSV file containing transaction data for processing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File uploaded successfully",
                    content = @Content(schema = @Schema(implementation = UploadResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid file format or empty file"),
            @ApiResponse(responseCode = "413", description = "File size exceeds limit"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponseDTO<UploadResponseDTO> uploadFile(
            @Parameter(description = "TXT/CSV file containing transaction data", required = true)
            @RequestParam("file") MultipartFile file
    );

    @Operation(summary = "Get file processing status", description = "Retrieve the processing status and statistics of an uploaded file")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File status retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "File not found")
    })
    @GetMapping("/status/{fileId}")
    ApiResponseDTO<FileLoadMetaDataResponse> getFileStatus(
            @Parameter(description = "ID of the uploaded file", required = true)
            @PathVariable Long fileId
    );

    @Operation(summary = "Search uploaded files", description = "Search for uploaded files based on various criteria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search completed successfully")
    })
    @GetMapping("/search")
    ApiResponseDTO<List<FileLoadMetaDataResponse>> searchFiles(
            @Parameter(description = "File ID to search for") @RequestParam(required = false) Long fileId,
            @Parameter(description = "File name to search for (partial match)") @RequestParam(required = false) String fileName,
            @Parameter(description = "Upload date from (format: yyyy-MM-dd)") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate uploadDateFrom,
            @Parameter(description = "Upload date to (format: yyyy-MM-dd)") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate uploadDateTo,
            @Parameter(description = "File processing status") @RequestParam(required = false) String status
    );
}