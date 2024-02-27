package com.assignment.flow.dto;

import com.assignment.flow.domain.Extension;
import com.assignment.flow.domain.ExtensionType;
import lombok.Builder;

@Builder
public class FixExtensionResponseDto {
    private Long extensionId;
    private String extensionName;
    private ExtensionType extensionType;
    private Boolean isChecked;

    public static FixExtensionResponseDto from(Extension extension) {
        if(extension == null) return null;

        return FixExtensionResponseDto.builder()
                .extensionId(extension.getId())
                .extensionName(extension.getExtensionName())
                .extensionType(extension.getExtensionType())
                .isChecked(extension.getIsChecked())
                .build();
    }
}
