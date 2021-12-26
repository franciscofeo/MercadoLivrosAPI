package br.com.mercadolivro.dto

import br.com.mercadolivro.model.Customer

data class CustomerDTO(var name: String, var email: String) {

    fun dtoToCustomer(): Customer{
        return Customer(name = this.name, email = this.email)
    }

}