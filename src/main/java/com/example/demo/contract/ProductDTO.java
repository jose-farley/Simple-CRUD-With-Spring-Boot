
package com.example.demo.contract;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

   
@Data
@NoArgsConstructor
@AllArgsConstructor


public class ProductDTO {
  private int id;

  private String name;
 
  private String code;

  private double price;
 
}
