package com.tommywebdesigns.assignmentrxjava.view.fragment

import com.tommywebdesigns.assignmentrxjava.model.data.GitHubResponseItem

interface GitHubSelector {
    fun openDetailsFragment(result: GitHubResponseItem)
}