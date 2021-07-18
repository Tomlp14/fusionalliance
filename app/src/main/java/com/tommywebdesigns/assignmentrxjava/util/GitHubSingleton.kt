package com.tommywebdesigns.assignmentrxjava.util

import com.tommywebdesigns.assignmentrxjava.di.component.GitHubComponent

class GitHubSingleton {
    companion object{
        lateinit var gitHubComponent: GitHubComponent
    }
}