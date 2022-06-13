package com.diogoslz.marketplace.web.controller;

import com.diogoslz.marketplace.domain.Product;
import com.diogoslz.marketplace.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //garantiza a esta clase que va aser un controlado rde clase rest
@RequestMapping("/products") //
public class ProductController {
    @Autowired
    private ProductService productService ;

    @GetMapping("/all") //obteniendo info
    @ApiOperation("Get All Supermarket Products")   //swagger2
    @ApiResponse(code=200,message = "OK")           //swagger2
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")        //swagger2
    @ApiResponses({                                     //swagger2
        @ApiResponse(code = 200,message = "OK"),
        @ApiResponse(code = 404, message = "Product NOT FOUND")
    })
    public ResponseEntity<Product> getProduct(
            @ApiParam(value = "The id of the product", required = true, example = "7")
            @PathVariable("id") int productId){
                return productService.getProduct(productId)
                        .map(pdct -> new ResponseEntity<>(pdct, HttpStatus.OK))
                        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(pdct -> new ResponseEntity<>(pdct, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

}
