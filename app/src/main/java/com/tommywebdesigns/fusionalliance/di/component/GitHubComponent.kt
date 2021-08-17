package com.tommywebdesigns.fusionalliance.di.component

import com.tommywebdesigns.fusionalliance.model.GitHubRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface GitHubComponent {

    fun getRepository(): GitHubRepository
}