package com.example.cardstacksample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cardstacksample.ProfileImage
import com.example.cardstacksample.databinding.ItemImageBinding

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>() {

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
        fun bind(profileImage: ProfileImage) {
            Glide.with(itemImageBinding.root.context)
                .load(profileImage.image)
                .into(itemImageBinding.ivProfileImage)
        }
    }
}