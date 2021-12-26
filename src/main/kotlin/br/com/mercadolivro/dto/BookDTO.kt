package br.com.mercadolivro.dto

import br.com.mercadolivro.enum.BookStatus
import br.com.mercadolivro.model.Book
import br.com.mercadolivro.model.Customer
import java.math.BigDecimal

data class BookDTO (var name: String, var price: BigDecimal) {

    constructor(name: String, price: BigDecimal, customerId: Long,) : this(name, price){

    }

    fun postDtoToBook(customer: Customer): Book{
        return Book(
            name = this.name,
            price = this.price,
            bookStatus = BookStatus.ACTIVE,
            customer = customer
        )
    }

}