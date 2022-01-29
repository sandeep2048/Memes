package com.dillmill.sanson_memes.ui.characters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dillmill.sanson_memes.data.entities.DilMeme
import com.dillmill.sanson_memes.databinding.ItemMemeBinding

class MemesAdapter(private val listener: MemeItemListener) : RecyclerView.Adapter<CharacterViewHolder>() {

    interface MemeItemListener {
        fun onClickedCharacter(characterId: Int)
    }

    private val items = ArrayList<DilMeme>()

    fun setItems(items: ArrayList<DilMeme>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding: ItemMemeBinding = ItemMemeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) = holder.bind(items[position])
}

class CharacterViewHolder(private val itemBinding: ItemMemeBinding, private val listener: MemesAdapter.MemeItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var character: DilMeme

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: DilMeme) {
        this.character = item
        itemBinding.name.text = item.name
        itemBinding.root.post {
            Glide.with(itemBinding.root)
                .load(item.url)
                .into(itemBinding.image)
        }

    }

    override fun onClick(v: View?) {
        listener.onClickedCharacter(character.id)
    }
}

