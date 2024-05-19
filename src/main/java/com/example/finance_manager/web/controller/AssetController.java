package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Asset;
import com.example.finance_manager.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/assets")
public class AssetController {

  private AssetService assetService;

  @GetMapping
  public List<Asset> findAssets(@AuthenticationPrincipal(expression = "attributes.get('email')") String email) {
    return assetService.fetchAssets(email);
  }

  @PostMapping
  public void createAsset(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @RequestBody Asset asset) {
    assetService.createAsset(asset, email);
  }

  @DeleteMapping("/{id}")
  public void deleteAsset(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @PathVariable Long id) {
    assetService.deleteAsset(id, email);
  }

  @PutMapping("/{id}")
  public void updateAsset(@AuthenticationPrincipal(expression = "attributes.get('email')") String email, @PathVariable Long id, @RequestBody Asset updatedAsset) {
    assetService.updateAsset(id, updatedAsset, email);
  }
}
