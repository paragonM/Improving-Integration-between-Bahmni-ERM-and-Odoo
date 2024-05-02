package com.asgard.consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asgard.consumer.Repository.ResRepo;
import com.asgard.consumer.mappers.ResPartnerMapper;
import com.asgard.consumer.models.ResPartner;
import com.asgard.consumer.service.RespartnerService;



@SpringBootApplication
@RestController
public class AsgardApplication {




	public ResPartner resPartner;
	private final RespartnerService respartnerService;

	

	public AsgardApplication(RespartnerService respartnerService) {
		this.respartnerService = respartnerService;
	}

	    public void save(ResPartner resPartner) {
         respartnerService.insert(resPartner);
    }

	Integer FindId(List<ResPartner> dump,String uuid){
		Integer identification = 0 ;
		Integer id = 0;
		for(int i=0;i<= dump.size();i++){
			if(Objects.equals(uuid, dump.get(i).getUuid())){
				identification = dump.get(i).getId();
				return identification;
			}
			else{
			
				return identification;

			}
		}
		return 0;
	}



	List<User> orderslist = new ArrayList<>();
	List<User> visitlist = new ArrayList<>();
	List<User> userslist = new ArrayList<>();
	List<User> personattributelist = new ArrayList<>();
	List<User> privilagelist = new ArrayList<>();
	List<User> personnamelist = new ArrayList<>();
	List<User> personlist = new ArrayList<>();
	List<User> personaddresslist = new ArrayList<>();
	List<User> patientprogramlist = new ArrayList<>();
	List<User> patientidentifiertypelist = new ArrayList<>();
	List<User> patientidentifierlist = new ArrayList<>();
	List<User> patientlist = new ArrayList<>();
	List<ResPartnerClass> resp = new ArrayList<>();
	List<ResPartner> resPartners = new ArrayList<>();

	

	public List<User> userFromTopic = new ArrayList<>();

    @GetMapping("/visit")
	public List<ResPartnerClass> consumevisit() {
		return resp;
	}




	@GetMapping("/res")
    public List<ResPartner> findAllEmployee() {
        return respartnerService.findAllEmployee();
    }


	@GetMapping("/ress")
	public List<ResPartner> resPartner2(){
		ResPartner resser = new ResPartner();
		resser.setName("Moeling lehloho");
		save(resser);	
		resPartners.add(resser);
		return resPartners;
	}


	@GetMapping("/users")
	public List<User> consumeusers() {
		return userslist;
	}

	@GetMapping("/personattribute")
	public List<User> consumepersonattribute() {
		return personattributelist;
	}

	@GetMapping("/privilage")
	public List<User> consumeprivilage() {
		return privilagelist;
	}

	@GetMapping("/personname")
	public List<User> consumepersonname() {
		return personnamelist;
	}

	@GetMapping("/person")
	public List<User> consumeperson() {
		return personlist;
	}

	@GetMapping("/personaddress")
	public List<User> consumepersonaddress() {
		return personaddresslist;
	}

	@GetMapping("/patientprogram")
	public List<User> consumepatientprogram() {
		return patientprogramlist;
	}

	@GetMapping("/patientidentifiertype")
	public List<User> consumepatientidentifiertype() {
		return patientidentifiertypelist;
	}

	@GetMapping("/patientidentifier")
	public List<User> consumepatientidentifier() {
		return patientidentifierlist;
	}

	@GetMapping("/patient")
	public List<User> consumepatient() {
		return patientlist;
	}

	@GetMapping("/orders")
	public List<User> consumeorders() {
		return orderslist;
	}

	@GetMapping("/con")
	public List<User> consumeJsonMessage() {
		return userFromTopic;
	}


	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.visit", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> visit(User visitstring) {
		visitlist.add(visitstring);
		return visitlist;
	}

	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.users", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> users(User userstring) {
		userslist.add(userstring);
		return userslist;
	}


	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.person_attribute", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> personattribute(User personattributestring) {
		personattributelist.add(personattributestring);
		return personattributelist;
	}


	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.privilege", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> privelage(User privelagesstring) {
		privilagelist.add(privelagesstring);
		return privilagelist;
	}


	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.patient_program", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> patientprogram(User patientprogramsstring) {
		patientprogramlist.add(patientprogramsstring);
		return patientprogramlist;
	}


	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.patient_identifier_type", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> patientidentifiertype(User patientidentifiertypesString) {
		patientidentifiertypelist.add(patientidentifiertypesString);
		return patientidentifiertypelist;
	}




	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.patient", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> patient(User patientsString) {
		patientlist.add(patientsString);
		return patientlist;
	}


	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.orders", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> orders(User orderssString) {
		orderslist.add(orderssString);
		return orderslist;
	}

	@KafkaListener(groupId = "javatechie-2", topics = "asgard.openmrs.person", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> getJsonMsgFromTopic(User user) {
		userFromTopic.add(user);
		return userFromTopic;
	}

	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.person_name", containerFactory = "userKafkaListenerContainerFactory")
	public List<ResPartnerClass> respatnerlistener(User user) {
		ResPartnerClass temp = new ResPartnerClass();
		String name;
		name = user.getGiven_name() +" "+ user.getMiddle_name()+" "+user.getFamily_name();
		temp.setPeresonid(user.getPerson_id());
		temp.setDisplay_name(name);
		temp.setName(name);
		temp.setUuid(user.getUuid());
		Integer idInteger = FindId(respartnerService.findAllEmployee(), user.getUuid());
		if(idInteger!=0){
			temp.setId(idInteger);
			ResPartner ResInsert = new ResPartner(temp);
			save(ResInsert);
		}

		resp.add(temp);
		return resp;
	}


	@KafkaListener(groupId = "consumergroup", topics = "asgard.openmrs.patient_identifier", containerFactory = "userKafkaListenerContainerFactory")
	public List<ResPartnerClass> patientidentifier(User user) {

		for (int i = 0; i < resp.size(); i++) {
			if( Objects.equals(user.getPatient_id(), resp.get(i).getPeresonid())){
				resp.get(i).setRef(user.getIdentifier());
				resp.get(i).setDisplay_name(resp.get(i).getName()+" "+"["+ user.getIdentifier()+"]");


				ResPartner ResInsert = new ResPartner(resp.get(i));
				save(ResInsert);

			
			}
	
			else{
				System.out.println("could not find index");
			}
		  }
		return resp;
	}


	public static void main(String[] args) {
		SpringApplication.run(AsgardApplication.class, args);
	}
}
