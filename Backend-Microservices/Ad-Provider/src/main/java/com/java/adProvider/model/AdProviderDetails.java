package com.java.adProvider.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_ads_provider_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdProviderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Long ad_provider_id ;
//	@OneToOne
//	@JoinColumn(name="user_id",nullable=false,unique=true)
  //  private String user_id;
	
	@ManyToOne()

    @JoinColumn(name="user_id")
    private User user;
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
    private String  created_date; //date
    private String  modified_date;  //date
    private boolean is_system_modified; 
    private String  system_modified_date; 
    private Timestamp  row_version ;
}
