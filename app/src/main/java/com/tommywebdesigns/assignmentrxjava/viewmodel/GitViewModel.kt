package com.tommywebdesigns.assignmentrxjava.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tommywebdesigns.assignmentrxjava.model.data.GitHubResponseItem
import com.tommywebdesigns.assignmentrxjava.util.GitHubSingleton.Companion.gitHubComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GitViewModel: ViewModel() {

    val gitData= MutableLiveData<List<GitHubResponseItem>>()
    private val compositeDisposable = CompositeDisposable()
    //every time I fletch the api, the data is added to the compositeDisposable. I can then dispose this data.
    fun init(userName: String) {

        compositeDisposable.add(
            gitHubComponent.getRepository().readFromRemoteSource(userName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map{
                    it
                }.subscribe({results ->
                    gitData.postValue(results)
                },{throwable ->
                    Log.d("TAG_X", "Oops, you don't have internet.")
                })
        )
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


}