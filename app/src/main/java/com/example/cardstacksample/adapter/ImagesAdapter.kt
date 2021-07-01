package com.example.cardstacksample.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cardstacksample.model.ProfileImage
import com.example.cardstacksample.databinding.ItemImageBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>() {

    companion object {
        private val TAG = "ImagesAdapter"
    }

    private val profileImageList = ArrayList<ProfileImage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        return ImagesViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(profileImageList[position])
    }

    fun submitItems(profileImageList: ArrayList<ProfileImage>) {
        this.profileImageList.apply {
            clear()
            addAll(profileImageList)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return profileImageList.size
    }


    inner class ImagesViewHolder(val itemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root) {
        @SuppressLint("ClickableViewAccessibility")
        fun bind(profileImage: ProfileImage) {
            Glide.with(itemImageBinding.root.context)
                .load(profileImage.image)
                .into(itemImageBinding.ivProfileImage)

            itemImageBinding.ivProfileImage.setOnTouchListener { view, event ->
                Log.d(TAG, "onTouch: ")
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        Log.d(TAG, "Action Down ")
                        Log.d(TAG, "Parent -> ${view.parent.parent.parent.parent.parent}")
                        view.parent.parent.parent.parent.parent.requestDisallowInterceptTouchEvent(
                            true)
                    }
                    MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                        Log.d(TAG, "Action Up ")
                        Log.d(TAG, "Parent -> ${view.parent.parent.parent.parent.parent.parent}")
                        view.parent.parent.parent.parent.parent.parent.requestDisallowInterceptTouchEvent(
                            false)
                    }
                }
                true
            }
        }
    }
}