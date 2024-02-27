package com.assignment.flow.repository;

import com.assignment.flow.domain.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExtensionRepository extends JpaRepository<Extension, Long> {
    boolean existsByExtensionName(String extensionName);
}
