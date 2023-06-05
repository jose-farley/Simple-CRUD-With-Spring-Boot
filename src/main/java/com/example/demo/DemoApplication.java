package com.example.demo;


import com.example.demo.contract.ProductDTO;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductServiceImp;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages={
"com.example.something"},exclude = {DataSourceAutoConfiguration.class })
@RestController
@ComponentScan(basePackages = "com.example.demo.*")
@EntityScan("com.example.demo.contract")
@EnableAutoConfiguration
public class DemoApplication  {
        
        
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/products")
        public  ArrayList<ProductDTO> hello(@RequestParam(value = "name", defaultValue = "World") String name) throws SQLException {
          ArrayList<ProductDTO>  data = new ProductDAO().ListProducts();
            System.out.println(data);
          return data;
        }
        @PostMapping("/products")
        public String productSave(@RequestBody ProductDTO product) throws SQLException{
            new ProductDAO().save(product);
            return "Saved!";
        }
        @PutMapping("/products")
         public String productUpdate(@RequestBody ProductDTO product) throws SQLException{
            new ProductDAO().update(product);
            return "Updated!";
        }
        @DeleteMapping("/products")
        public String productDelete(@RequestParam(value = "id") int id) throws SQLException{
            new ProductDAO().delete(id);
            return "Deleted!";
        }

}
