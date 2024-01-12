package com.java.adProvider.service;

import java.util.List;

import com.java.adProvider.model.AdProviderDetails;

public interface AdProviderDetailsService {
   public List<AdProviderDetails> getAllAdProviderList();
   public AdProviderDetails getAdProviderById(Long ad_provider_id);
   public AdProviderDetails createAdProvider(AdProviderDetails adProviderDetails);
   
//   public AdProviderDetails updateAdProvider(AdProviderDetails adProviderDetails);
   
   public void deleteAdProvider(Long ad_provider_id);
}
