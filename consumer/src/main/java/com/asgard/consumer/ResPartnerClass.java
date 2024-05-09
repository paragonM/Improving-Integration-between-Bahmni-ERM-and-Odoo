package com.asgard.consumer;
import com.asgard.consumer.models.ResPartner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResPartnerClass {
public Integer person_id;
public Integer id;
public String peresonid;
public String name; 
public String company_id;
public String color;
public String active  ;
public String supplier;
public String display_name;
public String employee;
public String ref;     
public String is_company ;
public String lang; 
public String write_uid;
public String customer;
public String create_uid;
public String type;
public String partner_share;
public String notify_email;
public String opt_out;
public String invoice_warn ;
public String picking_warn ;
public String manufacturer;
public String local_name;
public String purchase_warn;
public String uuid;


public ResPartnerClass(ResPartner resPartner){
    this.name = resPartner.getName();
    this.display_name= resPartner.getDisplay_name();
    this.ref =  resPartner.getRef();
   
}

    
}
