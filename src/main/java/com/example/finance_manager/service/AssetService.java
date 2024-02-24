package com.example.finance_manager.service;

import com.example.finance_manager.model.Asset;
import com.example.finance_manager.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssetService {

  private AssetRepository assetRepository;

  public void createAsset(Asset asset) {

    assetRepository.save(asset);
  }

  public void deleteAsset(Long id) {

    assetRepository.deleteById(id);
  }

  public List<Asset> fetchAssets() {

    return assetRepository.findAll();
  }
}
