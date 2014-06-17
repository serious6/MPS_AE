package bai5_hibernate.MPS_AE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import bai5_hibernate.MPS_AE.hibernate.ds.impl.AngebotDsImpl;

@Configuration
@ComponentScan
public class TestConfig {

	@Bean
	public AngebotDsImpl getAngebotDsImpl() {
		return new AngebotDsImpl();
	}

}
