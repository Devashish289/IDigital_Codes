package com.cg.fas.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.fas.dto.AdvertisementDto;
import com.cg.fas.exception.AdvertisementNotFoundException;

@SpringBootTest
class AdvertisementServiceImplTest {
	@Autowired
	AdvertisementService adService;

	@Test
	void testAddAdvertisement() {
		AdvertisementDto advertisement = new AdvertisementDto("Ad10011",2000,"C10001","210","Sell","Seller","S10001");
		assertThat(adService.addAdvertisement(advertisement).getAdvertisementId().equals("Ad10011"));
		adService.deleteAdvertisement(advertisement.getAdvertisementId());
	}

	@Test
	void testDeleteAdvertisement() {
		AdvertisementDto advertisement = new AdvertisementDto("Ad10011",2000,"C10001","210","Sell","Seller","S10001");
		adService.addAdvertisement(advertisement);
		assertThat(adService.deleteAdvertisement(advertisement.getAdvertisementId()).equals("Advertisement deleted successfully"));
		
	}

	@Test
	void testViewMyAdvertisements() {
		AdvertisementDto advertisement = new AdvertisementDto("Ad10002",3000,"C10002","300","Purchase","Farmer","S10002");
		assertThat(adService.viewMyAdvertisements("S10002").get(0).equals(advertisement));
	}

	@Test
	void testViewAdvertisements() {
		assertThat(adService.viewAdvertisements("S10001", "Farmer").size()==2);
	}
	
	@Test
	void testViewMyAdvertisementsExceptionCase() {
		assertThrows(AdvertisementNotFoundException.class, ()->{adService.viewMyAdvertisements("S10005");});
	}

}
