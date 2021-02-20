package com.example.kursaa.features.episodes.presentation

import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursaa.R
import com.example.kursaa.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    private val linearLayoutManager: LinearLayoutManager by lifecycleScope.inject()
    private val adapter: EpisodeRecyclerViewAdapter by lifecycleScope.inject()
    override val viewModel: EpisodeViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        initRecyclerView()
        setEpisodeList()
        //initialize all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        //handle idle state here
    }

    override fun onPendingState() {
        super.onPendingState()
        //handle pending state here
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            //code to display episodes
        }
    }

    private fun initRecyclerView() {
        episodesRecyclerView.layoutManager = linearLayoutManager
    }

    private fun setEpisodeList() {
        //use adapter to set items on recyclerView
    }
}