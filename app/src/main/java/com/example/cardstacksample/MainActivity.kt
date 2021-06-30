package com.example.cardstacksample

import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.cardstacksample.adapter.CardStackAdapter
import com.example.cardstacksample.databinding.ActivityMainBinding
import com.mindinventory.cardstackview.*

class MainActivity : AppCompatActivity(R.layout.activity_main), CardStackListener {

    companion object {
        private val TAG = "MainActivity"
    }

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    private val cardStackManager by lazy { CardStackLayoutManager(this, this) }
    private val cardStackAdapter by lazy { CardStackAdapter() }
    private var prevItemPosition = -1
    private var tempCardList = ArrayList<Card>()
    private var centerItemPosition = Int.MAX_VALUE / 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpCardStack()
    }

    private fun setUpCardStack() {
        cardStackManager.setLastPosition(getCardList().size-1)
        with(cardStackManager) {
            setStackFrom(StackFrom.Bottom)
            setVisibleCount(4)
            setTranslationInterval(12.0f)
            setScaleInterval(0.95f)
            setSwipeThreshold(0.3f)
            setMaxDegree(20.0f)
            setDirections(Direction.HORIZONTAL)
            setCanScrollHorizontal(true)
            setCanScrollVertical(true)
            setSwipeableMethod(SwipeableMethod.Manual)
            setOverlayInterpolator(LinearInterpolator())
            binding.cardStackView.layoutManager = this
            binding.cardStackView.adapter = cardStackAdapter
            cardStackAdapter.setItems(getCardList())
            binding.cardStackView.itemAnimator.apply {
                if (this is DefaultItemAnimator) {
                    supportsChangeAnimations = false
                }
            }
           /* if (getCardList().size % 2 == 0) {
                centerItemPosition += 1
            } else {
                centerItemPosition += 2
            }
            binding.cardStackView.scrollToPosition(centerItemPosition)*/
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
        tempCardList.clear()
        tempCardList.addAll(cardList)
        return cardList
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {

    }

    override fun onCardSwiped(direction: Direction?) {
        when (direction) {
              /*Direction.Left -> {
                  // Next
                  if (prevItemPosition != getCardList().size) {
                      prevItemPosition++
                      tempCardList.removeAt(prevItemPosition)
                  }
              }
              Direction.Right -> {
                  Log.d(TAG, "prevItemPosition : $prevItemPosition")
                  if (prevItemPosition != -1) {

                      prevItemPosition--
                  }
              }*/
        }
    }

   /* private fun getPreviousCard() {
        val newList = ArrayList<Card>()
        for (item in (prevItemPosition) until getCardList().size) {
            newList.add(getCardList()[item])
        }

        val callback = CardDiffCallback(getCardList(), newList)
        val result = DiffUtil.calculateDiff(callback)
        cardStackAdapter.setItems(newList)
        result.dispatchUpdatesTo(cardStackAdapter)
    }*/

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}