package com.group.libraryapp.service.user

import com.group.libraryapp.LibraryAppApplication
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.dto.user.response.UserResponse
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest @Autowired constructor (
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    @AfterEach
    fun clean(){
        userRepository.deleteAll()
    }

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

    @DisplayName("조회 테스트")
    @Test
    fun getUserTest(){
        //given
        userRepository.saveAll(listOf(
            User("A", 10),
            User("B", 20),
            User("C", null),
        ))
        //when
        val users: List<UserResponse> = userService.getUsers()

        //then
        Assertions.assertThat(users.size).isEqualTo(3)
        Assertions.assertThat(users).extracting("name").containsExactlyInAnyOrder("A", "B", "C")
        Assertions.assertThat(users).extracting("age").containsExactlyInAnyOrder(10, 20, null)
    }

    @DisplayName("유저 업데이트 테스트")
    @Test
    fun updateUserNameTest(){
        //given
        val savedUser = userRepository.save(User("A", null))

        //when
        val request = UserUpdateRequest(savedUser.id, "B")
        userService.updateUserName(request)

        //then
        val users: UserResponse = userService.getUsers().get(0)
        Assertions.assertThat(users.name).isEqualTo(request.name)

    }

    @DisplayName("유저 삭제")
    @Test
    fun deleteUserTest(){
        //given
        val savedUser = userRepository.save(User("A", null))

        //when
        userService.deleteUser("A")

        //then
        Assertions.assertThat(userRepository.findAll()).isEmpty();

    }

}