package com.example.cardstacksample.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.cardstacksample.R
import com.example.cardstacksample.databinding.ItemCardBinding
import com.example.cardstacksample.model.Card
import com.mindinventory.CircularAdapter


class CardStackAdapter : CircularAdapter<Card>() {

    companion object {
        private val TAG = "CardStackAdapter"
    }

    private val imagesAdapter by lazy { ImagesAdapter() }

    override fun createItemViewHolder(parent: ViewGroup, viewType: Int): CardStackViewHolder {
        return CardStackViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun bindItemViewHolder(
        holder: RecyclerView.ViewHolder,
        card: Card,
        actualPosition: Int,
        position: Int,
    ) {
        (holder as CardStackViewHolder).bind(card)
    }

    inner class CardStackViewHolder(val itemCardBinding: ItemCardBinding) :
        RecyclerView.ViewHolder(itemCardBinding.root) {
        @SuppressLint("ClickableViewAccessibility")
        fun bind(card: Card) {
            with(itemCardBinding) {
                vpUserImages.adapter = imagesAdapter
                imagesAdapter.submitItems(card.profileImageList)
                tvNameAndAge.text = card.name.plus(", ${card.age}")
                tvCountry.text = card.country
                ivDots.setupWithViewPager(vpUserImages)
                ivDots.apply {
                    setSliderWidth(itemCardBinding.root.context.resources.getDimension(R.dimen.dp_10))
                    setSliderHeight(itemCardBinding.root.context.resources.getDimension(R.dimen.dp_10))
                }
            }
        }
    }
}