package com.example.cardstacksample.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.cardstacksample.Card

class CardDiffCallback(
    private val old: List<Card>,
    private val new: List<Card>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].name == new[newPosition].name
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}