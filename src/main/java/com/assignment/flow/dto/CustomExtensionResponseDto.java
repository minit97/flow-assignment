package com.assignment.flow.dto;

import com.assignment.flow.domain.Extension;
import com.assignment.flow.domain.ExtensionType;
import lombok.Builder;

@Builder
public class CustomExtensionResponseDto {
    private Long extensionId;
    private String extensionName;
    private ExtensionType extensionType;

    public static CustomExtensionResponseDto from(Extension extension) {
        if(extension == null) return null;

        return CustomExtensionResponseDto.builder()
                .extensionId(extension.getId())
                .extensionName(extension.getExtensionName())
                .extensionType(extension.getExtensionType())
                .build();
    }
}
