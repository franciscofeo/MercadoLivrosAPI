package br.com.mercadolivro.dto

import br.com.mercadolivro.enum.BookStatus
import br.com.mercadolivro.model.Book
import br.com.mercadolivro.model.Customer
import java.math.BigDecimal

data class BookDTO (var name: String, var price: BigDecimal, var customerId: Long) {

    fun postDtoToBook(customer: Customer): Book{
        return Book(
            name = this.name,
            price = this.price,
            bookStatus = BookStatus.ACTIVE,
            customer = customer
        )
    }

    fun putDtoToBook(customer: Customer, status: BookStatus): Book{
        return Book(
            name = this.name,
            price = this.price,
            bookStatus = status,
            customer = customer
        )
    }

}