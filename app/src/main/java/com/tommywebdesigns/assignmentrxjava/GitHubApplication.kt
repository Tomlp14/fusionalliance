package com.tommywebdesigns.assignmentrxjava

import android.app.Application
import com.tommywebdesigns.assignmentrxjava.di.component.DaggerGitHubComponent
import com.tommywebdesigns.assignmentrxjava.util.GitHubSingleton

class GitHubApplication: Application(){


    override fun onCreate() {
        super.onCreate()
        GitHubSingleton.gitHubComponent = DaggerGitHubComponent.create()
    }
}