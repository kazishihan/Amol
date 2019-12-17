package com.islamik.amol

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.View
import com.github.islamkhsh.CardSliderAdapter
import kotlinx.android.synthetic.main.item_card_content.view.*
import kotlin.collections.ArrayList

class MovieAdapter(items : ArrayList<Movie>, var context: Context) : CardSliderAdapter<Movie>(items) {

    lateinit var tts: TextToSpeech
    private var flagUk = 0
    private var pos: Int = 0


    override fun bindView(position: Int, itemContentView: View, item: Movie?) {


        item?.run {

            var pos:String= (position+1).toString()
            itemContentView.movie_title.text ="আমল :${convertEngToBn(pos)}"
            itemContentView.movie_overview.text = overview
        }

itemContentView.shareIv.setOnClickListener {

    (context as MainActivity).shareIt(item!!.overview)
}


    }





    override fun getItemContentLayout(position: Int) = R.layout.item_card_content


    fun convertEngToBn(num: String): String? {
        var num = num
        num = num.replace("0", "০")
        num = num.replace("1", "১")
        num = num.replace("2", "২")
        num = num.replace("3", "৩")
        num = num.replace("4", "৪")
        num = num.replace("5", "৫")
        num = num.replace("6", "৬")
        num = num.replace("7", "৭")
        num = num.replace("8", "৮")
        num = num.replace("9", "৯")
        return num
    }

//    private fun shareIt( str:String) {
//        val sharingIntent = Intent(android.content.Intent.ACTION_SEND)
//        sharingIntent.type = "text/plain"
//        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Application")
//        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, str)
//        startActivity(Intent.createChooser(sharingIntent, "Share via"))
//    }
}


