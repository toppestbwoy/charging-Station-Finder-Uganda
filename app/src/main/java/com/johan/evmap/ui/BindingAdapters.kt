package com.johan.evmap.ui

import android.content.res.ColorStateList
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.johan.evmap.R
import com.johan.evmap.api.Chargepoint


@BindingAdapter("goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("invisibleUnless")
fun invisibleUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("isFabActive")
fun isFabActive(view: FloatingActionButton, isColored: Boolean) {
    val color = TypedValue()
    if (isColored) {
        view.context.theme.resolveAttribute(R.attr.colorAccent, color, true)
    } else {
        view.context.theme.resolveAttribute(R.attr.colorControlNormal, color, true)
    }
    view.imageTintList = ColorStateList.valueOf(color.data)
}

@BindingAdapter("data")
fun <T> setRecyclerViewData(recyclerView: RecyclerView, items: List<T>?) {
    if (recyclerView.adapter is ListAdapter<*, *>) {
        (recyclerView.adapter as ListAdapter<T, *>).submitList(items)
    }
}

@BindingAdapter("data")
fun <T> setRecyclerViewData(recyclerView: ViewPager2, items: List<T>?) {
    if (recyclerView.adapter is ListAdapter<*, *>) {
        (recyclerView.adapter as ListAdapter<T, *>).submitList(items)
    }
}

@BindingAdapter("connectorIcon")
fun getConnectorItem(view: ImageView, type: String) {
    view.setImageResource(
        when (type) {
            Chargepoint.CCS -> R.drawable.ic_connector_ccs
            Chargepoint.CHADEMO -> R.drawable.ic_connector_chademo
            Chargepoint.SCHUKO -> R.drawable.ic_connector_schuko
            Chargepoint.SUPERCHARGER -> R.drawable.ic_connector_supercharger
            Chargepoint.TYPE_2 -> R.drawable.ic_connector_typ2
            // TODO: add other connectors
            else -> 0
        }
    )
}

@BindingAdapter("srcCompat")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("android:contentDescription")
fun setContentDescriptionResource(imageView: ImageView, resource: Int) {
    imageView.contentDescription = imageView.context.getString(resource)
}