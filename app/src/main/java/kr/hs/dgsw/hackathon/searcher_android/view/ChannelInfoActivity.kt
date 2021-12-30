package kr.hs.dgsw.hackathon.searcher_android.view

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import kr.hs.dgsw.hackathon.searcher_android.base.BaseActivity
import kr.hs.dgsw.hackathon.searcher_android.databinding.ActivityChannelInfoBinding
import kr.hs.dgsw.hackathon.searcher_android.viewmodel.ChannelInfoViewModel

class ChannelInfoActivity : BaseActivity<ActivityChannelInfoBinding, ChannelInfoViewModel>() {
    override val viewModel: ChannelInfoViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {
            getSuccess.observe(this@ChannelInfoActivity, Observer {
                mBinding.channelTitle.text = "채널명 : $it.channelTitle"
                mBinding.channelSub.text = "구독자수 : $it.totalSubscribers"
                mBinding.channelView.text = "총 조회수 : $it.totalView"

                Glide.with(this@ChannelInfoActivity)
                    .load(it.thumbnails)
                    .into(mBinding.thumbnail)
            })
            getError.observe(this@ChannelInfoActivity, Observer {
                Toast.makeText(this@ChannelInfoActivity, "정보를 가져오지 못화였습니다.", Toast.LENGTH_SHORT)
                    .show()
            })
        }
    }
}