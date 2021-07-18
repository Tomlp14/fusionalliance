package com.tommywebdesigns.assignmentrxjava.view.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tommywebdesigns.assignmentrxjava.databinding.ListItemLayoutBinding
import com.tommywebdesigns.assignmentrxjava.model.data.GitHubResponseItem


class GitHupAdapter(private val delegate: GitHubDelegate): RecyclerView.Adapter<GitHupAdapter.ListViewHolder>() {

    interface GitHubDelegate{
        fun selectProject(result: GitHubResponseItem)
    }

    inner class ListViewHolder(val binding: ListItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    var listResutls = listOf<GitHubResponseItem>()
    set(value){
        field=value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding= ListItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val gitHubResponseItem= listResutls[position]

        holder.itemView.setOnClickListener {
            delegate.selectProject(gitHubResponseItem)
        }

        holder.binding.nameTv.text= gitHubResponseItem.name.toString()


    }

    override fun getItemCount(): Int = listResutls.size


}