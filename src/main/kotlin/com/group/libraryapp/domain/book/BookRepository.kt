package com.group.libraryapp.domain.book

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface BookRepository : JpaRepository<Book, Long> {

    fun findByName(bookName: String): Book?
}