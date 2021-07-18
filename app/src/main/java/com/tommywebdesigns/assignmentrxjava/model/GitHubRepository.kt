package com.tommywebdesigns.assignmentrxjava.model

import com.tommywebdesigns.assignmentrxjava.model.data.GitHubResponse
import com.tommywebdesigns.assignmentrxjava.model.data.GitHubResponseItem
import com.tommywebdesigns.assignmentrxjava.network.GitHubRetrofit
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor(private val gitHubRetrofit: GitHubRetrofit){

    fun readFromRemoteSource(userName: String): Single<List<GitHubResponseItem>> = gitHubRetrofit.getRepositoriesRemote(userName)
}