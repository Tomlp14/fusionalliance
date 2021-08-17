package com.tommywebdesigns.fusionalliance.view.fragment

import com.tommywebdesigns.fusionalliance.model.data.GitHubResponseItem

interface GitHubSelector {
    fun openDetailsFragment(result: GitHubResponseItem)
}