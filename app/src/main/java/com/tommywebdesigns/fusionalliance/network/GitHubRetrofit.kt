package com.tommywebdesigns.fusionalliance.network
import com.tommywebdesigns.fusionalliance.model.data.GitHubResponseItem
import com.tommywebdesigns.fusionalliance.util.Constants.Companion.BASE_URL
import com.tommywebdesigns.fusionalliance.util.Constants.Companion.END_POINT
import com.tommywebdesigns.fusionalliance.util.Constants.Companion.USER_PATH
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRetrofit @Inject constructor(){

    private val gitService= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(GitService::class.java)

    fun getRepositoriesRemote(username: String)= gitService.getRepositories(username)


    interface GitService{
      @GET(END_POINT)
      fun getRepositories(@Path(USER_PATH) username: String): Single<List<GitHubResponseItem>>
    }

}