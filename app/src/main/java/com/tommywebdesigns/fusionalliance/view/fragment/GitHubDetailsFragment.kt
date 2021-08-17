package com.tommywebdesigns.fusionalliance.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tommywebdesigns.fusionalliance.databinding.GithubDetailsFragmentLayoutBinding
import com.tommywebdesigns.fusionalliance.model.data.GitHubResponseItem
import com.tommywebdesigns.fusionalliance.util.Constants.Companion.RESULT_KEY

class GitHubDetailsFragment: Fragment() {
   //Instead of having to instantiate the fragment, I can get it straigth from this static method (the class instead).
    //It's only instantiated once
    companion object {
       lateinit var gitHubDetailsFragment: GitHubDetailsFragment
        fun getInstance(result: GitHubResponseItem): GitHubDetailsFragment{
            if(!this::gitHubDetailsFragment.isInitialized)
                gitHubDetailsFragment = GitHubDetailsFragment()
            return gitHubDetailsFragment.also {
                it.arguments= Bundle().also { bnd->
                    bnd.putParcelable(RESULT_KEY, result)
                }
            }
        }
    }

    private lateinit var binding: GithubDetailsFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GithubDetailsFragmentLayoutBinding.inflate(inflater, container, false)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         arguments?.getParcelable<GitHubResponseItem>(RESULT_KEY)?.let {
          binding.detailsNameTv.text= it.name.toString()
             binding.gitUrlTv.text= it.git_url.toString()
             binding.fullNameTv.text= it.full_name.toString()
             binding.languageTv.text= it.language.toString()


         }
    }
}