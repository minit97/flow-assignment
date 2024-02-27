package com.assignment.flow.service;

import com.assignment.flow.domain.Extension;
import com.assignment.flow.domain.ExtensionType;
import com.assignment.flow.dto.CustomExtensionResponseDto;
import com.assignment.flow.dto.FixExtensionResponseDto;
import com.assignment.flow.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.assignment.flow.domain.ExtensionType.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileService {
    private final ExtensionRepository extensionRepository;

    @Transactional
    public FixExtensionResponseDto fixExtensionUpd(Long fixId) {
        Extension extension = extensionRepository.findById(fixId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 확장자입니다."));
        extension.editChkStaus();
        return FixExtensionResponseDto.from(extension);
    }

    @Transactional(readOnly = true)
    public List<FixExtensionResponseDto> fixExtensionList() {
        return extensionRepository.findAll().stream()
                .map(FixExtensionResponseDto::from)
                .collect(Collectors.toList());
    }

    public CustomExtensionResponseDto customExtensionRegister(String extensionName) {
        if(extensionRepository.existsByExtensionName(extensionName)) {
            throw new IllegalArgumentException("이미 존재하는 확장자입니다.");
        }

        if(extensionRepository.count() == 200) {
            throw new IllegalArgumentException("최대 커스텀 확장자의 수는 200개 입니다.");
        }

        Extension extension = Extension.builder()
                .extensionName(extensionName)
                .extensionType(CUSTOM)
                .isChecked(true)
                .build();
        return CustomExtensionResponseDto.from(extensionRepository.save(extension));
    }

    @Transactional(readOnly = true)
    public List<CustomExtensionResponseDto> CustomExtensionList() {
        return extensionRepository.findAll().stream()
                .map(CustomExtensionResponseDto::from)
                .collect(Collectors.toList());
    }
}
