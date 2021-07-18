package com.tommywebdesigns.assignmentrxjava.di.component

import com.tommywebdesigns.assignmentrxjava.model.GitHubRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface GitHubComponent {

    fun getRepository(): GitHubRepository
}