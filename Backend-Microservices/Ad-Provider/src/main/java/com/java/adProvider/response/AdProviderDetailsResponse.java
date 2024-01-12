package com.java.adProvider.response;

public class AdProviderDetailsResponse {
	    private Long ad_provider_id ; 
	    private String user_id;
	    private String adhar_card_no;
	    private String pan_card_no;
	    private String address_line_1;
	    private String address_line_2;
      private String education;
	    private String company_name;
	    private String company_add; 
	    private String registration_date ;   //date
	    private String services; 
	    private String  provided_by; 
	    private String  product_name;
		public AdProviderDetailsResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
//		public AdProviderDetailsResponse(Long ad_provider_id, String adhar_card_no, String pan_card_no,
//				String address_line_1, String address_line_2, String education, String company_name, String company_add,
//				String registration_date, String services, String provided_by, String product_name) {
//			super();
//			this.ad_provider_id = ad_provider_id;
//			this.adhar_card_no = adhar_card_no;
//			this.pan_card_no = pan_card_no;
//			this.address_line_1 = address_line_1;
//			this.address_line_2 = address_line_2;
//			this.education = education;
//			this.company_name = company_name;
//			this.company_add = company_add;
//			this.registration_date = registration_date;
//			this.services = services;
//			this.provided_by = provided_by;
//			this.product_name = product_name;
//		}
//		public Long getAd_provider_id() {
//			return ad_provider_id;
//		}
//		public void setAd_provider_id(Long ad_provider_id) {
//			this.ad_provider_id = ad_provider_id;
//		}
		public String getAdhar_card_no() {
			return adhar_card_no;
		}
		public void setAdhar_card_no(String adhar_card_no) {
			this.adhar_card_no = adhar_card_no;
		}
		public String getPan_card_no() {
			return pan_card_no;
		}
		public void setPan_card_no(String pan_card_no) {
			this.pan_card_no = pan_card_no;
		}
		public String getAddress_line_1() {
			return address_line_1;
		}
		public void setAddress_line_1(String address_line_1) {
			this.address_line_1 = address_line_1;
		}
		public String getAddress_line_2() {
			return address_line_2;
		}
		public void setAddress_line_2(String address_line_2) {
			this.address_line_2 = address_line_2;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public String getCompany_add() {
			return company_add;
		}
		public void setCompany_add(String company_add) {
			this.company_add = company_add;
		}
		public String getRegistration_date() {
			return registration_date;
		}
		public void setRegistration_date(String registration_date) {
			this.registration_date = registration_date;
		}
		public String getServices() {
			return services;
		}
		public void setServices(String services) {
			this.services = services;
		}
		public String getProvided_by() {
			return provided_by;
		}
		public void setProvided_by(String provided_by) {
			this.provided_by = provided_by;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		
		
		
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public AdProviderDetailsResponse(String adhar_card_no, String pan_card_no, String address_line_1,
				String address_line_2, String education, String company_name, String company_add,
				String registration_date, String services, String provided_by, String product_name) {
			super();
			this.adhar_card_no = adhar_card_no;
			this.pan_card_no = pan_card_no;
			this.address_line_1 = address_line_1;
			this.address_line_2 = address_line_2;
			this.education = education;
			this.company_name = company_name;
			this.company_add = company_add;
			this.registration_date = registration_date;
			this.services = services;
			this.provided_by = provided_by;
			this.product_name = product_name;
		}
		
		
		
		
		@Override
		public String toString() {
			return "AdProviderDetailsResponse [ad_provider_id=" + ad_provider_id + ", adhar_card_no=" + adhar_card_no
					+ ", pan_card_no=" + pan_card_no + ", address_line_1=" + address_line_1 + ", address_line_2="
					+ address_line_2 + ", education=" + education + ", company_name=" + company_name + ", company_add="
					+ company_add + ", registration_date=" + registration_date + ", services=" + services
					+ ", provided_by=" + provided_by + ", product_name=" + product_name + "]";
		}
		
	    
	    
	    
}
