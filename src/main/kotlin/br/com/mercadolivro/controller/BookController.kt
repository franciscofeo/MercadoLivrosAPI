package br.com.mercadolivro.controller

import br.com.mercadolivro.dto.BookDTO
import br.com.mercadolivro.enum.BookStatus
import br.com.mercadolivro.model.Book
import br.com.mercadolivro.service.BookService
import br.com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
){

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    fun getBook(): List<Book>{
        return bookService.getBooks()
    }

    @GetMapping("/search/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getBookById(@PathVariable id: Long): Book{
        return bookService.getBookById(id)
    }

    @GetMapping("/search/active")
    @ResponseStatus(HttpStatus.OK)
    fun getActiveBooks(): List<Book>{
        return bookService.findAllActives()
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody book: BookDTO){
        val customer = customerService.getById(book.customerId)
        bookService.createBook(book.postDtoToBook(customer))
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateById(@PathVariable id: Long, @RequestParam status: String, @RequestBody bookDTO: BookDTO){
        val customer = customerService.getById(id)
        lateinit var bookStatus: BookStatus
        when (status){
            "deleted" -> bookStatus = BookStatus.DELETED
            "sold" -> bookStatus = BookStatus.SOLD
            "active" -> bookStatus = BookStatus.ACTIVE
            "canceled" -> bookStatus = BookStatus.CANCELED
        }
        bookService.updateById(id, bookDTO.putDtoToBook(customer, bookStatus))
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long){
        bookService.deleteById(id)
    }

}