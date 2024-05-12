package com.example.finance_manager.service;

import com.example.finance_manager.model.Asset;
import com.example.finance_manager.repository.AssetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public void updateAsset(Long id, Asset updatedAsset) {

    Optional<Asset> existingAssetOptional = assetRepository.findById(id);
    if (existingAssetOptional.isPresent()) {
      Asset existingAsset = existingAssetOptional.get();
      existingAsset.setName(updatedAsset.getName());
      existingAsset.setDescription(updatedAsset.getDescription());
      existingAsset.setValue(updatedAsset.getValue());
      existingAsset.setDateOfAcquirement(updatedAsset.getDateOfAcquirement());
      existingAsset.setInterestRate(updatedAsset.getInterestRate());
      assetRepository.save(existingAsset);
    }
  }
}
