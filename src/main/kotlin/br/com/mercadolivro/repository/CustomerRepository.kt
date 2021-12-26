package br.com.mercadolivro.repository

import br.com.mercadolivro.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {

    fun findAllByName(name: String) : List<Customer>

}