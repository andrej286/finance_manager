package com.example.finance_manager.service;

import com.example.finance_manager.model.Asset;
import com.example.finance_manager.model.Person;
import com.example.finance_manager.repository.AssetRepository;
import com.example.finance_manager.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AssetService {

  private AssetRepository assetRepository;
  private PersonRepository personRepository;

  public List<Asset> fetchAssets(String email) {
    return assetRepository.findAllByPersonEmail(email);
  }

  public void createAsset(Asset asset, String email) {
    Optional<Person> personOptional = personRepository.findByEmail(email);
    if (personOptional.isPresent()) {
      Person person = personOptional.get();
      asset.setPerson(person);
      assetRepository.save(asset);
    } else {
      throw new RuntimeException("Person with email " + email + " not found");
    }
  }

  public void deleteAsset(Long id, String email) {
    Optional<Asset> assetOptional = assetRepository.findById(id);
    if (assetOptional.isPresent()) {
      Asset asset = assetOptional.get();
      if (asset.getPerson().getEmail().equals(email)) {
        assetRepository.deleteById(id);
      } else {
        throw new RuntimeException("Unauthorized action for email " + email);
      }
    } else {
      throw new RuntimeException("Asset with id " + id + " not found");
    }
  }

  public void updateAsset(Long id, Asset updatedAsset, String email) {
    Optional<Asset> existingAssetOptional = assetRepository.findById(id);
    if (existingAssetOptional.isPresent()) {
      Asset existingAsset = existingAssetOptional.get();
      if (existingAsset.getPerson().getEmail().equals(email)) {
        existingAsset.setName(updatedAsset.getName());
        existingAsset.setDescription(updatedAsset.getDescription());
        existingAsset.setValue(updatedAsset.getValue());
        existingAsset.setDateOfAcquirement(updatedAsset.getDateOfAcquirement());
        existingAsset.setInterestRate(updatedAsset.getInterestRate());
        assetRepository.save(existingAsset);
      } else {
        throw new RuntimeException("Unauthorized action for email " + email);
      }
    } else {
      throw new RuntimeException("Asset with id " + id + " not found");
    }
  }
}
