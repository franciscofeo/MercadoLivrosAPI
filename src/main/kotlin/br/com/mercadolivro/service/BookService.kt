package br.com.mercadolivro.service

import br.com.mercadolivro.enum.BookStatus
import br.com.mercadolivro.model.Book
import br.com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun getBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Book {
        return bookRepository.findById(id).orElseThrow { RuntimeException("Book not found.") }
    }

    fun createBook(book: Book) {
        bookRepository.save(book)
    }

    fun findAllActives(): List<Book>{
        return bookRepository.findAllByBookStatus(BookStatus.ACTIVE)
    }

    fun updateById(id: Long, book: Book){
        if(!bookRepository.existsById(id)){
            throw RuntimeException("Book not found.")
        }
        val bookUpdated = Book(id, book.name, book.price, book.bookStatus, book.customer)
        bookRepository.save(bookUpdated)
    }

    fun deleteById(id: Long){
        val book = bookRepository.findById(id).orElseThrow { RuntimeException("Book not found.") }
        book.bookStatus = BookStatus.DELETED
        bookRepository.save(book)
    }

}