package com.tommywebdesigns.fusionalliance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.tommywebdesigns.fusionalliance.databinding.ActivityMainBinding
import com.tommywebdesigns.fusionalliance.model.data.GitHubResponseItem
import com.tommywebdesigns.fusionalliance.view.adaptor.GitHupAdapter
import com.tommywebdesigns.fusionalliance.view.fragment.GitHubDetailsFragment
import com.tommywebdesigns.fusionalliance.viewmodel.GitViewModel

class MainActivity : AppCompatActivity(), GitHupAdapter.GitHubDelegate {

    private val viewModel by viewModels<GitViewModel>()
    private lateinit var binding: ActivityMainBinding
    private val adapter= GitHupAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listRv.visibility = View.GONE

        binding.searchBt.setOnClickListener {
            searchGitHubRepository(binding.userNameEt.text.toString())
        }


    }

    override fun selectProject(result: GitHubResponseItem) {
        val fragment = GitHubDetailsFragment.getInstance(result)
        binding.listRv.visibility = View.GONE
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right,android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            .add(R.id.details_frame, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }

    fun searchGitHubRepository(userName: String){
        //This is when I set the adapter to the recycler view
        binding.listRv.visibility = View.VISIBLE
        binding.userNameEt.visibility= View.GONE
        binding.searchBt.visibility= View.GONE
        binding.listRv.adapter= adapter
        viewModel.init(userName)
        viewModel.gitData.observe(this, {
            adapter.listResutls=it
        })
    }



}