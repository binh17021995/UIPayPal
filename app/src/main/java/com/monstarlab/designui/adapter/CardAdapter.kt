package com.monstarlab.designui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.monstarlab.designui.R
import com.monstarlab.designui.model.Card

class CardAdapter(val context: Context, var listCard: ArrayList<Card>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgCard: ImageView
        var tvNameCard: TextView
        var tvAccountNumber: TextView
        var more: ImageView
        var linearLayoutMore: LinearLayout

        init {
            imgCard = itemView.findViewById(R.id.img_card_add)
            tvNameCard = itemView.findViewById(R.id.tv_name_card)
            tvAccountNumber = itemView.findViewById(R.id.account_number)
            more = itemView.findViewById(R.id.img_more)
            linearLayoutMore = itemView.findViewById(R.id.linearlayout_more)
            more.setOnClickListener {
                more.visibility = ImageButton.GONE
                linearLayoutMore.visibility = LinearLayout.VISIBLE
                val editCard: ImageView
                val deleteCard: ImageView
                val exitMore: ImageView
                editCard = itemView.findViewById(R.id.img_edit)
                deleteCard = itemView.findViewById(R.id.img_delete)
                exitMore = itemView.findViewById(R.id.img_exit)
                val position = listCard[adapterPosition]
                deleteCard.setOnClickListener {
                    listCard.removeAt(layoutPosition)
                  Toast.makeText(context, "xóa ", Toast.LENGTH_LONG).show()
                }
                exitMore.setOnClickListener {
                    linearLayoutMore.visibility = LinearLayout.GONE
                    more.visibility = ImageButton.VISIBLE

                }

            }

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
    }

    override fun getItemCount(): Int {
        return listCard.size
    }
}
