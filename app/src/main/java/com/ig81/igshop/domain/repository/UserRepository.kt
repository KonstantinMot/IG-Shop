package com.ig81.igshop.domain.repository

import com.ig81.igshop.data.local.entity.UserAchievement

interface UserRepository{
suspend fun getUsers():List<UserAchievement>
}