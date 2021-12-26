package br.com.mercadolivro.model

import br.com.mercadolivro.enum.BookStatus
import java.math.BigDecimal
import javax.persistence.*

@Entity
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String,
    var price: BigDecimal,

    @Enumerated(EnumType.STRING)
    var bookStatus: BookStatus,

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    var customer: Customer

)