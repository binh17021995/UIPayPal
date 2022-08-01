package com.monstarlab.designui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.monstarlab.designui.PayScreen
import com.monstarlab.designui.R
import com.monstarlab.designui.model.User

class UserAdapter(private var listUser : ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.img.setImageResource(user.avatar)
        holder.userName.text = user.nameUser
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var userName: TextView
        init {
            img = itemView.findViewById(R.id.img_avatar)
            userName = itemView.findViewById(R.id.tv_name_user)

        }

    }
}
