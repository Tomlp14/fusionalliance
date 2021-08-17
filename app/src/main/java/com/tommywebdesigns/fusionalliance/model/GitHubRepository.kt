package com.tommywebdesigns.fusionalliance.model

import com.tommywebdesigns.fusionalliance.model.data.GitHubResponseItem
import com.tommywebdesigns.fusionalliance.network.GitHubRetrofit
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor(private val gitHubRetrofit: GitHubRetrofit){

    fun readFromRemoteSource(userName: String): Single<List<GitHubResponseItem>> = gitHubRetrofit.getRepositoriesRemote(userName)
}