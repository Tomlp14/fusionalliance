package com.tommywebdesigns.fusionalliance

import android.app.Application
import com.tommywebdesigns.fusionalliance.di.component.DaggerGitHubComponent
import com.tommywebdesigns.fusionalliance.util.GitHubSingleton

class GitHubApplication: Application(){


    override fun onCreate() {
        super.onCreate()
        GitHubSingleton.gitHubComponent = DaggerGitHubComponent.create()
    }
}