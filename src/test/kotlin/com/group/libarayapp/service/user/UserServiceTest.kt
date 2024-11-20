package com.group.libarayapp.service.user

import com.group.libraryapp.LibraryAppApplication
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.service.user.UserService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(classes = [LibraryAppApplication::class])
class UserServiceTest (
    @Autowired private val userRepository: UserRepository,
    @Autowired private val userService: UserService
) {

    @DisplayName("유저 저장 테스트")
    @Test
    fun saveUserTest(){
        //given
        val requestDto = UserCreateRequest("이름", null)

        //when
        userService.saveUser(requestDto)

        //then
        val findAll: List<User> = userRepository.findAll()

        Assertions.assertThat(findAll.size).isEqualTo(1)
        Assertions.assertThat(findAll[0].name).isEqualTo("이름")

        // 자바 -> 코틀린일떈 null safe 로 생각하고 가져옴 -> 플랫폼 타입 java getter 에 jetbrains 어노테이션 붙혀야함. null, nullable
        Assertions.assertThat(findAll[0].age).isEqualTo(null)


    }

}