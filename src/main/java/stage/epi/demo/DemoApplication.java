package stage.epi.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import stage.epi.demo.photo.StorageService;

import javax.annotation.Resource;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
@Resource
private StorageService  storageService;
public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

/*storageService.deleteAll();
storageService.init();*/
	}
//	@Bean
//	CommandLineRunner start(AccountService accountService){
//		return args->{
//
//			accountService.save(new Role("ADMIN"));
//			accountService.save(new Role("etudiant"));
//
//			accountService.save(new Role("enseignant"));
//
//
//
//		};
//	}
}
