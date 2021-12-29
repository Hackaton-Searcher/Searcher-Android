package kr.hs.dgsw.hackathon.searcher_android.repository

import io.reactivex.Single
import kr.hs.dgsw.hackathon.searcher_android.model.network.Server
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberData
import kr.hs.dgsw.hackathon.searcher_android.model.response.YoutuberListData
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import org.json.JSONObject

class YoutubeRepository {

    fun getYoutuberList(username : String) : Single<List<YoutuberListData>> {
        return Server.retrofit.searchChannelList(username).map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }
            it.body()!!.data
        }
    }

    fun getYoutuberInfo(channelId: String) : Single<YoutuberData> {
        return Server.retrofit.getChannelInfo(channelId).map {
            if (!it.isSuccessful) {
                val errorBody = JSONObject(it.errorBody()!!.string())
                throw Throwable(errorBody.getString("message"))
            }
            it.body()!!.data
        }
    }
}