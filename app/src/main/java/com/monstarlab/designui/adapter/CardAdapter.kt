package com.monstarlab.designui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.monstarlab.designui.R
import com.monstarlab.designui.model.Card

class CardAdapter(var listCard: ArrayList<Card>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgCard: ImageView
        var tvNameCard: TextView
        var tvAccountNumber: TextView
        var more: ImageView
        var exit: ImageView
        var relMore: RelativeLayout
        var linearLayoutMore: LinearLayout

        init {
            imgCard = itemView.findViewById(R.id.img_card_add)
            tvNameCard = itemView.findViewById(R.id.tv_name_card)
            tvAccountNumber = itemView.findViewById(R.id.account_number)
            more = itemView.findViewById(R.id.img_more)
            exit = itemView.findViewById(R.id.img_exit)
            relMore = itemView.findViewById(R.id.relativelayout_addcard)
            linearLayoutMore = itemView.findViewById(R.id.linearlayout_more)

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_add_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val inforCard = listCard[position]
        holder.imgCard.setImageResource(inforCard.imgCard)
        holder.tvNameCard.text = inforCard.nameCard
        holder.tvAccountNumber.text = inforCard.accountNumber
        holder.more.setOnClickListener {
            holder.more.visibility = ImageView.GONE
            holder.linearLayoutMore.visibility = LinearLayout.VISIBLE
            holder.exit.setOnClickListener {
                holder.linearLayoutMore.visibility = LinearLayout.GONE
                holder.more.visibility = ImageView.VISIBLE
            }
        }

    }


    override fun getItemCount(): Int {
        return listCard.size
    }
}
