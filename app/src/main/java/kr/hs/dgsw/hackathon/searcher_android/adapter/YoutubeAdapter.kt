package kr.hs.dgsw.hackathon.searcher_android.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.hs.dgsw.hackathon.searcher_android.R
import kr.hs.dgsw.hackathon.searcher_android.adapter.callback.YoutubeDiffUtilCallBack
import kr.hs.dgsw.hackathon.searcher_android.databinding.ChannelItemBinding
import kr.hs.dgsw.hackathon.searcher_android.model.response.ChannelList
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData
import kr.hs.dgsw.hackathon.searcher_android.util.SingleLiveEvent
import kr.hs.dgsw.hackathon.searcher_android.viewmodel.item.ChannelItemViewModel

class YoutubeAdapter(val lifecycleOwner: LifecycleOwner) :
    ListAdapter<ChannelList, YoutubeAdapter.YoutubeViewHolder>(YoutubeDiffUtilCallBack) {

    class YoutubeViewHolder(private val binding: ChannelItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ChannelList, lifecycleOwner: LifecycleOwner) {
            val viewModel = ChannelItemViewModel()

            viewModel.bind(data)
            binding.vm = viewModel

            Glide.with(binding.root)
                .load(data.channelList[0].thumbnails)
                .into(binding.ivThumbnail)

            viewModel.openPostEvent.observe(lifecycleOwner) {
                onClickItemEvent.value = data.channelList[0].channelId
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YoutubeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ChannelItemBinding>(
            layoutInflater,
            R.layout.channel_item,
            parent,
            false
        )

        return YoutubeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: YoutubeViewHolder, position: Int) {
        holder.bind(getItem(position), lifecycleOwner)
    }

    companion object {
        val onClickItemEvent = SingleLiveEvent<String>()
    }
}