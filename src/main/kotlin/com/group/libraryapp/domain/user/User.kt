package com.group.libraryapp.domain.user

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import javax.persistence.*

@Entity
class User(
    var name: String,
    var age: Int?,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {

    init {
        if(name.isBlank()){
            throw IllegalArgumentException("User name cannot be blank")
        }
    }

    fun updateName(name: String){
        this.name = name
    }

    fun loanBook(book: Book){
        this.userLoanHistories.add(UserLoanHistory(user = this, bookName = book.name,isReturn = false, id = null))
    }

    fun returnBook(bookName: String){
        this.userLoanHistories.first { history -> history.bookName == bookName}.doReturn()
    }

}