package com.bootcamp.pos.EzyPOS.api;

import com.bootcamp.pos.EzyPOS.dto.request.CustomerRequestDto;
import com.bootcamp.pos.EzyPOS.service.CustomerService;
import com.bootcamp.pos.EzyPOS.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "/create",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})//http://localhost:8000/api/v1/customer/create (POST)
    public ResponseEntity<StandardResponse> save(@RequestBody CustomerRequestDto dto){
        return new  ResponseEntity<>(
                new StandardResponse(
                        201,
                        customerService.saveCustomer(dto),
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")//http://localhost:8000/api/v1/customer/2 (GET)
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id+" details!",
                        customerService.findCustomer(id)
                ), HttpStatus.OK
        );
    }

    @PutMapping(value = "/modify",params = {"id"})//http://localhost:8000/api/v1/customer/modify?id=2 (PUT)
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerRequestDto dto, @RequestParam String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        customerService.updateCustomer(dto,id),
                        null
                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/remove/{id}")//http://localhost:8000/api/v1/customer/remove/2 (DELETE)
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        customerService.deleteCustomer(id),
                        null
                ), HttpStatus.OK
        );
    }

    @GetMapping(value = "/list", params = {"searchText","page","size"})//http://localhost:8000/api/v1/customer/list?searchText=dfjfl&page=1&size=20 (GET)
    public ResponseEntity<StandardResponse> findAllCustomer(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        customerService.findAllCustomer(searchText,page,size)
                ), HttpStatus.OK
        );
    }
}
