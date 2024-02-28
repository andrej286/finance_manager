package com.example.finance_manager.web.controller;

import com.example.finance_manager.model.Asset;
import com.example.finance_manager.service.AssetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api/assets")
public class AssetController {

  private AssetService assetService;

  @GetMapping
  public List<Asset> findAssets() {

    return assetService.fetchAssets();
  }

  @PostMapping
  public void createAsset(@RequestBody Asset asset) {

    assetService.createAsset(asset);
  }

  @DeleteMapping("/{id}")
  public void deleteAsset(@PathVariable Long id) {

    assetService.deleteAsset(id);
  }
}
