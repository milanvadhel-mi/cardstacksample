package com.example.cardstacksample.verticalstack

import android.R.attr.left
import android.R.attr.right
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.cardstacksample.Card
import com.example.cardstacksample.ProfileImage
import com.example.cardstacksample.adapter.CardStackAdapter
import com.example.cardstacksample.databinding.ActivityVerticalViewPagerBinding
import com.example.cardstacksample.util.DisplayUtils
import com.mindinventory.cardstackview.SliderTransformerVertical


class VerticalViewPagerActivity : AppCompatActivity() {

    companion object {
        private val TAG = "ViewPagerActivity"
    }

    private var centerItemPosition = Int.MAX_VALUE / 2
    private var _binding: ActivityVerticalViewPagerBinding? = null
    val binding get() = _binding!!

    private val cardStackAdapter by lazy { CardStackAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityVerticalViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpCardStack()
    }

    private fun setUpCardStack() {
        binding.vpCardStack.adapter = cardStackAdapter
        cardStackAdapter.setItems(getCardList())
        binding.vpCardStack.offscreenPageLimit = 3
        binding.vpCardStack.setPageTransformer(SliderTransformerVertical(3))
        if (getCardList().size % 2 == 0) {
            centerItemPosition += 1
        } else {
            centerItemPosition += 2
        }
        binding.vpCardStack.setCurrentItem(centerItemPosition, false)
    }

    private fun setMargins() {
        if(binding.vpCardStack.layoutParams is ViewGroup.MarginLayoutParams){
            val params = binding.vpCardStack.layoutParams as ViewGroup.MarginLayoutParams
            val marginVertical = DisplayUtils.getDisplayHeight(this) / 18
            //val marginVertical = DisplayUtils.getDisplayHeight(this) / 75
            params.setMargins(0, marginVertical, 0, marginVertical)
            binding.vpCardStack.requestLayout()
        }
    }

    private fun getCardList(): ArrayList<Card> {
        val profileImageList1 = ArrayList<ProfileImage>().apply {
            add(ProfileImage("https://cdn.pixabay.com/photo/2016/03/23/04/01/woman-1274056_960_720.jpg"))
            add(ProfileImage("https://cdn.pixabay.com/photo/2017/08/06/15/13/woman-2593366__340.jpg"))
            add(ProfileImage("https://cdn.pixabay.com/photo/2016/11/16/10/26/girl-1828536__340.jpg"))
        }
        val profileImageList2 = ArrayList<ProfileImage>().apply {
            add(ProfileImage("https://cdn.pixabay.com/photo/2016/03/23/04/01/woman-1274056_960_720.jpg"))
            add(ProfileImage("https://cdn.pixabay.com/photo/2017/08/06/15/13/woman-2593366__340.jpg"))
            add(ProfileImage("https://cdn.pixabay.com/photo/2016/11/16/10/26/girl-1828536__340.jpg"))
        }
        val profileImageList3 = ArrayList<ProfileImage>().apply {
            add(ProfileImage("https://cdn.pixabay.com/photo/2016/03/23/04/01/woman-1274056_960_720.jpg"))
            add(ProfileImage("https://cdn.pixabay.com/photo/2017/08/06/15/13/woman-2593366__340.jpg"))
            add(ProfileImage("https://cdn.pixabay.com/photo/2016/11/16/10/26/girl-1828536__340.jpg"))
        }

        val cardList = ArrayList<Card>().apply {
            add(
                Card(
                    name = "Dia Joseph",
                    age = 25,
                    country = "US",
                    profileImageList1
                )
            )
            add(
                Card(
                    name = "Maria",
                    age = 25,
                    country = "India",
                    profileImageList2
                )
            )
            add(
                Card(
                    name = "Michale",
                    age = 25,
                    country = "Italy",
                    profileImageList3
                )
            )
            add(
                Card(
                    name = "Mikey",
                    age = 25,
                    country = "UK",
                    profileImageList1
                )
            )
            add(
                Card(
                    name = "Ina",
                    age = 25,
                    country = "UN",
                    profileImageList2
                )
            )
            add(
                Card(
                    name = "Jeny",
                    age = 25,
                    country = "India",
                    profileImageList3
                )
            )
        }
        return cardList
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}