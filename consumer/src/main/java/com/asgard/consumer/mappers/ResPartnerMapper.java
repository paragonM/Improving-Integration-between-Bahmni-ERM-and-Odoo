package com.asgard.consumer.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.asgard.consumer.ResPartnerClass;
import com.asgard.consumer.models.ResPartner;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResPartnerMapper {

    public static ResPartner MaptoEntity(ResPartnerClass res){
        return new ResPartner(res);
   
    }

    public static ResPartnerClass Maptoclass(ResPartner resPartner){
        return new ResPartnerClass(resPartner);
    }


}
