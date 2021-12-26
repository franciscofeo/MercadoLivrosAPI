package br.com.mercadolivro.repository

import br.com.mercadolivro.enum.BookStatus
import br.com.mercadolivro.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
    fun findAllByBookStatus(bookStatus: BookStatus): List<Book>
}