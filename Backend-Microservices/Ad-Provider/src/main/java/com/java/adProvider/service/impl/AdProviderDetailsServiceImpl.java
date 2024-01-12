package com.java.adProvider.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.adProvider.model.AdProviderDetails;
import com.java.adProvider.repo.AdProviderDetailsRepository;
import com.java.adProvider.service.AdProviderDetailsService;
@Service
public class AdProviderDetailsServiceImpl implements AdProviderDetailsService {
     @Autowired
   private   AdProviderDetailsRepository adProviderDetailsRepository;
	@Override
	public List<AdProviderDetails> getAllAdProviderList() {
		List<AdProviderDetails> adprovider=adProviderDetailsRepository.findAll();
		return adprovider;
	}

	@Override
	public AdProviderDetails getAdProviderById(Long ad_provider_id)
	{
		AdProviderDetails adprovider=adProviderDetailsRepository.getById(ad_provider_id);
		return adprovider;
	}

	@Override
	
	public AdProviderDetails createAdProvider(AdProviderDetails adProviderDetails) {
	    return adProviderDetailsRepository.save(adProviderDetails);
		//return null;
	}

	@Override
	public void deleteAdProvider(Long ad_provider_id) {
		// TODO Auto-generated method stub
		
	}

}
