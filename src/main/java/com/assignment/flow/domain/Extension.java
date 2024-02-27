package com.assignment.flow.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "extension")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Extension {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "extension_id")
    private Long id;

    @Column(length = 20)
    private String extensionName;

    @Enumerated(value = STRING)
    private ExtensionType extensionType;    // 인덱스 걸면 될 듯

    private Boolean isChecked;

    public void editChkStaus() {
        this.isChecked = !isChecked;
    }

    @Builder
    public Extension(String extensionName, ExtensionType extensionType, Boolean isChecked) {
        this.extensionName = extensionName;
        this.extensionType = extensionType;
        this.isChecked = isChecked;
    }
}
