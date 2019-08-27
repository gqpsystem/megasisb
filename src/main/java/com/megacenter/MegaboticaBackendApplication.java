package com.megacenter;

import com.megacenter.dao.IParentDAO;
import com.megacenter.model.Child;
import com.megacenter.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class MegaboticaBackendApplication implements CommandLineRunner {

        @Autowired
        private IParentDAO dao ;
    
	public static void main(String[] args) {
		SpringApplication.run(MegaboticaBackendApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
     
        
    }
            
        
}
