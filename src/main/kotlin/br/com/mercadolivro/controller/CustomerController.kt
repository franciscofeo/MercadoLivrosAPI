package br.com.mercadolivro.controller

import br.com.mercadolivro.dto.CustomerDTO
import br.com.mercadolivro.model.Customer
import br.com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val customerService: CustomerService
) {


    @GetMapping("/search")
    fun getCustomers(@RequestParam name: String?): List<Customer>{
        return customerService.getCustomer(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customerDTO: CustomerDTO){
        customerService.createCustomer(customerDTO)
    }

    @GetMapping("/search/{id}")
    fun getById(@PathVariable id: Long): Customer{
        return customerService.getById(id)
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateById(@PathVariable id: Long, @RequestBody customerDTO: CustomerDTO){
        customerService.updateById(id, customerDTO)
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteById(@PathVariable id: Long){
        customerService.deleteById(id)
    }
}