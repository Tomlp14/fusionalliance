package com.tommywebdesigns.fusionalliance.util

import com.tommywebdesigns.fusionalliance.di.component.GitHubComponent

class GitHubSingleton {
    companion object{
        lateinit var gitHubComponent: GitHubComponent
    }
}