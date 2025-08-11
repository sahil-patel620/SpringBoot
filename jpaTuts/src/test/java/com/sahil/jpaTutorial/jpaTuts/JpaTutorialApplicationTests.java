package com.sahil.jpaTutorial.jpaTuts;

import com.sahil.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.sahil.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.quantity(12)
				.price(BigDecimal.valueOf(132.4))
				.build();


		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities = productRepository.findByTitle("Pepsi");
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(LocalDateTime.of(2025,1,1,0,0,0));
//		List<ProductEntity> entities = productRepository.findByQuantityAndPrice(12, BigDecimal.valueOf(132.4));
//		List<ProductEntity> entities = productRepository.findByQuantityGreaterThanOrPriceLessThan(1, BigDecimal.valueOf(150));
//		List<ProductEntity> entities = productRepository.findByTitleLike("%Choco%");
//		List<ProductEntity> entities = productRepository.findByTitleContaining("Choco");
		List<ProductEntity> entities = productRepository.findByTitleContainingIgnoreCase("CHOco");

		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository(){
		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("Pepsi", BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}
}
