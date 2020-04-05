package com.swapon.simplenetworkoperationusingmvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso
import com.swapon.simplenetworkoperationusingmvvm.R
import com.swapon.simplenetworkoperationusingmvvm.databinding.ItemLayoutUserBinding
import com.swapon.simplenetworkoperationusingmvvm.model.pojo.User

class UserAdapter(private val mContext: Context, private val mData: List<User.UserData>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.item_layout_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvFirstName.text = mData[position].firstName
        holder.tvLastName.text = mData[position].lastName
        holder.tvEmail.text = mData[position].email

        Picasso.get()
                .load(mData[position].avatar)
                //.placeholder(R.drawable.user_placeholder)
                // .error(R.drawable.user_placeholder_error)
                .into(holder.ivProfilePhoto)


    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }


    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFirstName: TextView
        val tvLastName: TextView
        val tvEmail: TextView
        val ivProfilePhoto: ImageView



        init {

            tvFirstName = itemView.findViewById(R.id.tvFirstName)
            tvLastName = itemView.findViewById(R.id.tvLastName)
            tvEmail = itemView.findViewById(R.id.tvEmail)
            ivProfilePhoto = itemView.findViewById(R.id.ivProfilePhoto)
        }
    }
}
