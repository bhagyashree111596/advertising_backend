package com.java.adProvider.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.adProvider.model.AdProviderDetails;
import com.java.adProvider.model.Role;
import com.java.adProvider.model.User;
import com.java.adProvider.model.UserRole;
import com.java.adProvider.repo.AdProviderDetailsRepository;
import com.java.adProvider.response.AdProviderDetailsResponse;
import com.java.adProvider.response.PostUserResponse;
import com.java.adProvider.response.ResponseHandler;
import com.java.adProvider.service.AdProviderDetailsService;

@RestController
@RequestMapping("adprovider")
public class AdProviderDetailsController {
	@Autowired
	private AdProviderDetailsService adProviderDetailsService;

	@Autowired
	private AdProviderDetailsRepository adProviderDetailsRepository;

	@GetMapping("/")
	public ResponseEntity<?> getAdProviderDetailsList() {
		List<AdProviderDetails> adprovider = adProviderDetailsService.getAllAdProviderList();
		if (adprovider == null) {
			return null;
		}
		return ResponseHandler.responseBuilder(" Successfully Fetched List Of AdProviderDeatils", HttpStatus.OK.value(),
				adprovider, HttpStatus.OK);

	}

	@GetMapping("/{ad_provider_id}")
	public ResponseEntity<?> getAdPrviderById(@PathVariable("ad_provider_id") Long ad_provider_id) {

		AdProviderDetails adProviderDetails = adProviderDetailsService.getAdProviderById(ad_provider_id);
		AdProviderDetailsResponse adProviderDeatilsResponse = new AdProviderDetailsResponse();
//		adProviderDetails.setUser(new User());
//		adProviderDeatilsResponse.setAd_provider_id(adProviderDetails.getAd_provider_id());
		adProviderDeatilsResponse.setAdhar_card_no(adProviderDetails.getAdhar_card_no());
		adProviderDeatilsResponse.setPan_card_no(adProviderDetails.getPan_card_no());
		adProviderDeatilsResponse.setAddress_line_1(adProviderDetails.getAddress_line_1());
		adProviderDeatilsResponse.setAddress_line_2(adProviderDetails.getAddress_line_2());
		adProviderDeatilsResponse.setEducation(adProviderDetails.getEducation());
		adProviderDeatilsResponse.setCompany_name(adProviderDetails.getCompany_name());
		adProviderDeatilsResponse.setCompany_add(adProviderDetails.getCompany_add());
		adProviderDeatilsResponse.setRegistration_date(adProviderDetails.getRegistration_date());
		adProviderDeatilsResponse.setServices(adProviderDetails.getServices());
		adProviderDeatilsResponse.setProvided_by(adProviderDetails.getProvided_by());
		adProviderDeatilsResponse.setProduct_name(adProviderDetails.getProduct_name());
		
		
		if (adProviderDetails == null) {
			return ResponseHandler.responseBuilder("Ad Provider Not Found", HttpStatus.NO_CONTENT.value(),
					adProviderDeatilsResponse, HttpStatus.NO_CONTENT);
		}

		return ResponseHandler.responseBuilder("AdProvider Found", HttpStatus.OK.value(), adProviderDeatilsResponse,
				HttpStatus.OK);
	}

	@PostMapping("/e")
	public ResponseEntity<?> createAdProviderDetails(@RequestBody AdProviderDetails adProviderDetails) {
		//AdProviderDetails adProviderDetails = null;
		AdProviderDetailsResponse  adProviderDetailsResponse=null;
		UserRole userrole = new UserRole();
		Role role = new Role();
//		User user=new User();
		String user_id = UUID.randomUUID().toString(); //for setting unique id set
//		user.setUser_id(user_id);
	//	adProviderDetails.getUser_id();
//		String user_id1 =adProviderDetails.getUser().getUser_id();		
		adProviderDetailsResponse=new AdProviderDetailsResponse();
		User user=new User();
		user.setUser_id(user_id);
        
		
//		adProviderDetailsResponse.setUser_id(user1);
		System.out.println(adProviderDetailsResponse.getUser_id());
		adProviderDetailsResponse.setAdhar_card_no(adProviderDetails.getAdhar_card_no());
		adProviderDetailsResponse.setPan_card_no(adProviderDetails.getPan_card_no());
		adProviderDetailsResponse.setAddress_line_1(adProviderDetails.getAddress_line_1());
		adProviderDetailsResponse.setAddress_line_2(adProviderDetails.getAddress_line_2());
		adProviderDetailsResponse.setEducation(adProviderDetails.getEducation());
		adProviderDetailsResponse.setCompany_name(adProviderDetails.getCompany_name());
		adProviderDetailsResponse.setCompany_add(adProviderDetails.getCompany_add());
		adProviderDetailsResponse.setRegistration_date(adProviderDetails.getRegistration_date());
		adProviderDetailsResponse.setServices(adProviderDetails.getServices());
		adProviderDetailsResponse.setProvided_by(adProviderDetails.getProvided_by());
		adProviderDetailsResponse.setProduct_name(adProviderDetails.getProduct_name());
		
		 adProviderDetailsService.createAdProvider(adProviderDetails);
		

		return ResponseHandler.responseBuilder("You Are added AdProvider details Successfully", HttpStatus.OK.value(),
				adProviderDetailsResponse, HttpStatus.OK);

		
	}
	
		
}