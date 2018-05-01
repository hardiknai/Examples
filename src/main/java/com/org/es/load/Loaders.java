//package com.org.es.load;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.transaction.Transactional;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.stereotype.Component;
//
//import com.org.Application;
//import com.org.es.model.Post;
//import com.org.es.model.Users;
//import com.org.es.repository.UserRepository;
//
//@Component
//public class Loaders implements CommandLineRunner {
//
//	private final static Logger LOGGER = LoggerFactory.getLogger(Application.class); 
//
//	//@Autowired
//	//ElasticsearchOperations operations; 
//	
//	@Autowired
//	UserRepository userRepository; 
//	
//	public void loadAll() {
//		//operations.putMapping(Users.class);
//		LOGGER.info("Loading Data");
//		userRepository.save(getData());
//		LOGGER.info("Loading Completed");
//		
//	}
//
//	private List<Users> getData() {
//		List<Users> users = new  ArrayList<>();
//		users.add(new Users(1l,"Hardik","Java",120000l));
//		users.add(new Users(2l,"Dakshesh Panchal","UI",800000l));
//		users.add(new Users(3l,"Dipika Chauhan","UX",130000l));
//		users.add(new Users(4l,"Varoon","Project Manager",130000l));;
//		return users;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		loadAll();
//	}
//}
