package com.ig81.igshop.domain.usecase

import com.ig81.igshop.data.local.entity.UserAchievement
import com.ig81.igshop.domain.repository.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(
        onlyVip: Boolean = false,
        limit:Int?=null
    ): List<UserAchievement> {

        val users = userRepository.getUsers()


        val filteredUsers = if (onlyVip) {
            users.filter { it.vip }
        } else {
            users
        }
        val sortedUsers = filteredUsers.sortedByDescending { it.balls }


        return limit?.let { sortedUsers.take(it) } ?: sortedUsers
    }
    }