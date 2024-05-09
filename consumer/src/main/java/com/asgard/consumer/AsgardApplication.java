package com.asgard.consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.scheduling.annotation.Async;
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

	int lock = 1;
	int lock2 = 1;
	int lock3 = 1;




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
	List<ResPartner> list = new ArrayList<>() ;

	public List<User> userFromTopic = new ArrayList<>();

    @GetMapping("/visit")
	public List<ResPartnerClass> consumevisit() {
		return resp;
	}




	@GetMapping("/res")
    public List<ResPartner> findAllEmployee() {
        return respartnerService.findAllEmployee();
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


	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.visit", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> visit(User visitstring) {
		visitlist.add(visitstring);
		return visitlist;
	}

	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.users", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> users(User userstring) {
		userslist.add(userstring);
		return userslist;
	}


	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.person_attribute", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> personattribute(User personattributestring) {
		personattributelist.add(personattributestring);
		return personattributelist;
	}


	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.privilege", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> privelage(User privelagesstring) {
		privilagelist.add(privelagesstring);
		return privilagelist;
	}


	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.patient_program", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> patientprogram(User patientprogramsstring) {
		patientprogramlist.add(patientprogramsstring);
		return patientprogramlist;
	}


	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.patient_identifier_type", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> patientidentifiertype(User patientidentifiertypesString) {
		patientidentifiertypelist.add(patientidentifiertypesString);
		return patientidentifiertypelist;
	}




	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.patient", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> patient(User patientsString) {
		patientlist.add(patientsString);
		return patientlist;
	}
	@Async
	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.event_records", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> orders(User event) {
	//	lock3 =1;
		String uuString = event.getObject().substring(28,28+36);
		event.setTest(uuString);
		System.out.println(event);
		List <ResPartner> temp = respartnerService.findbyuuid(event.getTest());
		if(!temp.isEmpty()){
			System.out.println(temp.get(0));
			list.add(temp.get(0));
			lock2 =0;
		}
		else{
			lock3 = 0;
		}
		System.out.println(list.size());

		orderslist.add(event);
		return orderslist;
	}
	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.person", containerFactory = "userKafkaListenerContainerFactory")
	public List<User> getJsonMsgFromTopic(User user) {
		while(lock3==1 ){
			System.out.println("waiting on something");

		}
			userFromTopic.add(user);
			ResPartnerClass temp = new ResPartnerClass();
			temp.setPeresonid(user.getPerson_id());
			temp.setUuid(user.getUuid());
			resp.add(temp);
		lock2= 0;
		lock3 = 1;
		return userFromTopic;
	}
	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.person_name", containerFactory = "userKafkaListenerContainerFactory")
	public void respatnerlistener(User user) {
		int counter = 10000;
		while(lock2==1 && counter>5){
			System.out.println("waiting index");
			counter--;

		}

		System.out.println("indices note me"+user);

		//check if record exists and update name
		System.out.println("list size"+list.size());

		if(!list.isEmpty()){
			System.out.println("found in database");
			System.out.println("here here"+user);
			System.out.println("here here"+list.size());
			ResPartnerClass temp2 = new ResPartnerClass();
			System.out.println(list.get(0).getUuid());
			String name  = user.getGiven_name() +" "+ user.getMiddle_name()+" "+user.getFamily_name();
			temp2.setDisplay_name(name+" "+"["+ list.get(0).getRef()+"]");
			temp2.setId(list.get(0).getId());
			temp2.setName(name);
			temp2.setUuid(list.get(0).getUuid());
			ResPartner ResInsert = new ResPartner(temp2);
			save(ResInsert);
			resp.add(temp2);
			list.clear();
	}else{
		System.out.println("indices");
				//for database insert
				for ( int j =0 ; j < resp.size();j++ ){
					System.out.println("indices");
					if(Objects.equals(resp.get(j).getPeresonid(), user.getPerson_id())){
						String name = user.getGiven_name() +" "+ user.getMiddle_name()+" "+user.getFamily_name();
						resp.get(j).setPeresonid(user.getPerson_id());
						resp.get(j).setDisplay_name(name);
						resp.get(j).setName(name);
						System.out.println(resp.get(j).getUuid());	
					}
					}
					lock = 0;
	}
		
		lock2 =1;
		System.out.println("done");

	}

	@KafkaListener(groupId = "odin23", topics = "asgard.openmrs.patient_identifier", containerFactory = "userKafkaListenerContainerFactory")
	public void patientidentifier(User user) {
		int counter =1000;
		while(lock ==1 && counter >5){
			System.out.println("waiting");
			counter--;
		}
		if( !resp.isEmpty()){

		for (int i = 0; i < resp.size(); i++) {
			System.out.println(user.getPatient_id());
			System.out.println("checkme"+user.getIdentifier().substring(0,1));
			

				if( Objects.equals(user.getPatient_id(), resp.get(i).getPeresonid()) && !"N".equals(user.getIdentifier().substring(0,1)) ){
					resp.get(i).setRef(user.getIdentifier());
					resp.get(i).setDisplay_name(resp.get(i).getName()+" "+"["+ user.getIdentifier()+"]");
	
	
					ResPartner ResInsert = new ResPartner(resp.get(i));
					save(ResInsert);	
	
				}
			}

		}
			else{
				System.out.println("could not ");
			}
		  
		  lock =1;

		
	}


	public static void main(String[] args) {
		SpringApplication.run(AsgardApplication.class, args);
	}
}
