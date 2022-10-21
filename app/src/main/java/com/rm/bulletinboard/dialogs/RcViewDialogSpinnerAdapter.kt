package com.rm.bulletinboard.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rm.bulletinboard.R
import com.rm.bulletinboard.act.EditAdsActivity

class RcViewDialogSpinnerAdapter(var tvSelection: TextView, var dialog: AlertDialog) : RecyclerView.Adapter<RcViewDialogSpinnerAdapter.SpViewHolder>() {
    var mainList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sp_list_item, parent, false)
        return SpViewHolder(view, tvSelection, dialog)

    }

    override fun onBindViewHolder(holder: SpViewHolder, position: Int) {
        holder.setData(mainList[position])
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    class SpViewHolder(itemView: View, var tvSelection: TextView,var dialog: Dialog) : RecyclerView.ViewHolder(itemView), OnClickListener {
        private var itemText = ""
        val tvSpItem = itemView.findViewById<TextView>(R.id.tvSpItem)
        fun setData(text : String) {
            tvSpItem.text = text
            itemText = text
            itemView.setOnClickListener(this)

        }

        override fun onClick(view: View?) {
            tvSelection.text = itemText
            dialog.dismiss()
        }
    }

    fun updateAdapter(list: ArrayList<String>) {
        mainList.clear()
        mainList.addAll(list)
        notifyDataSetChanged()
    }
}