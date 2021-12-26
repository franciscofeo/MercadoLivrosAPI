package br.com.mercadolivro.service

import br.com.mercadolivro.dto.CustomerDTO
import br.com.mercadolivro.model.Customer
import br.com.mercadolivro.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun getCustomer(name: String?): List<Customer> {
        name?.let {
            return customerRepository.findAllByName(name);
        }
        return customerRepository.findAll()
    }

    fun createCustomer(customer: Customer){
        customerRepository.save(customer)
    }

    fun getById(id: Long): Customer{
        return customerRepository.findById(id).orElseThrow { RuntimeException("Customer not found!") }
    }

    fun updateById(id: Long, customerDTO: CustomerDTO){
        if(!customerRepository.existsById(id)){
            throw RuntimeException("Customer not exists!")
        }
        val customer: Customer = Customer(id, customerDTO.name, customerDTO.email)
        customerRepository.save(customer)

    }

    fun deleteById(id: Long){
        if(!customerRepository.existsById(id)){
            throw RuntimeException("Customer not found!")
        }
        customerRepository.deleteById(id)
    }

}