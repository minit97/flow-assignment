package com.assignment.flow.controller;

import com.assignment.flow.dto.CustomExtensionResponseDto;
import com.assignment.flow.dto.FixExtensionResponseDto;
import com.assignment.flow.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/extension")
@RestController
public class FileController {
    private final FileService fileService;

    // 1. 고정 확장자 변경
    @PatchMapping("/fix/{fixId}")
    public ResponseEntity<FixExtensionResponseDto> callFixExtensionUpdateCheckStatus(@PathVariable Long fixId) {
        return ResponseEntity.ok(fileService.fixExtensionUpd(fixId));
    }

    // 2. 고정 확장자 체크 여부  // 이거 그냥 캐시해도 될듯
    @GetMapping("/fix")
    public ResponseEntity<List<FixExtensionResponseDto>> callFixExtensionList() {
        return ResponseEntity.ok(fileService.fixExtensionList());
    }

    // 3. 커스텀 확장자 등록    // 중복 여부 확인 // 갯수 확인 (최대 200개)
    @PostMapping("/custom")
    public ResponseEntity<CustomExtensionResponseDto> callCustomExtensionRegister(@RequestBody String ExtensionName) {
        return ResponseEntity.ok(fileService.customExtensionRegister(ExtensionName));
    }

    // 4. 커스텀 확장자 리스트
    @GetMapping("/custom")
    public ResponseEntity<List<CustomExtensionResponseDto>> callCustomExtensionList() {
        return ResponseEntity.ok(fileService.CustomExtensionList());
    }

    // 5. 커스텀 확장자 삭제
    @DeleteMapping("/custom")
    public String callCustomExtensionDel() {
        return "";
    }
}
