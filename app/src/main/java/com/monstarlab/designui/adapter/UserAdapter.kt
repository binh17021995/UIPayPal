package com.monstarlab.designui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.monstarlab.designui.R
import com.monstarlab.designui.model.User
import com.monstarlab.designui.my_interface.IClickUser

class UserAdapter(private var listUser : ArrayList<User>, val iClickUser : IClickUser) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]
        holder.img.setImageResource(user.avatar)
        holder.userName.text = user.nameUser
        holder.linearAvatar.setOnClickListener {
            iClickUser.ClickUser(user)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var userName: TextView
        var linearAvatar : LinearLayout
        init {
            img = itemView.findViewById(R.id.img_avatar)
            userName = itemView.findViewById(R.id.tv_name_user)
            linearAvatar = itemView.findViewById(R.id.linear_avatar)

        }

    }
}
