package kr.hs.dgsw.hackathon.searcher_android.view

import androidx.activity.viewModels
import kr.hs.dgsw.hackathon.searcher_android.base.BaseActivity
import kr.hs.dgsw.hackathon.searcher_android.databinding.ActivityChannelInfoBinding
import kr.hs.dgsw.hackathon.searcher_android.viewmodel.ChannelInfoViewModel

class ChannelInfoActivity : BaseActivity<ActivityChannelInfoBinding, ChannelInfoViewModel>() {
    override val viewModel: ChannelInfoViewModel by viewModels()

    override fun observerViewModel() {
        TODO("Not yet implemented")
    }
}