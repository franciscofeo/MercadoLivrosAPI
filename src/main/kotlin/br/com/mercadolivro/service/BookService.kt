package br.com.mercadolivro.service

import br.com.mercadolivro.model.Book
import br.com.mercadolivro.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BookService {

    @Autowired
    lateinit var bookRepository: BookRepository

    fun getBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Book {
        return bookRepository.findById(id).orElseThrow { RuntimeException("Book not found.") }
    }

    fun createBook(book: Book) {
        bookRepository.save(book)
    }

}