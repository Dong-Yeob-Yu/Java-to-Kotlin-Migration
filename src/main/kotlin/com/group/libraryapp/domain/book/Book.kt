package com.group.libraryapp.domain.book

import javax.persistence.*

@Entity
class Book (
    val name: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    init{
        if(name.isBlank()){
            throw IllegalArgumentException("Book name cannot is blank")
        }
    }

    // Object Mother 객체
    companion object{
        fun fixture(
            name: String = "책 이름",
            type: BookType = BookType.COMPUTER,
            id: Long? = null,
        ) : Book {
            return Book(name = name, type = type, id = id)
        }
    }

}