package com.tommywebdesigns.assignmentrxjava

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.tommywebdesigns.assignmentrxjava.databinding.ActivityMainBinding
import com.tommywebdesigns.assignmentrxjava.databinding.ListItemLayoutBinding
import com.tommywebdesigns.assignmentrxjava.model.GitHubRepository
import com.tommywebdesigns.assignmentrxjava.model.data.GitHubResponseItem
import com.tommywebdesigns.assignmentrxjava.view.adaptor.GitHupAdapter
import com.tommywebdesigns.assignmentrxjava.view.fragment.GitHubDetailsFragment
import com.tommywebdesigns.assignmentrxjava.view.fragment.GitHubSelector
import com.tommywebdesigns.assignmentrxjava.viewmodel.GitViewModel

class MainActivity : AppCompatActivity(), GitHupAdapter.GitHubDelegate {

    private val viewModel by viewModels<GitViewModel>()
    private lateinit var binding: ActivityMainBinding
    private val adapter= GitHupAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //This is when I set the adapter to the recycler view
        binding.listRv.adapter= adapter




        viewModel.init("tomlp14")

        viewModel.gitData.observe(this, {
            it.forEach {
                it
                Log.d("TAG_X", "Full Name: "+it.full_name)
            }
        })
        viewModel.gitData.observe(this, {
            adapter.listResutls=it
        })
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



}