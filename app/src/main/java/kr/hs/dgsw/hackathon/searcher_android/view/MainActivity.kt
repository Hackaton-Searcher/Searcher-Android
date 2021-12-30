package kr.hs.dgsw.hackathon.searcher_android.view

import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import kr.hs.dgsw.hackathon.searcher_android.adapter.YoutubeAdapter
import kr.hs.dgsw.hackathon.searcher_android.base.BaseActivity
import kr.hs.dgsw.hackathon.searcher_android.databinding.ActivityMainBinding
import kr.hs.dgsw.hackathon.searcher_android.model.response.ChannelList
import kr.hs.dgsw.hackathon.searcher_android.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()

    override fun observerViewModel() {
        with(viewModel) {
            val adapter = YoutubeAdapter(this@MainActivity)
            youtuberList.observe(this@MainActivity) {
                val list = mutableListOf<ChannelList>()
                list.add(it)
                Log.d("TEST_LOCATE", "$list")
                adapter.submitList(list)
            }
            errorEvent.observe(this@MainActivity) {
                Toast.makeText(this@MainActivity, "검색어를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}