package com.example.finance_manager.service;

import com.example.finance_manager.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssetService {

  private AssetRepository assetRepository;
}
