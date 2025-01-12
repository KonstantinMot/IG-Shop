package com.ig81.igshop.data.local.repository

import com.ig81.igshop.data.local.entity.UserAchievement
import com.ig81.igshop.domain.repository.UserRepository

class UserRepositoryImpl :UserRepository{
    private val users = listOf(
        UserAchievement(1, "Николай", 489, true),
        UserAchievement(2, "Дарья", 133, false),
        UserAchievement(3, "Ольга", 499, true),
        UserAchievement(4, "Владимир", 204, false),
        UserAchievement(5, "Ксения", 393, true),
        UserAchievement(6, "Алиса", 175, false),
        UserAchievement(7, "Анна", 312, true),
        UserAchievement(8, "Сергей", 420, false),
        UserAchievement(9, "Иван", 215, true),
        UserAchievement(10, "Мария", 144, false),
        UserAchievement(11, "Артем", 478, true),
        UserAchievement(12, "Елена", 295, false),
        UserAchievement(13, "Дмитрий", 350, true),
        UserAchievement(14, "Татьяна", 172, false),
        UserAchievement(15, "Петр", 285, true),
        UserAchievement(16, "Максим", 367, false),
        UserAchievement(17, "Юрий", 211, true),
        UserAchievement(18, "Виктория", 456, false),
        UserAchievement(19, "Алексей", 389, true),
        UserAchievement(20, "Наталья", 198, false)
    )
    override suspend fun getUsers(): List<UserAchievement> {
       return users
    }
}